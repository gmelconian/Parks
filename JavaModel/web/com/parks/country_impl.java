package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class country_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      gxfirstwebparm_bkp = gxfirstwebparm ;
      gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         dyncall( httpContext.GetNextPar( )) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridcountry_city") == 0 )
      {
         nRC_GXsfl_48 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_48"))) ;
         nGXsfl_48_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_48_idx"))) ;
         sGXsfl_48_idx = httpContext.GetPar( "sGXsfl_48_idx") ;
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridcountry_city_newrow( ) ;
         return  ;
      }
      else
      {
         if ( ! httpContext.IsValidAjaxCall( false) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = gxfirstwebparm_bkp ;
      }
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CountryId), 4, 0));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCOUNTRYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CountryId), "ZZZ9")));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_web_controls( ) ;
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_5-152925", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Country", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCountryName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("Carmine");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public country_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public country_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( country_impl.class ));
   }

   public country_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.parks.rwdmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! com.parks.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "WWAdvancedContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, divTitlecontainer_Internalname, 1, 0, "px", 0, "px", "TableTop", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.parks.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Country", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, divFormcontainer_Internalname, 1, 0, "px", 0, "px", "FormContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, divToolbarcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3 ToolbarCellClass", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "btn-group", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
      ClassString = "BtnFirst" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCellAdvanced", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtCountryId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtCountryId_Internalname, GXutil.ltrim( localUtil.ntoc( A12CountryId, (byte)(4), (byte)(0), ",", "")), ((edtCountryId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A12CountryId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A12CountryId), "ZZZ9")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtCountryName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtCountryName_Internalname, GXutil.rtrim( A13CountryName), GXutil.rtrim( localUtil.format( A13CountryName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 LevelTable", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, divCitytable_Internalname, 1, 0, "px", 0, "px", "LevelTable", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Text block */
      com.parks.GxWebStd.gx_label_ctrl( httpContext, lblTitlecity_Internalname, "City", "", "", lblTitlecity_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      gxdraw_gridcountry_city( ) ;
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group Confirm", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridcountry_city( )
   {
      /*  Grid Control  */
      Gridcountry_cityContainer.AddObjectProperty("GridName", "Gridcountry_city");
      Gridcountry_cityContainer.AddObjectProperty("Header", subGridcountry_city_Header);
      Gridcountry_cityContainer.AddObjectProperty("Class", "Grid");
      Gridcountry_cityContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridcountry_city_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddObjectProperty("CmpContext", "");
      Gridcountry_cityContainer.AddObjectProperty("InMasterPage", "false");
      Gridcountry_cityColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridcountry_cityColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ".", "")));
      Gridcountry_cityColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCityId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddColumnProperties(Gridcountry_cityColumn);
      Gridcountry_cityColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridcountry_cityColumn.AddObjectProperty("Value", GXutil.rtrim( A25CityName));
      Gridcountry_cityColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCityName_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddColumnProperties(Gridcountry_cityColumn);
      Gridcountry_cityContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridcountry_city_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridcountry_city_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridcountry_city_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridcountry_city_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridcountry_city_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridcountry_city_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridcountry_cityContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridcountry_city_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_48_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount7 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_7 = (short)(1) ;
            scanStart037( ) ;
            while ( RcdFound7 != 0 )
            {
               init_level_properties7( ) ;
               getByPrimaryKey037( ) ;
               addRow037( ) ;
               scanNext037( ) ;
            }
            scanEnd037( ) ;
            nBlankRcdCount7 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal037( ) ;
         standaloneModal037( ) ;
         sMode7 = Gx_mode ;
         while ( nGXsfl_48_idx < nRC_GXsfl_48 )
         {
            bGXsfl_48_Refreshing = true ;
            readRow037( ) ;
            edtCityId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CITYID_"+sGXsfl_48_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityId_Enabled), 5, 0), !bGXsfl_48_Refreshing);
            edtCityName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CITYNAME_"+sGXsfl_48_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCityName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityName_Enabled), 5, 0), !bGXsfl_48_Refreshing);
            if ( ( nRcdExists_7 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal037( ) ;
            }
            sendRow037( ) ;
            bGXsfl_48_Refreshing = false ;
         }
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount7 = (short)(5) ;
         nRcdExists_7 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart037( ) ;
            while ( RcdFound7 != 0 )
            {
               sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_487( ) ;
               init_level_properties7( ) ;
               standaloneNotModal037( ) ;
               getByPrimaryKey037( ) ;
               standaloneModal037( ) ;
               addRow037( ) ;
               scanNext037( ) ;
            }
            scanEnd037( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode7 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_487( ) ;
         initAll037( ) ;
         init_level_properties7( ) ;
         nRcdExists_7 = (short)(0) ;
         nIsMod_7 = (short)(0) ;
         nRcdDeleted_7 = (short)(0) ;
         nBlankRcdCount7 = (short)(nBlankRcdUsr7+nBlankRcdCount7) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount7 > 0 )
         {
            standaloneNotModal037( ) ;
            standaloneModal037( ) ;
            addRow037( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtCityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount7 = (short)(nBlankRcdCount7-1) ;
         }
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridcountry_cityContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridcountry_city", Gridcountry_cityContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.parks.GxWebStd.gx_hidden_field( httpContext, "Gridcountry_cityContainerData", Gridcountry_cityContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.parks.GxWebStd.gx_hidden_field( httpContext, "Gridcountry_cityContainerData"+"V", Gridcountry_cityContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridcountry_cityContainerData"+"V"+"\" value='"+Gridcountry_cityContainer.GridValuesHidden()+"'/>") ;
      }
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11032 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z12CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "Z12CountryId"), ",", ".")) ;
            Z13CountryName = httpContext.cgiGet( "Z13CountryName") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_48 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_48"), ",", ".")) ;
            AV7CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "vCOUNTRYID"), ",", ".")) ;
            AV11Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            /* Read variables values. */
            A12CountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
            A13CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Country");
            A12CountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
            forbiddenHiddens.add("CountryId", localUtil.format( DecimalUtil.doubleToDec(A12CountryId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A12CountryId != Z12CountryId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("country:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A12CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode3 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode3 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound3 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_030( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "COUNTRYID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCountryId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11032 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12032 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e12032 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll033( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
         }
         disableAttributes033( ) ;
      }
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_030( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls033( ) ;
         }
         else
         {
            checkExtendedTable033( ) ;
            closeExtendedTableCursors033( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode3 = Gx_mode ;
         confirm_037( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode3 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_037( )
   {
      nGXsfl_48_idx = 0 ;
      while ( nGXsfl_48_idx < nRC_GXsfl_48 )
      {
         readRow037( ) ;
         if ( ( nRcdExists_7 != 0 ) || ( nIsMod_7 != 0 ) )
         {
            getKey037( ) ;
            if ( ( nRcdExists_7 == 0 ) && ( nRcdDeleted_7 == 0 ) )
            {
               if ( RcdFound7 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate037( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable037( ) ;
                     closeExtendedTableCursors037( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CITYID_" + sGXsfl_48_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCityId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound7 != 0 )
               {
                  if ( nRcdDeleted_7 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey037( ) ;
                     load037( ) ;
                     beforeValidate037( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls037( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_7 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate037( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable037( ) ;
                           closeExtendedTableCursors037( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_7 == 0 )
                  {
                     GXCCtl = "CITYID_" + sGXsfl_48_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCityId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCityId_Internalname, GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtCityName_Internalname, GXutil.rtrim( A25CityName)) ;
         httpContext.changePostValue( "ZT_"+"Z24CityId_"+sGXsfl_48_idx, GXutil.ltrim( localUtil.ntoc( Z24CityId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z25CityName_"+sGXsfl_48_idx, GXutil.rtrim( Z25CityName)) ;
         httpContext.changePostValue( "nRcdDeleted_7_"+sGXsfl_48_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_7, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_7_"+sGXsfl_48_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_7, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_7_"+sGXsfl_48_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_7, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_7 != 0 )
         {
            httpContext.changePostValue( "CITYID_"+sGXsfl_48_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CITYNAME_"+sGXsfl_48_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption030( )
   {
   }

   public void e11032( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.parks.isauthorized(remoteHandle, context).executeUdp( AV11Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.parks.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
   }

   public void e12032( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.parks.wwcountry", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm033( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z13CountryName = T00035_A13CountryName[0] ;
         }
         else
         {
            Z13CountryName = A13CountryName ;
         }
      }
      if ( GX_JID == -3 )
      {
         Z12CountryId = A12CountryId ;
         Z13CountryName = A13CountryName ;
      }
   }

   public void standaloneNotModal( )
   {
      edtCountryId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryId_Enabled), 5, 0), true);
      edtCountryId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryId_Enabled), 5, 0), true);
      bttBtn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CountryId) )
      {
         A12CountryId = AV7CountryId ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
   }

   public void load033( )
   {
      /* Using cursor T00036 */
      pr_default.execute(4, new Object[] {Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A13CountryName = T00036_A13CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
         zm033( -3) ;
      }
      pr_default.close(4);
      onLoadActions033( ) ;
   }

   public void onLoadActions033( )
   {
      AV11Pgmname = "Country" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Pgmname", AV11Pgmname);
   }

   public void checkExtendedTable033( )
   {
      nIsDirty_3 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV11Pgmname = "Country" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Pgmname", AV11Pgmname);
      /* Using cursor T00037 */
      pr_default.execute(5, new Object[] {A13CountryName, Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {"Country Name"}), 1, "COUNTRYNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(5);
   }

   public void closeExtendedTableCursors033( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey033( )
   {
      /* Using cursor T00038 */
      pr_default.execute(6, new Object[] {Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound3 = (short)(1) ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00035 */
      pr_default.execute(3, new Object[] {Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm033( 3) ;
         RcdFound3 = (short)(1) ;
         A12CountryId = T00035_A12CountryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
         A13CountryName = T00035_A13CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
         Z12CountryId = A12CountryId ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load033( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey033( ) ;
         }
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey033( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey033( ) ;
      if ( RcdFound3 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T00039 */
      pr_default.execute(7, new Object[] {Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00039_A12CountryId[0] < A12CountryId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00039_A12CountryId[0] > A12CountryId ) ) )
         {
            A12CountryId = T00039_A12CountryId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T000310 */
      pr_default.execute(8, new Object[] {Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000310_A12CountryId[0] > A12CountryId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000310_A12CountryId[0] < A12CountryId ) ) )
         {
            A12CountryId = T000310_A12CountryId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey033( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCountryName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert033( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound3 == 1 )
         {
            if ( A12CountryId != Z12CountryId )
            {
               A12CountryId = Z12CountryId ;
               httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "COUNTRYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCountryId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCountryName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update033( ) ;
               GX_FocusControl = edtCountryName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A12CountryId != Z12CountryId )
            {
               /* Insert record */
               GX_FocusControl = edtCountryName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert033( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "COUNTRYID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCountryId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCountryName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert033( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( A12CountryId != Z12CountryId )
      {
         A12CountryId = Z12CountryId ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "COUNTRYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCountryName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency033( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00034 */
         pr_default.execute(2, new Object[] {Short.valueOf(A12CountryId)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Country"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z13CountryName, T00034_A13CountryName[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z13CountryName, T00034_A13CountryName[0]) != 0 )
            {
               GXutil.writeLogln("country:[seudo value changed for attri]"+"CountryName");
               GXutil.writeLogRaw("Old: ",Z13CountryName);
               GXutil.writeLogRaw("Current: ",T00034_A13CountryName[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Country"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         zm033( 0) ;
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert033( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000311 */
                  pr_default.execute(9, new Object[] {A13CountryName});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000312 */
                  pr_default.execute(10);
                  A12CountryId = T000312_A12CountryId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Country");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel033( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption030( ) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load033( ) ;
         }
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void update033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate033( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000313 */
                  pr_default.execute(11, new Object[] {A13CountryName, Short.valueOf(A12CountryId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Country");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Country"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate033( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel033( ) ;
                        if ( AnyError == 0 )
                        {
                           if ( isUpd( ) || isDlt( ) )
                           {
                              if ( AnyError == 0 )
                              {
                                 httpContext.nUserReturn = (byte)(1) ;
                              }
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void deferredUpdate033( )
   {
   }

   public void delete( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls033( ) ;
         afterConfirm033( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete033( ) ;
            if ( AnyError == 0 )
            {
               scanStart037( ) ;
               while ( RcdFound7 != 0 )
               {
                  getByPrimaryKey037( ) ;
                  delete037( ) ;
                  scanNext037( ) ;
               }
               scanEnd037( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000314 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A12CountryId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Country");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
      sMode3 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel033( ) ;
      Gx_mode = sMode3 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls033( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV11Pgmname = "Country" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11Pgmname", AV11Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000315 */
         pr_default.execute(13, new Object[] {Short.valueOf(A12CountryId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Amusement Park"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void processNestedLevel037( )
   {
      nGXsfl_48_idx = 0 ;
      while ( nGXsfl_48_idx < nRC_GXsfl_48 )
      {
         readRow037( ) ;
         if ( ( nRcdExists_7 != 0 ) || ( nIsMod_7 != 0 ) )
         {
            standaloneNotModal037( ) ;
            getKey037( ) ;
            if ( ( nRcdExists_7 == 0 ) && ( nRcdDeleted_7 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert037( ) ;
            }
            else
            {
               if ( RcdFound7 != 0 )
               {
                  if ( ( nRcdDeleted_7 != 0 ) && ( nRcdExists_7 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete037( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_7 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update037( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_7 == 0 )
                  {
                     GXCCtl = "CITYID_" + sGXsfl_48_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCityId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCityId_Internalname, GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtCityName_Internalname, GXutil.rtrim( A25CityName)) ;
         httpContext.changePostValue( "ZT_"+"Z24CityId_"+sGXsfl_48_idx, GXutil.ltrim( localUtil.ntoc( Z24CityId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z25CityName_"+sGXsfl_48_idx, GXutil.rtrim( Z25CityName)) ;
         httpContext.changePostValue( "nRcdDeleted_7_"+sGXsfl_48_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_7, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_7_"+sGXsfl_48_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_7, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_7_"+sGXsfl_48_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_7, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_7 != 0 )
         {
            httpContext.changePostValue( "CITYID_"+sGXsfl_48_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CITYNAME_"+sGXsfl_48_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll037( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_7 = (short)(0) ;
      nIsMod_7 = (short)(0) ;
      nRcdDeleted_7 = (short)(0) ;
   }

   public void processLevel033( )
   {
      /* Save parent mode. */
      sMode3 = Gx_mode ;
      processNestedLevel037( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode3 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel033( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete033( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "country");
         if ( AnyError == 0 )
         {
            confirmValues030( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "country");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart033( )
   {
      /* Scan By routine */
      /* Using cursor T000316 */
      pr_default.execute(14);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A12CountryId = T000316_A12CountryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext033( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A12CountryId = T000316_A12CountryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
      }
   }

   public void scanEnd033( )
   {
      pr_default.close(14);
   }

   public void afterConfirm033( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert033( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate033( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete033( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete033( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate033( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes033( )
   {
      edtCountryId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryId_Enabled), 5, 0), true);
      edtCountryName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryName_Enabled), 5, 0), true);
   }

   public void zm037( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z25CityName = T00033_A25CityName[0] ;
         }
         else
         {
            Z25CityName = A25CityName ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z12CountryId = A12CountryId ;
         Z24CityId = A24CityId ;
         Z25CityName = A25CityName ;
      }
   }

   public void standaloneNotModal037( )
   {
   }

   public void standaloneModal037( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCityId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityId_Enabled), 5, 0), !bGXsfl_48_Refreshing);
      }
      else
      {
         edtCityId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityId_Enabled), 5, 0), !bGXsfl_48_Refreshing);
      }
   }

   public void load037( )
   {
      /* Using cursor T000317 */
      pr_default.execute(15, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A25CityName = T000317_A25CityName[0] ;
         zm037( -5) ;
      }
      pr_default.close(15);
      onLoadActions037( ) ;
   }

   public void onLoadActions037( )
   {
   }

   public void checkExtendedTable037( )
   {
      nIsDirty_7 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal037( ) ;
   }

   public void closeExtendedTableCursors037( )
   {
   }

   public void enableDisable037( )
   {
   }

   public void getKey037( )
   {
      /* Using cursor T000318 */
      pr_default.execute(16, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound7 = (short)(1) ;
      }
      else
      {
         RcdFound7 = (short)(0) ;
      }
      pr_default.close(16);
   }

   public void getByPrimaryKey037( )
   {
      /* Using cursor T00033 */
      pr_default.execute(1, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm037( 5) ;
         RcdFound7 = (short)(1) ;
         initializeNonKey037( ) ;
         A24CityId = T00033_A24CityId[0] ;
         A25CityName = T00033_A25CityName[0] ;
         Z12CountryId = A12CountryId ;
         Z24CityId = A24CityId ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load037( ) ;
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound7 = (short)(0) ;
         initializeNonKey037( ) ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal037( ) ;
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes037( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency037( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00032 */
         pr_default.execute(0, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CountryCity"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z25CityName, T00032_A25CityName[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z25CityName, T00032_A25CityName[0]) != 0 )
            {
               GXutil.writeLogln("country:[seudo value changed for attri]"+"CityName");
               GXutil.writeLogRaw("Old: ",Z25CityName);
               GXutil.writeLogRaw("Current: ",T00032_A25CityName[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CountryCity"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert037( )
   {
      beforeValidate037( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable037( ) ;
      }
      if ( AnyError == 0 )
      {
         zm037( 0) ;
         checkOptimisticConcurrency037( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm037( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert037( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000319 */
                  pr_default.execute(17, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId), A25CityName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CountryCity");
                  if ( (pr_default.getStatus(17) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load037( ) ;
         }
         endLevel037( ) ;
      }
      closeExtendedTableCursors037( ) ;
   }

   public void update037( )
   {
      beforeValidate037( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable037( ) ;
      }
      if ( ( nIsMod_7 != 0 ) || ( nIsDirty_7 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency037( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm037( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate037( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000320 */
                     pr_default.execute(18, new Object[] {A25CityName, Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("CountryCity");
                     if ( (pr_default.getStatus(18) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CountryCity"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate037( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey037( ) ;
                        }
                     }
                     else
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                        AnyError = (short)(1) ;
                     }
                  }
               }
            }
            endLevel037( ) ;
         }
      }
      closeExtendedTableCursors037( ) ;
   }

   public void deferredUpdate037( )
   {
   }

   public void delete037( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate037( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency037( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls037( ) ;
         afterConfirm037( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete037( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000321 */
               pr_default.execute(19, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CountryCity");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode7 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel037( ) ;
      Gx_mode = sMode7 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls037( )
   {
      standaloneModal037( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor T000322 */
         pr_default.execute(20, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Technician"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
         /* Using cursor T000323 */
         pr_default.execute(21, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Amusement Park"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
      }
   }

   public void endLevel037( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart037( )
   {
      /* Scan By routine */
      /* Using cursor T000324 */
      pr_default.execute(22, new Object[] {Short.valueOf(A12CountryId)});
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A24CityId = T000324_A24CityId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext037( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A24CityId = T000324_A24CityId[0] ;
      }
   }

   public void scanEnd037( )
   {
      pr_default.close(22);
   }

   public void afterConfirm037( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert037( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate037( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete037( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete037( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate037( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes037( )
   {
      edtCityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityId_Enabled), 5, 0), !bGXsfl_48_Refreshing);
      edtCityName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCityName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityName_Enabled), 5, 0), !bGXsfl_48_Refreshing);
   }

   public void send_integrity_lvl_hashes037( )
   {
   }

   public void send_integrity_lvl_hashes033( )
   {
   }

   public void subsflControlProps_487( )
   {
      edtCityId_Internalname = "CITYID_"+sGXsfl_48_idx ;
      edtCityName_Internalname = "CITYNAME_"+sGXsfl_48_idx ;
   }

   public void subsflControlProps_fel_487( )
   {
      edtCityId_Internalname = "CITYID_"+sGXsfl_48_fel_idx ;
      edtCityName_Internalname = "CITYNAME_"+sGXsfl_48_fel_idx ;
   }

   public void addRow037( )
   {
      nGXsfl_48_idx = (int)(nGXsfl_48_idx+1) ;
      sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_487( ) ;
      sendRow037( ) ;
   }

   public void sendRow037( )
   {
      Gridcountry_cityRow = GXWebRow.GetNew(context) ;
      if ( subGridcountry_city_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridcountry_city_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridcountry_city_Class, "") != 0 )
         {
            subGridcountry_city_Linesclass = subGridcountry_city_Class+"Odd" ;
         }
      }
      else if ( subGridcountry_city_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridcountry_city_Backstyle = (byte)(0) ;
         subGridcountry_city_Backcolor = subGridcountry_city_Allbackcolor ;
         if ( GXutil.strcmp(subGridcountry_city_Class, "") != 0 )
         {
            subGridcountry_city_Linesclass = subGridcountry_city_Class+"Uniform" ;
         }
      }
      else if ( subGridcountry_city_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridcountry_city_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridcountry_city_Class, "") != 0 )
         {
            subGridcountry_city_Linesclass = subGridcountry_city_Class+"Odd" ;
         }
         subGridcountry_city_Backcolor = (int)(0x0) ;
      }
      else if ( subGridcountry_city_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridcountry_city_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_48_idx) % (2))) == 0 )
         {
            subGridcountry_city_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridcountry_city_Class, "") != 0 )
            {
               subGridcountry_city_Linesclass = subGridcountry_city_Class+"Even" ;
            }
         }
         else
         {
            subGridcountry_city_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridcountry_city_Class, "") != 0 )
            {
               subGridcountry_city_Linesclass = subGridcountry_city_Class+"Odd" ;
            }
         }
      }
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /*
         Assignment error:
         ================
         Expression: [ t('iif(',1),t('Gx_mode',23),t(=,10),t('''DSP''',3),t('OR',9),t('Gx_mode',23),t(=,10),t('''UPD''',3),t(',',7),t('""',3),t(',',7),t('"javascript:"',3),t(+,5),t('"gx.popup.openPrompt(''"',3),t(+,5),t('"com.parks.gx0071"',3),t(+,5),t('"'',["',3),t(+,5),t('"''"',3),t(+,5),t('htmlencode(',1),t('strreplace(',1),t('ltrim(',1),t('ntoc(',1),t(12,2),t(',',7),t(4,3),t(',',7),t(0,3),t(',',7),t('"."',3),t(',',7),t('""',3),t(')',4),t(')',4),t(',',7),t('"''"',3),t(',',7),t('"\''"',3),t(')',4),t(')',4),t(+,5),t('"''"',3),t(+,5),t('","',3),t(+,5),t('"{Ctrl:gx.dom.el(''"',3),t(+,5),t('"CITYID_"',3),t(+,5),t(sGXsfl_48_idx,23),t(+,5),t('"''), id:''"',3),t(+,5),t('"CITYID_"',3),t(+,5),t(sGXsfl_48_idx,23),t(+,5),t('"''"',3),t(+,5),t('",IOType:''out''}"',3),t(+,5),t('"],"',3),t(+,5),t('"gx.dom.form()."',3),t(+,5),t('"nIsMod_7_"',3),t(+,5),t(sGXsfl_48_idx,23),t(+,5),t('","',3),t(+,5),t('"'''', false"',3),t(+,5),t('","',3),t(+,5),t('"false"',3),t(+,5),t('");"',3),t(')',4) ]
         Target    : [ t(prompt_12,3),t('Link',3) ]
         ForType   : 29
         Type      : []
      */
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_7_" + sGXsfl_48_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 49,'',false,'" + sGXsfl_48_idx + "',48)\"" ;
      ROClassString = "Attribute" ;
      Gridcountry_cityRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCityId_Internalname,GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A24CityId), "ZZZ9")),TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,49);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtCityId_Enabled),Integer.valueOf(1),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(48),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_7_" + sGXsfl_48_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 50,'',false,'" + sGXsfl_48_idx + "',48)\"" ;
      ROClassString = "Attribute" ;
      Gridcountry_cityRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCityName_Internalname,GXutil.rtrim( A25CityName),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCityName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtCityName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(48),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridcountry_cityRow);
      send_integrity_lvl_hashes037( ) ;
      GXCCtl = "Z24CityId_" + sGXsfl_48_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z24CityId, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "Z25CityName_" + sGXsfl_48_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z25CityName));
      GXCCtl = "nRcdDeleted_7_" + sGXsfl_48_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_7, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_7_" + sGXsfl_48_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_7, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_7_" + sGXsfl_48_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_7, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "vMODE_" + sGXsfl_48_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_48_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV9TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV9TrnContext);
      }
      GXCCtl = "vCOUNTRYID_" + sGXsfl_48_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CountryId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "CITYID_"+sGXsfl_48_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "CITYNAME_"+sGXsfl_48_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityName_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridcountry_cityContainer.AddRow(Gridcountry_cityRow);
   }

   public void readRow037( )
   {
      nGXsfl_48_idx = (int)(nGXsfl_48_idx+1) ;
      sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_487( ) ;
      edtCityId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CITYID_"+sGXsfl_48_idx+"Enabled"), ",", ".")) ;
      edtCityName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CITYNAME_"+sGXsfl_48_idx+"Enabled"), ",", ".")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCityId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCityId_Internalname), ",", ".") > 9999 ) ) )
      {
         GXCCtl = "CITYID_" + sGXsfl_48_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCityId_Internalname ;
         wbErr = true ;
         A24CityId = (short)(0) ;
      }
      else
      {
         A24CityId = (short)(localUtil.ctol( httpContext.cgiGet( edtCityId_Internalname), ",", ".")) ;
      }
      A25CityName = httpContext.cgiGet( edtCityName_Internalname) ;
      GXCCtl = "Z24CityId_" + sGXsfl_48_idx ;
      Z24CityId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "Z25CityName_" + sGXsfl_48_idx ;
      Z25CityName = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_7_" + sGXsfl_48_idx ;
      nRcdDeleted_7 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_7_" + sGXsfl_48_idx ;
      nRcdExists_7 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_7_" + sGXsfl_48_idx ;
      nIsMod_7 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void assign_properties_default( )
   {
      defedtCityId_Enabled = edtCityId_Enabled ;
   }

   public void confirmValues030( )
   {
      nGXsfl_48_idx = 0 ;
      sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_487( ) ;
      while ( nGXsfl_48_idx < nRC_GXsfl_48 )
      {
         nGXsfl_48_idx = (int)(nGXsfl_48_idx+1) ;
         sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_487( ) ;
         httpContext.changePostValue( "Z24CityId_"+sGXsfl_48_idx, httpContext.cgiGet( "ZT_"+"Z24CityId_"+sGXsfl_48_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z24CityId_"+sGXsfl_48_idx) ;
         httpContext.changePostValue( "Z25CityName_"+sGXsfl_48_idx, httpContext.cgiGet( "ZT_"+"Z25CityName_"+sGXsfl_48_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z25CityName_"+sGXsfl_48_idx) ;
      }
   }

   public void renderHtmlHeaders( )
   {
      com.parks.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      MasterPageObj.master_styles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?20211071155286", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.parks.country", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CountryId,4,0))}, new String[] {"Gx_mode","CountryId"}) +"\">") ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:none\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Country");
      forbiddenHiddens.add("CountryId", localUtil.format( DecimalUtil.doubleToDec(A12CountryId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("country:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z12CountryId", GXutil.ltrim( localUtil.ntoc( Z12CountryId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z13CountryName", GXutil.rtrim( Z13CountryName));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_48", GXutil.ltrim( localUtil.ntoc( nGXsfl_48_idx, (byte)(8), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV9TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV9TrnContext);
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV9TrnContext));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vCOUNTRYID", GXutil.ltrim( localUtil.ntoc( AV7CountryId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCOUNTRYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CountryId), "ZZZ9")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV11Pgmname));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      com.parks.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.parks.country", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CountryId,4,0))}, new String[] {"Gx_mode","CountryId"})  ;
   }

   public String getPgmname( )
   {
      return "Country" ;
   }

   public String getPgmdesc( )
   {
      return "Country" ;
   }

   public void initializeNonKey033( )
   {
      A13CountryName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
      Z13CountryName = "" ;
   }

   public void initAll033( )
   {
      A12CountryId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
      initializeNonKey033( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey037( )
   {
      A25CityName = "" ;
      Z25CityName = "" ;
   }

   public void initAll037( )
   {
      A24CityId = (short)(0) ;
      initializeNonKey037( ) ;
   }

   public void standaloneModalInsert037( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20211071155293", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages.spa.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("country.js", "?20211071155294", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties7( )
   {
      edtCityId_Enabled = defedtCityId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityId_Enabled), 5, 0), !bGXsfl_48_Refreshing);
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      divTitlecontainer_Internalname = "TITLECONTAINER" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      divToolbarcell_Internalname = "TOOLBARCELL" ;
      edtCountryId_Internalname = "COUNTRYID" ;
      edtCountryName_Internalname = "COUNTRYNAME" ;
      lblTitlecity_Internalname = "TITLECITY" ;
      edtCityId_Internalname = "CITYID" ;
      edtCityName_Internalname = "CITYNAME" ;
      divCitytable_Internalname = "CITYTABLE" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridcountry_city_Internalname = "GRIDCOUNTRY_CITY" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("Carmine");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Country" );
      edtCityName_Jsonclick = "" ;
      edtCityId_Jsonclick = "" ;
      subGridcountry_city_Class = "Grid" ;
      subGridcountry_city_Backcolorstyle = (byte)(0) ;
      subGridcountry_city_Allowcollapsing = (byte)(0) ;
      subGridcountry_city_Allowselection = (byte)(0) ;
      edtCityName_Enabled = 1 ;
      edtCityId_Enabled = 1 ;
      subGridcountry_city_Header = "" ;
      bttBtn_delete_Enabled = 0 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtCountryName_Jsonclick = "" ;
      edtCountryName_Enabled = 1 ;
      edtCountryId_Jsonclick = "" ;
      edtCountryId_Enabled = 0 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridcountry_city_newrow( )
   {
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_487( ) ;
      while ( nGXsfl_48_idx <= nRC_GXsfl_48 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal037( ) ;
         standaloneModal037( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow037( ) ;
         nGXsfl_48_idx = (int)(nGXsfl_48_idx+1) ;
         sGXsfl_48_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_48_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_487( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridcountry_cityContainer)) ;
      /* End function gxnrGridcountry_city_newrow */
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Countryname( )
   {
      /* Using cursor T000325 */
      pr_default.execute(23, new Object[] {A13CountryName, Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(23) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {"Country Name"}), 1, "COUNTRYNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryName_Internalname ;
      }
      pr_default.close(23);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CountryId',fld:'vCOUNTRYID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7CountryId',fld:'vCOUNTRYID',pic:'ZZZ9',hsh:true},{av:'A12CountryId',fld:'COUNTRYID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12032',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_COUNTRYID","{handler:'valid_Countryid',iparms:[]");
      setEventMetadata("VALID_COUNTRYID",",oparms:[]}");
      setEventMetadata("VALID_COUNTRYNAME","{handler:'valid_Countryname',iparms:[{av:'A13CountryName',fld:'COUNTRYNAME',pic:''},{av:'A12CountryId',fld:'COUNTRYID',pic:'ZZZ9'}]");
      setEventMetadata("VALID_COUNTRYNAME",",oparms:[]}");
      setEventMetadata("VALID_CITYID","{handler:'valid_Cityid',iparms:[]");
      setEventMetadata("VALID_CITYID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Cityname',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z13CountryName = "" ;
      Z25CityName = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A13CountryName = "" ;
      lblTitlecity_Jsonclick = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gridcountry_cityContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridcountry_cityColumn = new com.genexus.webpanels.GXWebColumn();
      A25CityName = "" ;
      sMode7 = "" ;
      sStyleString = "" ;
      AV11Pgmname = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode3 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      AV9TrnContext = new com.parks.SdtTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      T00036_A12CountryId = new short[1] ;
      T00036_A13CountryName = new String[] {""} ;
      T00037_A13CountryName = new String[] {""} ;
      T00038_A12CountryId = new short[1] ;
      T00035_A12CountryId = new short[1] ;
      T00035_A13CountryName = new String[] {""} ;
      T00039_A12CountryId = new short[1] ;
      T000310_A12CountryId = new short[1] ;
      T00034_A12CountryId = new short[1] ;
      T00034_A13CountryName = new String[] {""} ;
      T000312_A12CountryId = new short[1] ;
      T000315_A7AmusementParkId = new short[1] ;
      T000316_A12CountryId = new short[1] ;
      T000317_A12CountryId = new short[1] ;
      T000317_A24CityId = new short[1] ;
      T000317_A25CityName = new String[] {""} ;
      T000318_A12CountryId = new short[1] ;
      T000318_A24CityId = new short[1] ;
      T00033_A12CountryId = new short[1] ;
      T00033_A24CityId = new short[1] ;
      T00033_A25CityName = new String[] {""} ;
      T00032_A12CountryId = new short[1] ;
      T00032_A24CityId = new short[1] ;
      T00032_A25CityName = new String[] {""} ;
      T000322_A30TechnicianId = new short[1] ;
      T000323_A7AmusementParkId = new short[1] ;
      T000324_A12CountryId = new short[1] ;
      T000324_A24CityId = new short[1] ;
      Gridcountry_cityRow = new com.genexus.webpanels.GXWebRow();
      subGridcountry_city_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T000325_A13CountryName = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.country__default(),
         new Object[] {
             new Object[] {
            T00032_A12CountryId, T00032_A24CityId, T00032_A25CityName
            }
            , new Object[] {
            T00033_A12CountryId, T00033_A24CityId, T00033_A25CityName
            }
            , new Object[] {
            T00034_A12CountryId, T00034_A13CountryName
            }
            , new Object[] {
            T00035_A12CountryId, T00035_A13CountryName
            }
            , new Object[] {
            T00036_A12CountryId, T00036_A13CountryName
            }
            , new Object[] {
            T00037_A13CountryName
            }
            , new Object[] {
            T00038_A12CountryId
            }
            , new Object[] {
            T00039_A12CountryId
            }
            , new Object[] {
            T000310_A12CountryId
            }
            , new Object[] {
            }
            , new Object[] {
            T000312_A12CountryId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000315_A7AmusementParkId
            }
            , new Object[] {
            T000316_A12CountryId
            }
            , new Object[] {
            T000317_A12CountryId, T000317_A24CityId, T000317_A25CityName
            }
            , new Object[] {
            T000318_A12CountryId, T000318_A24CityId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000322_A30TechnicianId
            }
            , new Object[] {
            T000323_A7AmusementParkId
            }
            , new Object[] {
            T000324_A12CountryId, T000324_A24CityId
            }
            , new Object[] {
            T000325_A13CountryName
            }
         }
      );
      AV11Pgmname = "Country" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte subGridcountry_city_Backcolorstyle ;
   private byte subGridcountry_city_Allowselection ;
   private byte subGridcountry_city_Allowhovering ;
   private byte subGridcountry_city_Allowcollapsing ;
   private byte subGridcountry_city_Collapsed ;
   private byte Gx_BScreen ;
   private byte subGridcountry_city_Backstyle ;
   private byte gxajaxcallmode ;
   private short wcpOAV7CountryId ;
   private short Z12CountryId ;
   private short Z24CityId ;
   private short nRcdDeleted_7 ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short AV7CountryId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A12CountryId ;
   private short A24CityId ;
   private short nBlankRcdCount7 ;
   private short RcdFound7 ;
   private short nBlankRcdUsr7 ;
   private short RcdFound3 ;
   private short nIsDirty_3 ;
   private short nIsDirty_7 ;
   private int nRC_GXsfl_48 ;
   private int nGXsfl_48_idx=1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtCountryId_Enabled ;
   private int edtCountryName_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int edtCityId_Enabled ;
   private int edtCityName_Enabled ;
   private int subGridcountry_city_Selectedindex ;
   private int subGridcountry_city_Selectioncolor ;
   private int subGridcountry_city_Hoveringcolor ;
   private int fRowAdded ;
   private int GX_JID ;
   private int subGridcountry_city_Backcolor ;
   private int subGridcountry_city_Allbackcolor ;
   private int defedtCityId_Enabled ;
   private int idxLst ;
   private long GRIDCOUNTRY_CITY_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z13CountryName ;
   private String Z25CityName ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_48_idx="0001" ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCountryName_Internalname ;
   private String divMaintable_Internalname ;
   private String divTitlecontainer_Internalname ;
   private String lblTitle_Internalname ;
   private String lblTitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divFormcontainer_Internalname ;
   private String divToolbarcell_Internalname ;
   private String TempTags ;
   private String bttBtn_first_Internalname ;
   private String bttBtn_first_Jsonclick ;
   private String bttBtn_previous_Internalname ;
   private String bttBtn_previous_Jsonclick ;
   private String bttBtn_next_Internalname ;
   private String bttBtn_next_Jsonclick ;
   private String bttBtn_last_Internalname ;
   private String bttBtn_last_Jsonclick ;
   private String bttBtn_select_Internalname ;
   private String bttBtn_select_Jsonclick ;
   private String edtCountryId_Internalname ;
   private String edtCountryId_Jsonclick ;
   private String A13CountryName ;
   private String edtCountryName_Jsonclick ;
   private String divCitytable_Internalname ;
   private String lblTitlecity_Internalname ;
   private String lblTitlecity_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String subGridcountry_city_Header ;
   private String A25CityName ;
   private String sMode7 ;
   private String edtCityId_Internalname ;
   private String edtCityName_Internalname ;
   private String sStyleString ;
   private String AV11Pgmname ;
   private String hsh ;
   private String sMode3 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_48_fel_idx="0001" ;
   private String subGridcountry_city_Class ;
   private String subGridcountry_city_Linesclass ;
   private String ROClassString ;
   private String edtCityId_Jsonclick ;
   private String edtCityName_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridcountry_city_Internalname ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean bGXsfl_48_Refreshing=false ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private com.genexus.webpanels.GXWebGrid Gridcountry_cityContainer ;
   private com.genexus.webpanels.GXWebRow Gridcountry_cityRow ;
   private com.genexus.webpanels.GXWebColumn Gridcountry_cityColumn ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] T00036_A12CountryId ;
   private String[] T00036_A13CountryName ;
   private String[] T00037_A13CountryName ;
   private short[] T00038_A12CountryId ;
   private short[] T00035_A12CountryId ;
   private String[] T00035_A13CountryName ;
   private short[] T00039_A12CountryId ;
   private short[] T000310_A12CountryId ;
   private short[] T00034_A12CountryId ;
   private String[] T00034_A13CountryName ;
   private short[] T000312_A12CountryId ;
   private short[] T000315_A7AmusementParkId ;
   private short[] T000316_A12CountryId ;
   private short[] T000317_A12CountryId ;
   private short[] T000317_A24CityId ;
   private String[] T000317_A25CityName ;
   private short[] T000318_A12CountryId ;
   private short[] T000318_A24CityId ;
   private short[] T00033_A12CountryId ;
   private short[] T00033_A24CityId ;
   private String[] T00033_A25CityName ;
   private short[] T00032_A12CountryId ;
   private short[] T00032_A24CityId ;
   private String[] T00032_A25CityName ;
   private short[] T000322_A30TechnicianId ;
   private short[] T000323_A7AmusementParkId ;
   private short[] T000324_A12CountryId ;
   private short[] T000324_A24CityId ;
   private String[] T000325_A13CountryName ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.parks.SdtTransactionContext AV9TrnContext ;
}

final  class country__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00032", "SELECT `CountryId`, `CityId`, `CityName` FROM `CountryCity` WHERE `CountryId` = ? AND `CityId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00033", "SELECT `CountryId`, `CityId`, `CityName` FROM `CountryCity` WHERE `CountryId` = ? AND `CityId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00034", "SELECT `CountryId`, `CountryName` FROM `Country` WHERE `CountryId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00035", "SELECT `CountryId`, `CountryName` FROM `Country` WHERE `CountryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00036", "SELECT TM1.`CountryId`, TM1.`CountryName` FROM `Country` TM1 WHERE TM1.`CountryId` = ? ORDER BY TM1.`CountryId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00037", "SELECT `CountryName` FROM `Country` WHERE (`CountryName` = ?) AND (Not ( `CountryId` = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00038", "SELECT `CountryId` FROM `Country` WHERE `CountryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00039", "SELECT `CountryId` FROM `Country` WHERE ( `CountryId` > ?) ORDER BY `CountryId`  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000310", "SELECT `CountryId` FROM `Country` WHERE ( `CountryId` < ?) ORDER BY `CountryId` DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000311", "INSERT INTO `Country`(`CountryName`) VALUES(?)", GX_NOMASK)
         ,new ForEachCursor("T000312", "SELECT LAST_INSERT_ID() ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000313", "UPDATE `Country` SET `CountryName`=?  WHERE `CountryId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000314", "DELETE FROM `Country`  WHERE `CountryId` = ?", GX_NOMASK)
         ,new ForEachCursor("T000315", "SELECT `AmusementParkId` FROM `AmusementPark` WHERE `CountryId` = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000316", "SELECT `CountryId` FROM `Country` ORDER BY `CountryId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000317", "SELECT `CountryId`, `CityId`, `CityName` FROM `CountryCity` WHERE `CountryId` = ? and `CityId` = ? ORDER BY `CountryId`, `CityId` ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000318", "SELECT `CountryId`, `CityId` FROM `CountryCity` WHERE `CountryId` = ? AND `CityId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000319", "INSERT INTO `CountryCity`(`CountryId`, `CityId`, `CityName`) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000320", "UPDATE `CountryCity` SET `CityName`=?  WHERE `CountryId` = ? AND `CityId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000321", "DELETE FROM `CountryCity`  WHERE `CountryId` = ? AND `CityId` = ?", GX_NOMASK)
         ,new ForEachCursor("T000322", "SELECT `TechnicianId` FROM `Technician` WHERE `CountryId` = ? AND `CityId` = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000323", "SELECT `AmusementParkId` FROM `AmusementPark` WHERE `CountryId` = ? AND `CityId` = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000324", "SELECT `CountryId`, `CityId` FROM `CountryCity` WHERE `CountryId` = ? ORDER BY `CountryId`, `CityId` ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000325", "SELECT `CountryName` FROM `Country` WHERE (`CountryName` = ?) AND (Not ( `CountryId` = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 50);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 50);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 50);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 50);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 50);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 50);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 50);
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 50);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 23 :
               stmt.setString(1, (String)parms[0], 50);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}


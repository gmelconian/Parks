package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class amusementpark_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A12CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A12CountryId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A12CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
         A24CityId = (short)(GXutil.lval( httpContext.GetPar( "CityId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CityId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A12CountryId, A24CityId) ;
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
            AV7AmusementParkId = (short)(GXutil.lval( httpContext.GetPar( "AmusementParkId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7AmusementParkId), 4, 0));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAMUSEMENTPARKID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7AmusementParkId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Amusement Park", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtAmusementParkName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("Carmine");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public amusementpark_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public amusementpark_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( amusementpark_impl.class ));
   }

   public amusementpark_impl( int remoteHandle ,
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
      com.parks.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Amusement Park", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_AmusementPark.htm");
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
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_AmusementPark.htm");
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
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAmusementParkId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtAmusementParkId_Internalname, "Park Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtAmusementParkId_Internalname, GXutil.ltrim( localUtil.ntoc( A7AmusementParkId, (byte)(4), (byte)(0), ",", "")), ((edtAmusementParkId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAmusementParkId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAmusementParkId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAmusementParkName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtAmusementParkName_Internalname, "Park Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtAmusementParkName_Internalname, GXutil.rtrim( A8AmusementParkName), GXutil.rtrim( localUtil.format( A8AmusementParkName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAmusementParkName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAmusementParkName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAmusementParkWebSite_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtAmusementParkWebSite_Internalname, "Web Site", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtAmusementParkWebSite_Internalname, GXutil.rtrim( A9AmusementParkWebSite), GXutil.rtrim( localUtil.format( A9AmusementParkWebSite, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAmusementParkWebSite_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAmusementParkWebSite_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAmusementParkAddress_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtAmusementParkAddress_Internalname, "Park Address", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_html_textarea( httpContext, edtAmusementParkAddress_Internalname, A10AmusementParkAddress, "http://maps.google.com/maps?q="+PrivateUtilities.encodeURL( A10AmusementParkAddress), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", (short)(0), 1, edtAmusementParkAddress_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "1024", -1, 0, "_blank", "", (byte)(0), true, "GeneXus\\Address", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgAmusementParkPhoto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, "", "Park Photo", "col-sm-3 ImageAttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "ImageAttribute" ;
      StyleString = "" ;
      A11AmusementParkPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A11AmusementParkPhoto)==0)&&(GXutil.strcmp("", A40000AmusementParkPhoto_GXI)==0))||!(GXutil.strcmp("", A11AmusementParkPhoto)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.getResourceRelative(A11AmusementParkPhoto)) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgAmusementParkPhoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgAmusementParkPhoto_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "", "", "", 0, A11AmusementParkPhoto_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_AmusementPark.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "URL", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.getResourceRelative(A11AmusementParkPhoto)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "IsBlob", GXutil.booltostr( A11AmusementParkPhoto_IsBlob), true);
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtCountryId_Internalname, "Country Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtCountryId_Internalname, GXutil.ltrim( localUtil.ntoc( A12CountryId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A12CountryId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryId_Enabled, 1, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_AmusementPark.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgprompt_12_Internalname, sImgUrl, imgprompt_12_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_12_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_AmusementPark.htm");
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
      com.parks.GxWebStd.gx_label_element( httpContext, edtCountryName_Internalname, "Country Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtCountryName_Internalname, GXutil.rtrim( A13CountryName), GXutil.rtrim( localUtil.format( A13CountryName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCityId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtCityId_Internalname, "City Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtCityId_Internalname, GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A24CityId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCityId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCityId_Enabled, 1, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_AmusementPark.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgprompt_24_Internalname, sImgUrl, imgprompt_24_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_24_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCityName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtCityName_Internalname, "City Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtCityName_Internalname, GXutil.rtrim( A25CityName), GXutil.rtrim( localUtil.format( A25CityName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCityName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCityName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_AmusementPark.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AmusementPark.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      e11022 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( "Z7AmusementParkId"), ",", ".")) ;
            Z8AmusementParkName = httpContext.cgiGet( "Z8AmusementParkName") ;
            Z9AmusementParkWebSite = httpContext.cgiGet( "Z9AmusementParkWebSite") ;
            Z10AmusementParkAddress = httpContext.cgiGet( "Z10AmusementParkAddress") ;
            Z12CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "Z12CountryId"), ",", ".")) ;
            Z24CityId = (short)(localUtil.ctol( httpContext.cgiGet( "Z24CityId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N12CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "N12CountryId"), ",", ".")) ;
            N24CityId = (short)(localUtil.ctol( httpContext.cgiGet( "N24CityId"), ",", ".")) ;
            AV7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( "vAMUSEMENTPARKID"), ",", ".")) ;
            AV11Insert_CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_COUNTRYID"), ",", ".")) ;
            AV12Insert_CityId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CITYID"), ",", ".")) ;
            A40000AmusementParkPhoto_GXI = httpContext.cgiGet( "AMUSEMENTPARKPHOTO_GXI") ;
            AV14Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            /* Read variables values. */
            A7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( edtAmusementParkId_Internalname), ",", ".")) ;
            n7AmusementParkId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
            A8AmusementParkName = httpContext.cgiGet( edtAmusementParkName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
            A9AmusementParkWebSite = httpContext.cgiGet( edtAmusementParkWebSite_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A9AmusementParkWebSite", A9AmusementParkWebSite);
            A10AmusementParkAddress = httpContext.cgiGet( edtAmusementParkAddress_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A10AmusementParkAddress", A10AmusementParkAddress);
            A11AmusementParkPhoto = httpContext.cgiGet( imgAmusementParkPhoto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A11AmusementParkPhoto", A11AmusementParkPhoto);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "COUNTRYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCountryId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A12CountryId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
            }
            else
            {
               A12CountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
            }
            A13CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCityId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCityId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A24CityId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A24CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CityId), 4, 0));
            }
            else
            {
               A24CityId = (short)(localUtil.ctol( httpContext.cgiGet( edtCityId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A24CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CityId), 4, 0));
            }
            A25CityName = httpContext.cgiGet( edtCityName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A25CityName", A25CityName);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A11AmusementParkPhoto ;
            GXv_char2[0] = A40000AmusementParkPhoto_GXI ;
            httpContext.getMultimediaValue(imgAmusementParkPhoto_Internalname, GXv_char1, GXv_char2);
            amusementpark_impl.this.A11AmusementParkPhoto = GXv_char1[0] ;
            amusementpark_impl.this.A40000AmusementParkPhoto_GXI = GXv_char2[0] ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"AmusementPark");
            A7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( edtAmusementParkId_Internalname), ",", ".")) ;
            n7AmusementParkId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
            forbiddenHiddens.add("AmusementParkId", localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A7AmusementParkId != Z7AmusementParkId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("amusementpark:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A7AmusementParkId = (short)(GXutil.lval( httpContext.GetPar( "AmusementParkId"))) ;
               n7AmusementParkId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
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
                  sMode2 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode2 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound2 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_020( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "AMUSEMENTPARKID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtAmusementParkId_Internalname ;
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
                        e11022 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12022 ();
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
         e12022 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll022( ) ;
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
         disableAttributes022( ) ;
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

   public void confirm_020( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls022( ) ;
         }
         else
         {
            checkExtendedTable022( ) ;
            closeExtendedTableCursors022( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption020( )
   {
   }

   public void e11022( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.parks.isauthorized(remoteHandle, context).executeUdp( AV14Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.parks.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      AV11Insert_CountryId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_CountryId), 4, 0));
      AV12Insert_CityId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_CityId), 4, 0));
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtTransactionContext_Transactionname(), AV14Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV15GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15GXV1), 8, 0));
         while ( AV15GXV1 <= AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.parks.SdtTransactionContext_Attribute)((com.parks.SdtTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().elementAt(-1+AV15GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "CountryId") == 0 )
            {
               AV11Insert_CountryId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_CountryId), 4, 0));
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "CityId") == 0 )
            {
               AV12Insert_CityId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_CityId), 4, 0));
            }
            AV15GXV1 = (int)(AV15GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15GXV1), 8, 0));
         }
      }
   }

   public void e12022( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.parks.wwamusementpark", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm022( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z8AmusementParkName = T00023_A8AmusementParkName[0] ;
            Z9AmusementParkWebSite = T00023_A9AmusementParkWebSite[0] ;
            Z10AmusementParkAddress = T00023_A10AmusementParkAddress[0] ;
            Z12CountryId = T00023_A12CountryId[0] ;
            Z24CityId = T00023_A24CityId[0] ;
         }
         else
         {
            Z8AmusementParkName = A8AmusementParkName ;
            Z9AmusementParkWebSite = A9AmusementParkWebSite ;
            Z10AmusementParkAddress = A10AmusementParkAddress ;
            Z12CountryId = A12CountryId ;
            Z24CityId = A24CityId ;
         }
      }
      if ( GX_JID == -11 )
      {
         Z7AmusementParkId = A7AmusementParkId ;
         Z8AmusementParkName = A8AmusementParkName ;
         Z9AmusementParkWebSite = A9AmusementParkWebSite ;
         Z10AmusementParkAddress = A10AmusementParkAddress ;
         Z11AmusementParkPhoto = A11AmusementParkPhoto ;
         Z40000AmusementParkPhoto_GXI = A40000AmusementParkPhoto_GXI ;
         Z12CountryId = A12CountryId ;
         Z24CityId = A24CityId ;
         Z13CountryName = A13CountryName ;
         Z25CityName = A25CityName ;
      }
   }

   public void standaloneNotModal( )
   {
      edtAmusementParkId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkId_Enabled), 5, 0), true);
      imgprompt_12_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.parks.gx0030"+"',["+"{Ctrl:gx.dom.el('"+"COUNTRYID"+"'), id:'"+"COUNTRYID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_24_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.parks.gx0071"+"',["+"{Ctrl:gx.dom.el('"+"COUNTRYID"+"'), id:'"+"COUNTRYID"+"'"+",IOType:'in'}"+","+"{Ctrl:gx.dom.el('"+"CITYID"+"'), id:'"+"CITYID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      edtAmusementParkId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkId_Enabled), 5, 0), true);
      bttBtn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7AmusementParkId) )
      {
         A7AmusementParkId = AV7AmusementParkId ;
         n7AmusementParkId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_CountryId) )
      {
         edtCountryId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCountryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryId_Enabled), 5, 0), true);
      }
      else
      {
         edtCountryId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCountryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CityId) )
      {
         edtCityId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityId_Enabled), 5, 0), true);
      }
      else
      {
         edtCityId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CityId) )
      {
         A24CityId = AV12Insert_CityId ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CityId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_CountryId) )
      {
         A12CountryId = AV11Insert_CountryId ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
      }
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV14Pgmname = "AmusementPark" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
         /* Using cursor T00024 */
         pr_default.execute(2, new Object[] {Short.valueOf(A12CountryId)});
         A13CountryName = T00024_A13CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
         pr_default.close(2);
         /* Using cursor T00025 */
         pr_default.execute(3, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
         A25CityName = T00025_A25CityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25CityName", A25CityName);
         pr_default.close(3);
      }
   }

   public void load022( )
   {
      /* Using cursor T00026 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound2 = (short)(1) ;
         A8AmusementParkName = T00026_A8AmusementParkName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
         A9AmusementParkWebSite = T00026_A9AmusementParkWebSite[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9AmusementParkWebSite", A9AmusementParkWebSite);
         A10AmusementParkAddress = T00026_A10AmusementParkAddress[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10AmusementParkAddress", A10AmusementParkAddress);
         A11AmusementParkPhoto = T00026_A11AmusementParkPhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11AmusementParkPhoto", A11AmusementParkPhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
         A40000AmusementParkPhoto_GXI = T00026_A40000AmusementParkPhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
         A13CountryName = T00026_A13CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
         A25CityName = T00026_A25CityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25CityName", A25CityName);
         A12CountryId = T00026_A12CountryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
         A24CityId = T00026_A24CityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CityId), 4, 0));
         zm022( -11) ;
      }
      pr_default.close(4);
      onLoadActions022( ) ;
   }

   public void onLoadActions022( )
   {
      AV14Pgmname = "AmusementPark" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
   }

   public void checkExtendedTable022( )
   {
      nIsDirty_2 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV14Pgmname = "AmusementPark" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
      /* Using cursor T00024 */
      pr_default.execute(2, new Object[] {Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Country'.", "ForeignKeyNotFound", 1, "COUNTRYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A13CountryName = T00024_A13CountryName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
      pr_default.close(2);
      /* Using cursor T00025 */
      pr_default.execute(3, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'City'.", "ForeignKeyNotFound", 1, "CITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A25CityName = T00025_A25CityName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A25CityName", A25CityName);
      pr_default.close(3);
   }

   public void closeExtendedTableCursors022( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( short A12CountryId )
   {
      /* Using cursor T00027 */
      pr_default.execute(5, new Object[] {Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Country'.", "ForeignKeyNotFound", 1, "COUNTRYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A13CountryName = T00027_A13CountryName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A13CountryName))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_13( short A12CountryId ,
                          short A24CityId )
   {
      /* Using cursor T00028 */
      pr_default.execute(6, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'City'.", "ForeignKeyNotFound", 1, "CITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A25CityName = T00028_A25CityName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A25CityName", A25CityName);
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A25CityName))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey022( )
   {
      /* Using cursor T00029 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound2 = (short)(1) ;
      }
      else
      {
         RcdFound2 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00023 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm022( 11) ;
         RcdFound2 = (short)(1) ;
         A7AmusementParkId = T00023_A7AmusementParkId[0] ;
         n7AmusementParkId = T00023_n7AmusementParkId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
         A8AmusementParkName = T00023_A8AmusementParkName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
         A9AmusementParkWebSite = T00023_A9AmusementParkWebSite[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9AmusementParkWebSite", A9AmusementParkWebSite);
         A10AmusementParkAddress = T00023_A10AmusementParkAddress[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10AmusementParkAddress", A10AmusementParkAddress);
         A11AmusementParkPhoto = T00023_A11AmusementParkPhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11AmusementParkPhoto", A11AmusementParkPhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
         A40000AmusementParkPhoto_GXI = T00023_A40000AmusementParkPhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
         A12CountryId = T00023_A12CountryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
         A24CityId = T00023_A24CityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CityId), 4, 0));
         Z7AmusementParkId = A7AmusementParkId ;
         sMode2 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load022( ) ;
         if ( AnyError == 1 )
         {
            RcdFound2 = (short)(0) ;
            initializeNonKey022( ) ;
         }
         Gx_mode = sMode2 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound2 = (short)(0) ;
         initializeNonKey022( ) ;
         sMode2 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode2 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey022( ) ;
      if ( RcdFound2 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound2 = (short)(0) ;
      /* Using cursor T000210 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000210_A7AmusementParkId[0] < A7AmusementParkId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000210_A7AmusementParkId[0] > A7AmusementParkId ) ) )
         {
            A7AmusementParkId = T000210_A7AmusementParkId[0] ;
            n7AmusementParkId = T000210_n7AmusementParkId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
            RcdFound2 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound2 = (short)(0) ;
      /* Using cursor T000211 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000211_A7AmusementParkId[0] > A7AmusementParkId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000211_A7AmusementParkId[0] < A7AmusementParkId ) ) )
         {
            A7AmusementParkId = T000211_A7AmusementParkId[0] ;
            n7AmusementParkId = T000211_n7AmusementParkId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
            RcdFound2 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey022( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtAmusementParkName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert022( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound2 == 1 )
         {
            if ( A7AmusementParkId != Z7AmusementParkId )
            {
               A7AmusementParkId = Z7AmusementParkId ;
               n7AmusementParkId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "AMUSEMENTPARKID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAmusementParkId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtAmusementParkName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update022( ) ;
               GX_FocusControl = edtAmusementParkName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A7AmusementParkId != Z7AmusementParkId )
            {
               /* Insert record */
               GX_FocusControl = edtAmusementParkName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert022( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "AMUSEMENTPARKID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtAmusementParkId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtAmusementParkName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert022( ) ;
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
      if ( A7AmusementParkId != Z7AmusementParkId )
      {
         A7AmusementParkId = Z7AmusementParkId ;
         n7AmusementParkId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "AMUSEMENTPARKID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAmusementParkId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtAmusementParkName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency022( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00022 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AmusementPark"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z8AmusementParkName, T00022_A8AmusementParkName[0]) != 0 ) || ( GXutil.strcmp(Z9AmusementParkWebSite, T00022_A9AmusementParkWebSite[0]) != 0 ) || ( GXutil.strcmp(Z10AmusementParkAddress, T00022_A10AmusementParkAddress[0]) != 0 ) || ( Z12CountryId != T00022_A12CountryId[0] ) || ( Z24CityId != T00022_A24CityId[0] ) )
         {
            if ( GXutil.strcmp(Z8AmusementParkName, T00022_A8AmusementParkName[0]) != 0 )
            {
               GXutil.writeLogln("amusementpark:[seudo value changed for attri]"+"AmusementParkName");
               GXutil.writeLogRaw("Old: ",Z8AmusementParkName);
               GXutil.writeLogRaw("Current: ",T00022_A8AmusementParkName[0]);
            }
            if ( GXutil.strcmp(Z9AmusementParkWebSite, T00022_A9AmusementParkWebSite[0]) != 0 )
            {
               GXutil.writeLogln("amusementpark:[seudo value changed for attri]"+"AmusementParkWebSite");
               GXutil.writeLogRaw("Old: ",Z9AmusementParkWebSite);
               GXutil.writeLogRaw("Current: ",T00022_A9AmusementParkWebSite[0]);
            }
            if ( GXutil.strcmp(Z10AmusementParkAddress, T00022_A10AmusementParkAddress[0]) != 0 )
            {
               GXutil.writeLogln("amusementpark:[seudo value changed for attri]"+"AmusementParkAddress");
               GXutil.writeLogRaw("Old: ",Z10AmusementParkAddress);
               GXutil.writeLogRaw("Current: ",T00022_A10AmusementParkAddress[0]);
            }
            if ( Z12CountryId != T00022_A12CountryId[0] )
            {
               GXutil.writeLogln("amusementpark:[seudo value changed for attri]"+"CountryId");
               GXutil.writeLogRaw("Old: ",Z12CountryId);
               GXutil.writeLogRaw("Current: ",T00022_A12CountryId[0]);
            }
            if ( Z24CityId != T00022_A24CityId[0] )
            {
               GXutil.writeLogln("amusementpark:[seudo value changed for attri]"+"CityId");
               GXutil.writeLogRaw("Old: ",Z24CityId);
               GXutil.writeLogRaw("Current: ",T00022_A24CityId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"AmusementPark"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert022( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable022( ) ;
      }
      if ( AnyError == 0 )
      {
         zm022( 0) ;
         checkOptimisticConcurrency022( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm022( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert022( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000212 */
                  pr_default.execute(10, new Object[] {A8AmusementParkName, A9AmusementParkWebSite, A10AmusementParkAddress, A11AmusementParkPhoto, A40000AmusementParkPhoto_GXI, Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000213 */
                  pr_default.execute(11);
                  A7AmusementParkId = T000213_A7AmusementParkId[0] ;
                  n7AmusementParkId = T000213_n7AmusementParkId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
                  pr_default.close(11);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AmusementPark");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption020( ) ;
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
            load022( ) ;
         }
         endLevel022( ) ;
      }
      closeExtendedTableCursors022( ) ;
   }

   public void update022( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable022( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency022( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm022( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate022( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000214 */
                  pr_default.execute(12, new Object[] {A8AmusementParkName, A9AmusementParkWebSite, A10AmusementParkAddress, Short.valueOf(A12CountryId), Short.valueOf(A24CityId), Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AmusementPark");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AmusementPark"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate022( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
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
         endLevel022( ) ;
      }
      closeExtendedTableCursors022( ) ;
   }

   public void deferredUpdate022( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000215 */
         pr_default.execute(13, new Object[] {A11AmusementParkPhoto, A40000AmusementParkPhoto_GXI, Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("AmusementPark");
      }
   }

   public void delete( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency022( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls022( ) ;
         afterConfirm022( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete022( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000216 */
               pr_default.execute(14, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("AmusementPark");
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
      sMode2 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel022( ) ;
      Gx_mode = sMode2 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls022( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV14Pgmname = "AmusementPark" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
         /* Using cursor T000217 */
         pr_default.execute(15, new Object[] {Short.valueOf(A12CountryId)});
         A13CountryName = T000217_A13CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
         pr_default.close(15);
         /* Using cursor T000218 */
         pr_default.execute(16, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
         A25CityName = T000218_A25CityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25CityName", A25CityName);
         pr_default.close(16);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000219 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Game"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor T000220 */
         pr_default.execute(18, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Employee"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
      }
   }

   public void endLevel022( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete022( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "amusementpark");
         if ( AnyError == 0 )
         {
            confirmValues020( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "amusementpark");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart022( )
   {
      /* Scan By routine */
      /* Using cursor T000221 */
      pr_default.execute(19);
      RcdFound2 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound2 = (short)(1) ;
         A7AmusementParkId = T000221_A7AmusementParkId[0] ;
         n7AmusementParkId = T000221_n7AmusementParkId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext022( )
   {
      /* Scan next routine */
      pr_default.readNext(19);
      RcdFound2 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound2 = (short)(1) ;
         A7AmusementParkId = T000221_A7AmusementParkId[0] ;
         n7AmusementParkId = T000221_n7AmusementParkId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
      }
   }

   public void scanEnd022( )
   {
      pr_default.close(19);
   }

   public void afterConfirm022( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert022( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate022( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete022( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete022( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate022( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes022( )
   {
      edtAmusementParkId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkId_Enabled), 5, 0), true);
      edtAmusementParkName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkName_Enabled), 5, 0), true);
      edtAmusementParkWebSite_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkWebSite_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkWebSite_Enabled), 5, 0), true);
      edtAmusementParkAddress_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkAddress_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkAddress_Enabled), 5, 0), true);
      imgAmusementParkPhoto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAmusementParkPhoto_Enabled), 5, 0), true);
      edtCountryId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryId_Enabled), 5, 0), true);
      edtCountryName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryName_Enabled), 5, 0), true);
      edtCityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityId_Enabled), 5, 0), true);
      edtCityName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCityName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityName_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes022( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues020( )
   {
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20211071155233", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.parks.amusementpark", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7AmusementParkId,4,0))}, new String[] {"Gx_mode","AmusementParkId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"AmusementPark");
      forbiddenHiddens.add("AmusementParkId", localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("amusementpark:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z7AmusementParkId", GXutil.ltrim( localUtil.ntoc( Z7AmusementParkId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z8AmusementParkName", GXutil.rtrim( Z8AmusementParkName));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z9AmusementParkWebSite", GXutil.rtrim( Z9AmusementParkWebSite));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z10AmusementParkAddress", Z10AmusementParkAddress);
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z12CountryId", GXutil.ltrim( localUtil.ntoc( Z12CountryId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z24CityId", GXutil.ltrim( localUtil.ntoc( Z24CityId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "N12CountryId", GXutil.ltrim( localUtil.ntoc( A12CountryId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "N24CityId", GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ",", "")));
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
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vAMUSEMENTPARKID", GXutil.ltrim( localUtil.ntoc( AV7AmusementParkId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAMUSEMENTPARKID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7AmusementParkId), "ZZZ9")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vINSERT_COUNTRYID", GXutil.ltrim( localUtil.ntoc( AV11Insert_CountryId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CITYID", GXutil.ltrim( localUtil.ntoc( AV12Insert_CityId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "AMUSEMENTPARKPHOTO_GXI", A40000AmusementParkPhoto_GXI);
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV14Pgmname));
      GXCCtlgxBlob = "AMUSEMENTPARKPHOTO" + "_gxBlob" ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A11AmusementParkPhoto);
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
      return formatLink("com.parks.amusementpark", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7AmusementParkId,4,0))}, new String[] {"Gx_mode","AmusementParkId"})  ;
   }

   public String getPgmname( )
   {
      return "AmusementPark" ;
   }

   public String getPgmdesc( )
   {
      return "Amusement Park" ;
   }

   public void initializeNonKey022( )
   {
      A12CountryId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A12CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryId), 4, 0));
      A24CityId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A24CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CityId), 4, 0));
      A8AmusementParkName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
      A9AmusementParkWebSite = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A9AmusementParkWebSite", A9AmusementParkWebSite);
      A10AmusementParkAddress = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A10AmusementParkAddress", A10AmusementParkAddress);
      A11AmusementParkPhoto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A11AmusementParkPhoto", A11AmusementParkPhoto);
      httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
      A40000AmusementParkPhoto_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
      A13CountryName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", A13CountryName);
      A25CityName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A25CityName", A25CityName);
      Z8AmusementParkName = "" ;
      Z9AmusementParkWebSite = "" ;
      Z10AmusementParkAddress = "" ;
      Z12CountryId = (short)(0) ;
      Z24CityId = (short)(0) ;
   }

   public void initAll022( )
   {
      A7AmusementParkId = (short)(0) ;
      n7AmusementParkId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
      initializeNonKey022( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20211071155245", true, true);
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
      httpContext.AddJavascriptSource("amusementpark.js", "?20211071155245", false, true);
      /* End function include_jscripts */
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
      edtAmusementParkId_Internalname = "AMUSEMENTPARKID" ;
      edtAmusementParkName_Internalname = "AMUSEMENTPARKNAME" ;
      edtAmusementParkWebSite_Internalname = "AMUSEMENTPARKWEBSITE" ;
      edtAmusementParkAddress_Internalname = "AMUSEMENTPARKADDRESS" ;
      imgAmusementParkPhoto_Internalname = "AMUSEMENTPARKPHOTO" ;
      edtCountryId_Internalname = "COUNTRYID" ;
      edtCountryName_Internalname = "COUNTRYNAME" ;
      edtCityId_Internalname = "CITYID" ;
      edtCityName_Internalname = "CITYNAME" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_12_Internalname = "PROMPT_12" ;
      imgprompt_24_Internalname = "PROMPT_24" ;
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
      Form.setCaption( "Amusement Park" );
      bttBtn_delete_Enabled = 0 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtCityName_Jsonclick = "" ;
      edtCityName_Enabled = 0 ;
      imgprompt_24_Visible = 1 ;
      imgprompt_24_Link = "" ;
      edtCityId_Jsonclick = "" ;
      edtCityId_Enabled = 1 ;
      edtCountryName_Jsonclick = "" ;
      edtCountryName_Enabled = 0 ;
      imgprompt_12_Visible = 1 ;
      imgprompt_12_Link = "" ;
      edtCountryId_Jsonclick = "" ;
      edtCountryId_Enabled = 1 ;
      imgAmusementParkPhoto_Enabled = 1 ;
      edtAmusementParkAddress_Enabled = 1 ;
      edtAmusementParkWebSite_Jsonclick = "" ;
      edtAmusementParkWebSite_Enabled = 1 ;
      edtAmusementParkName_Jsonclick = "" ;
      edtAmusementParkName_Enabled = 1 ;
      edtAmusementParkId_Jsonclick = "" ;
      edtAmusementParkId_Enabled = 0 ;
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

   public void valid_Countryid( )
   {
      /* Using cursor T000217 */
      pr_default.execute(15, new Object[] {Short.valueOf(A12CountryId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Country'.", "ForeignKeyNotFound", 1, "COUNTRYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
      }
      A13CountryName = T000217_A13CountryName[0] ;
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A13CountryName", GXutil.rtrim( A13CountryName));
   }

   public void valid_Cityid( )
   {
      /* Using cursor T000218 */
      pr_default.execute(16, new Object[] {Short.valueOf(A12CountryId), Short.valueOf(A24CityId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'City'.", "ForeignKeyNotFound", 1, "CITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
      }
      A25CityName = T000218_A25CityName[0] ;
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A25CityName", GXutil.rtrim( A25CityName));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7AmusementParkId',fld:'vAMUSEMENTPARKID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7AmusementParkId',fld:'vAMUSEMENTPARKID',pic:'ZZZ9',hsh:true},{av:'A7AmusementParkId',fld:'AMUSEMENTPARKID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12022',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_AMUSEMENTPARKID","{handler:'valid_Amusementparkid',iparms:[]");
      setEventMetadata("VALID_AMUSEMENTPARKID",",oparms:[]}");
      setEventMetadata("VALID_COUNTRYID","{handler:'valid_Countryid',iparms:[{av:'A12CountryId',fld:'COUNTRYID',pic:'ZZZ9'},{av:'A13CountryName',fld:'COUNTRYNAME',pic:''}]");
      setEventMetadata("VALID_COUNTRYID",",oparms:[{av:'A13CountryName',fld:'COUNTRYNAME',pic:''}]}");
      setEventMetadata("VALID_CITYID","{handler:'valid_Cityid',iparms:[{av:'A12CountryId',fld:'COUNTRYID',pic:'ZZZ9'},{av:'A24CityId',fld:'CITYID',pic:'ZZZ9'},{av:'A25CityName',fld:'CITYNAME',pic:''}]");
      setEventMetadata("VALID_CITYID",",oparms:[{av:'A25CityName',fld:'CITYNAME',pic:''}]}");
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
      pr_default.close(15);
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z8AmusementParkName = "" ;
      Z9AmusementParkWebSite = "" ;
      Z10AmusementParkAddress = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
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
      A8AmusementParkName = "" ;
      A9AmusementParkWebSite = "" ;
      A10AmusementParkAddress = "" ;
      A11AmusementParkPhoto = "" ;
      A40000AmusementParkPhoto_GXI = "" ;
      sImgUrl = "" ;
      A13CountryName = "" ;
      A25CityName = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      AV14Pgmname = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode2 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9TrnContext = new com.parks.SdtTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new com.parks.SdtTransactionContext_Attribute(remoteHandle, context);
      Z11AmusementParkPhoto = "" ;
      Z40000AmusementParkPhoto_GXI = "" ;
      Z13CountryName = "" ;
      Z25CityName = "" ;
      T00024_A13CountryName = new String[] {""} ;
      T00025_A25CityName = new String[] {""} ;
      T00026_A7AmusementParkId = new short[1] ;
      T00026_n7AmusementParkId = new boolean[] {false} ;
      T00026_A8AmusementParkName = new String[] {""} ;
      T00026_A9AmusementParkWebSite = new String[] {""} ;
      T00026_A10AmusementParkAddress = new String[] {""} ;
      T00026_A11AmusementParkPhoto = new String[] {""} ;
      T00026_A40000AmusementParkPhoto_GXI = new String[] {""} ;
      T00026_A13CountryName = new String[] {""} ;
      T00026_A25CityName = new String[] {""} ;
      T00026_A12CountryId = new short[1] ;
      T00026_A24CityId = new short[1] ;
      T00027_A13CountryName = new String[] {""} ;
      T00028_A25CityName = new String[] {""} ;
      T00029_A7AmusementParkId = new short[1] ;
      T00029_n7AmusementParkId = new boolean[] {false} ;
      T00023_A7AmusementParkId = new short[1] ;
      T00023_n7AmusementParkId = new boolean[] {false} ;
      T00023_A8AmusementParkName = new String[] {""} ;
      T00023_A9AmusementParkWebSite = new String[] {""} ;
      T00023_A10AmusementParkAddress = new String[] {""} ;
      T00023_A11AmusementParkPhoto = new String[] {""} ;
      T00023_A40000AmusementParkPhoto_GXI = new String[] {""} ;
      T00023_A12CountryId = new short[1] ;
      T00023_A24CityId = new short[1] ;
      T000210_A7AmusementParkId = new short[1] ;
      T000210_n7AmusementParkId = new boolean[] {false} ;
      T000211_A7AmusementParkId = new short[1] ;
      T000211_n7AmusementParkId = new boolean[] {false} ;
      T00022_A7AmusementParkId = new short[1] ;
      T00022_n7AmusementParkId = new boolean[] {false} ;
      T00022_A8AmusementParkName = new String[] {""} ;
      T00022_A9AmusementParkWebSite = new String[] {""} ;
      T00022_A10AmusementParkAddress = new String[] {""} ;
      T00022_A11AmusementParkPhoto = new String[] {""} ;
      T00022_A40000AmusementParkPhoto_GXI = new String[] {""} ;
      T00022_A12CountryId = new short[1] ;
      T00022_A24CityId = new short[1] ;
      T000213_A7AmusementParkId = new short[1] ;
      T000213_n7AmusementParkId = new boolean[] {false} ;
      T000217_A13CountryName = new String[] {""} ;
      T000218_A25CityName = new String[] {""} ;
      T000219_A17GameId = new short[1] ;
      T000220_A1EmployeeId = new short[1] ;
      T000221_A7AmusementParkId = new short[1] ;
      T000221_n7AmusementParkId = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.amusementpark__default(),
         new Object[] {
             new Object[] {
            T00022_A7AmusementParkId, T00022_A8AmusementParkName, T00022_A9AmusementParkWebSite, T00022_A10AmusementParkAddress, T00022_A11AmusementParkPhoto, T00022_A40000AmusementParkPhoto_GXI, T00022_A12CountryId, T00022_A24CityId
            }
            , new Object[] {
            T00023_A7AmusementParkId, T00023_A8AmusementParkName, T00023_A9AmusementParkWebSite, T00023_A10AmusementParkAddress, T00023_A11AmusementParkPhoto, T00023_A40000AmusementParkPhoto_GXI, T00023_A12CountryId, T00023_A24CityId
            }
            , new Object[] {
            T00024_A13CountryName
            }
            , new Object[] {
            T00025_A25CityName
            }
            , new Object[] {
            T00026_A7AmusementParkId, T00026_A8AmusementParkName, T00026_A9AmusementParkWebSite, T00026_A10AmusementParkAddress, T00026_A11AmusementParkPhoto, T00026_A40000AmusementParkPhoto_GXI, T00026_A13CountryName, T00026_A25CityName, T00026_A12CountryId, T00026_A24CityId
            }
            , new Object[] {
            T00027_A13CountryName
            }
            , new Object[] {
            T00028_A25CityName
            }
            , new Object[] {
            T00029_A7AmusementParkId
            }
            , new Object[] {
            T000210_A7AmusementParkId
            }
            , new Object[] {
            T000211_A7AmusementParkId
            }
            , new Object[] {
            }
            , new Object[] {
            T000213_A7AmusementParkId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000217_A13CountryName
            }
            , new Object[] {
            T000218_A25CityName
            }
            , new Object[] {
            T000219_A17GameId
            }
            , new Object[] {
            T000220_A1EmployeeId
            }
            , new Object[] {
            T000221_A7AmusementParkId
            }
         }
      );
      AV14Pgmname = "AmusementPark" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7AmusementParkId ;
   private short Z7AmusementParkId ;
   private short Z12CountryId ;
   private short Z24CityId ;
   private short N12CountryId ;
   private short N24CityId ;
   private short A12CountryId ;
   private short A24CityId ;
   private short AV7AmusementParkId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A7AmusementParkId ;
   private short AV11Insert_CountryId ;
   private short AV12Insert_CityId ;
   private short RcdFound2 ;
   private short nIsDirty_2 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtAmusementParkId_Enabled ;
   private int edtAmusementParkName_Enabled ;
   private int edtAmusementParkWebSite_Enabled ;
   private int edtAmusementParkAddress_Enabled ;
   private int imgAmusementParkPhoto_Enabled ;
   private int edtCountryId_Enabled ;
   private int imgprompt_12_Visible ;
   private int edtCountryName_Enabled ;
   private int edtCityId_Enabled ;
   private int imgprompt_24_Visible ;
   private int edtCityName_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int AV15GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z8AmusementParkName ;
   private String Z9AmusementParkWebSite ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtAmusementParkName_Internalname ;
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
   private String edtAmusementParkId_Internalname ;
   private String edtAmusementParkId_Jsonclick ;
   private String A8AmusementParkName ;
   private String edtAmusementParkName_Jsonclick ;
   private String edtAmusementParkWebSite_Internalname ;
   private String A9AmusementParkWebSite ;
   private String edtAmusementParkWebSite_Jsonclick ;
   private String edtAmusementParkAddress_Internalname ;
   private String imgAmusementParkPhoto_Internalname ;
   private String sImgUrl ;
   private String edtCountryId_Internalname ;
   private String edtCountryId_Jsonclick ;
   private String imgprompt_12_Internalname ;
   private String imgprompt_12_Link ;
   private String edtCountryName_Internalname ;
   private String A13CountryName ;
   private String edtCountryName_Jsonclick ;
   private String edtCityId_Internalname ;
   private String edtCityId_Jsonclick ;
   private String imgprompt_24_Internalname ;
   private String imgprompt_24_Link ;
   private String edtCityName_Internalname ;
   private String A25CityName ;
   private String edtCityName_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String AV14Pgmname ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String hsh ;
   private String sMode2 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z13CountryName ;
   private String Z25CityName ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXCCtlgxBlob ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A11AmusementParkPhoto_IsBlob ;
   private boolean n7AmusementParkId ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String Z10AmusementParkAddress ;
   private String A10AmusementParkAddress ;
   private String A40000AmusementParkPhoto_GXI ;
   private String Z40000AmusementParkPhoto_GXI ;
   private String A11AmusementParkPhoto ;
   private String Z11AmusementParkPhoto ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00024_A13CountryName ;
   private String[] T00025_A25CityName ;
   private short[] T00026_A7AmusementParkId ;
   private boolean[] T00026_n7AmusementParkId ;
   private String[] T00026_A8AmusementParkName ;
   private String[] T00026_A9AmusementParkWebSite ;
   private String[] T00026_A10AmusementParkAddress ;
   private String[] T00026_A11AmusementParkPhoto ;
   private String[] T00026_A40000AmusementParkPhoto_GXI ;
   private String[] T00026_A13CountryName ;
   private String[] T00026_A25CityName ;
   private short[] T00026_A12CountryId ;
   private short[] T00026_A24CityId ;
   private String[] T00027_A13CountryName ;
   private String[] T00028_A25CityName ;
   private short[] T00029_A7AmusementParkId ;
   private boolean[] T00029_n7AmusementParkId ;
   private short[] T00023_A7AmusementParkId ;
   private boolean[] T00023_n7AmusementParkId ;
   private String[] T00023_A8AmusementParkName ;
   private String[] T00023_A9AmusementParkWebSite ;
   private String[] T00023_A10AmusementParkAddress ;
   private String[] T00023_A11AmusementParkPhoto ;
   private String[] T00023_A40000AmusementParkPhoto_GXI ;
   private short[] T00023_A12CountryId ;
   private short[] T00023_A24CityId ;
   private short[] T000210_A7AmusementParkId ;
   private boolean[] T000210_n7AmusementParkId ;
   private short[] T000211_A7AmusementParkId ;
   private boolean[] T000211_n7AmusementParkId ;
   private short[] T00022_A7AmusementParkId ;
   private boolean[] T00022_n7AmusementParkId ;
   private String[] T00022_A8AmusementParkName ;
   private String[] T00022_A9AmusementParkWebSite ;
   private String[] T00022_A10AmusementParkAddress ;
   private String[] T00022_A11AmusementParkPhoto ;
   private String[] T00022_A40000AmusementParkPhoto_GXI ;
   private short[] T00022_A12CountryId ;
   private short[] T00022_A24CityId ;
   private short[] T000213_A7AmusementParkId ;
   private boolean[] T000213_n7AmusementParkId ;
   private String[] T000217_A13CountryName ;
   private String[] T000218_A25CityName ;
   private short[] T000219_A17GameId ;
   private short[] T000220_A1EmployeeId ;
   private short[] T000221_A7AmusementParkId ;
   private boolean[] T000221_n7AmusementParkId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.parks.SdtTransactionContext AV9TrnContext ;
   private com.parks.SdtTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class amusementpark__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00022", "SELECT `AmusementParkId`, `AmusementParkName`, `AmusementParkWebSite`, `AmusementParkAddress`, `AmusementParkPhoto`, `AmusementParkPhoto_GXI`, `CountryId`, `CityId` FROM `AmusementPark` WHERE `AmusementParkId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00023", "SELECT `AmusementParkId`, `AmusementParkName`, `AmusementParkWebSite`, `AmusementParkAddress`, `AmusementParkPhoto`, `AmusementParkPhoto_GXI`, `CountryId`, `CityId` FROM `AmusementPark` WHERE `AmusementParkId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00024", "SELECT `CountryName` FROM `Country` WHERE `CountryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00025", "SELECT `CityName` FROM `CountryCity` WHERE `CountryId` = ? AND `CityId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00026", "SELECT TM1.`AmusementParkId`, TM1.`AmusementParkName`, TM1.`AmusementParkWebSite`, TM1.`AmusementParkAddress`, TM1.`AmusementParkPhoto`, TM1.`AmusementParkPhoto_GXI`, T2.`CountryName`, T3.`CityName`, TM1.`CountryId`, TM1.`CityId` FROM ((`AmusementPark` TM1 INNER JOIN `Country` T2 ON T2.`CountryId` = TM1.`CountryId`) INNER JOIN `CountryCity` T3 ON T3.`CountryId` = TM1.`CountryId` AND T3.`CityId` = TM1.`CityId`) WHERE TM1.`AmusementParkId` = ? ORDER BY TM1.`AmusementParkId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00027", "SELECT `CountryName` FROM `Country` WHERE `CountryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00028", "SELECT `CityName` FROM `CountryCity` WHERE `CountryId` = ? AND `CityId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00029", "SELECT `AmusementParkId` FROM `AmusementPark` WHERE `AmusementParkId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000210", "SELECT `AmusementParkId` FROM `AmusementPark` WHERE ( `AmusementParkId` > ?) ORDER BY `AmusementParkId`  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000211", "SELECT `AmusementParkId` FROM `AmusementPark` WHERE ( `AmusementParkId` < ?) ORDER BY `AmusementParkId` DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000212", "INSERT INTO `AmusementPark`(`AmusementParkName`, `AmusementParkWebSite`, `AmusementParkAddress`, `AmusementParkPhoto`, `AmusementParkPhoto_GXI`, `CountryId`, `CityId`) VALUES(?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new ForEachCursor("T000213", "SELECT LAST_INSERT_ID() ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000214", "UPDATE `AmusementPark` SET `AmusementParkName`=?, `AmusementParkWebSite`=?, `AmusementParkAddress`=?, `CountryId`=?, `CityId`=?  WHERE `AmusementParkId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000215", "UPDATE `AmusementPark` SET `AmusementParkPhoto`=?, `AmusementParkPhoto_GXI`=?  WHERE `AmusementParkId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000216", "DELETE FROM `AmusementPark`  WHERE `AmusementParkId` = ?", GX_NOMASK)
         ,new ForEachCursor("T000217", "SELECT `CountryName` FROM `Country` WHERE `CountryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000218", "SELECT `CityName` FROM `CountryCity` WHERE `CountryId` = ? AND `CityId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000219", "SELECT `GameId` FROM `Game` WHERE `AmusementParkId` = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000220", "SELECT `EmployeeId` FROM `Employee` WHERE `AmusementParkId` = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000221", "SELECT `AmusementParkId` FROM `AmusementPark` ORDER BY `AmusementParkId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               ((String[]) buf[2])[0] = rslt.getString(3, 60);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               ((String[]) buf[2])[0] = rslt.getString(3, 60);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               ((String[]) buf[2])[0] = rslt.getString(3, 60);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 50);
               ((String[]) buf[7])[0] = rslt.getString(8, 50);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 50);
               stmt.setString(2, (String)parms[1], 60);
               stmt.setVarchar(3, (String)parms[2], 1024, false);
               stmt.setBLOBFile(4, (String)parms[3], true);
               stmt.setGXDbFileURI(5, (String)parms[4], (String)parms[3], 2048,"AmusementPark","AmusementParkPhoto");
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 50);
               stmt.setString(2, (String)parms[1], 60);
               stmt.setVarchar(3, (String)parms[2], 1024, false);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[6]).shortValue());
               }
               return;
            case 13 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"AmusementPark","AmusementParkPhoto");
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 18 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}


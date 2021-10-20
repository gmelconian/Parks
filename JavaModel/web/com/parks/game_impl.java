package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class game_impl extends GXDataArea
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
         A7AmusementParkId = (short)(GXutil.lval( httpContext.GetPar( "AmusementParkId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A7AmusementParkId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A19CategoryId = (short)(GXutil.lval( httpContext.GetPar( "CategoryId"))) ;
         n19CategoryId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CategoryId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A19CategoryId) ;
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
            AV7GameId = (short)(GXutil.lval( httpContext.GetPar( "GameId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7GameId), 4, 0));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGAMEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7GameId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Game", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtGameName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("Carmine");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public game_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public game_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( game_impl.class ));
   }

   public game_impl( int remoteHandle ,
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
      com.parks.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Game", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Game.htm");
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
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Game.htm");
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
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtGameId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtGameId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtGameId_Internalname, GXutil.ltrim( localUtil.ntoc( A17GameId, (byte)(4), (byte)(0), ",", "")), ((edtGameId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtGameId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtGameId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtGameName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtGameName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtGameName_Internalname, GXutil.rtrim( A18GameName), GXutil.rtrim( localUtil.format( A18GameName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtGameName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtGameName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAmusementParkId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtAmusementParkId_Internalname, "Amusement Park Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtAmusementParkId_Internalname, GXutil.ltrim( localUtil.ntoc( A7AmusementParkId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAmusementParkId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAmusementParkId_Enabled, 1, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Game.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgprompt_7_Internalname, sImgUrl, imgprompt_7_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_7_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Game.htm");
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
      com.parks.GxWebStd.gx_label_element( httpContext, edtAmusementParkName_Internalname, "Amusement Park Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtAmusementParkName_Internalname, GXutil.rtrim( A8AmusementParkName), GXutil.rtrim( localUtil.format( A8AmusementParkName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAmusementParkName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAmusementParkName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCategoryId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtCategoryId_Internalname, "Category Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtCategoryId_Internalname, GXutil.ltrim( localUtil.ntoc( A19CategoryId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CategoryId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCategoryId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCategoryId_Enabled, 1, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Game.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgprompt_19_Internalname, sImgUrl, imgprompt_19_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_19_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCategoryName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtCategoryName_Internalname, "Category Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtCategoryName_Internalname, GXutil.rtrim( A20CategoryName), GXutil.rtrim( localUtil.format( A20CategoryName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCategoryName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCategoryName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgGamePhoto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, "", "Photo", "col-sm-3 ImageAttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "ImageAttribute" ;
      StyleString = "" ;
      A21GamePhoto_IsBlob = (boolean)(((GXutil.strcmp("", A21GamePhoto)==0)&&(GXutil.strcmp("", A40000GamePhoto_GXI)==0))||!(GXutil.strcmp("", A21GamePhoto)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A21GamePhoto)==0) ? A40000GamePhoto_GXI : httpContext.getResourceRelative(A21GamePhoto)) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgGamePhoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgGamePhoto_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "", "", "", 0, A21GamePhoto_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Game.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "URL", ((GXutil.strcmp("", A21GamePhoto)==0) ? A40000GamePhoto_GXI : httpContext.getResourceRelative(A21GamePhoto)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "IsBlob", GXutil.booltostr( A21GamePhoto_IsBlob), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Game.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Game.htm");
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
      e11052 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z17GameId = (short)(localUtil.ctol( httpContext.cgiGet( "Z17GameId"), ",", ".")) ;
            Z18GameName = httpContext.cgiGet( "Z18GameName") ;
            Z7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( "Z7AmusementParkId"), ",", ".")) ;
            Z19CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( "Z19CategoryId"), ",", ".")) ;
            n19CategoryId = ((0==A19CategoryId) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( "N7AmusementParkId"), ",", ".")) ;
            N19CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( "N19CategoryId"), ",", ".")) ;
            n19CategoryId = ((0==A19CategoryId) ? true : false) ;
            AV7GameId = (short)(localUtil.ctol( httpContext.cgiGet( "vGAMEID"), ",", ".")) ;
            AV11Insert_AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_AMUSEMENTPARKID"), ",", ".")) ;
            AV12Insert_CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CATEGORYID"), ",", ".")) ;
            A40000GamePhoto_GXI = httpContext.cgiGet( "GAMEPHOTO_GXI") ;
            AV14Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            /* Read variables values. */
            A17GameId = (short)(localUtil.ctol( httpContext.cgiGet( edtGameId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
            A18GameName = httpContext.cgiGet( edtGameName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtAmusementParkId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtAmusementParkId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "AMUSEMENTPARKID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAmusementParkId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A7AmusementParkId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
            }
            else
            {
               A7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( edtAmusementParkId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
            }
            A8AmusementParkName = httpContext.cgiGet( edtAmusementParkName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCategoryId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCategoryId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CATEGORYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCategoryId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A19CategoryId = (short)(0) ;
               n19CategoryId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CategoryId), 4, 0));
            }
            else
            {
               A19CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCategoryId_Internalname), ",", ".")) ;
               n19CategoryId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CategoryId), 4, 0));
            }
            n19CategoryId = ((0==A19CategoryId) ? true : false) ;
            A20CategoryName = httpContext.cgiGet( edtCategoryName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A20CategoryName", A20CategoryName);
            A21GamePhoto = httpContext.cgiGet( imgGamePhoto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A21GamePhoto", A21GamePhoto);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A21GamePhoto ;
            GXv_char2[0] = A40000GamePhoto_GXI ;
            httpContext.getMultimediaValue(imgGamePhoto_Internalname, GXv_char1, GXv_char2);
            game_impl.this.A21GamePhoto = GXv_char1[0] ;
            game_impl.this.A40000GamePhoto_GXI = GXv_char2[0] ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Game");
            A17GameId = (short)(localUtil.ctol( httpContext.cgiGet( edtGameId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
            forbiddenHiddens.add("GameId", localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A17GameId != Z17GameId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("game:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A17GameId = (short)(GXutil.lval( httpContext.GetPar( "GameId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
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
                  sMode5 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound5 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_050( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "GAMEID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtGameId_Internalname ;
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
                        e11052 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12052 ();
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
         e12052 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll055( ) ;
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
         disableAttributes055( ) ;
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

   public void confirm_050( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls055( ) ;
         }
         else
         {
            checkExtendedTable055( ) ;
            closeExtendedTableCursors055( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption050( )
   {
   }

   public void e11052( )
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
      AV11Insert_AmusementParkId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_AmusementParkId), 4, 0));
      AV12Insert_CategoryId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_CategoryId), 4, 0));
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtTransactionContext_Transactionname(), AV14Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV15GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15GXV1), 8, 0));
         while ( AV15GXV1 <= AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.parks.SdtTransactionContext_Attribute)((com.parks.SdtTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().elementAt(-1+AV15GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "AmusementParkId") == 0 )
            {
               AV11Insert_AmusementParkId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_AmusementParkId), 4, 0));
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "CategoryId") == 0 )
            {
               AV12Insert_CategoryId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_CategoryId), 4, 0));
            }
            AV15GXV1 = (int)(AV15GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15GXV1), 8, 0));
         }
      }
   }

   public void e12052( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.parks.wwgame", new String[] {}, new String[] {}) );
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

   public void zm055( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z18GameName = T00053_A18GameName[0] ;
            Z7AmusementParkId = T00053_A7AmusementParkId[0] ;
            Z19CategoryId = T00053_A19CategoryId[0] ;
         }
         else
         {
            Z18GameName = A18GameName ;
            Z7AmusementParkId = A7AmusementParkId ;
            Z19CategoryId = A19CategoryId ;
         }
      }
      if ( GX_JID == -11 )
      {
         Z17GameId = A17GameId ;
         Z18GameName = A18GameName ;
         Z21GamePhoto = A21GamePhoto ;
         Z40000GamePhoto_GXI = A40000GamePhoto_GXI ;
         Z7AmusementParkId = A7AmusementParkId ;
         Z19CategoryId = A19CategoryId ;
         Z8AmusementParkName = A8AmusementParkName ;
         Z20CategoryName = A20CategoryName ;
      }
   }

   public void standaloneNotModal( )
   {
      edtGameId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtGameId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtGameId_Enabled), 5, 0), true);
      imgprompt_7_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.parks.gx0020"+"',["+"{Ctrl:gx.dom.el('"+"AMUSEMENTPARKID"+"'), id:'"+"AMUSEMENTPARKID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_19_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.parks.gx0060"+"',["+"{Ctrl:gx.dom.el('"+"CATEGORYID"+"'), id:'"+"CATEGORYID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      edtGameId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtGameId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtGameId_Enabled), 5, 0), true);
      bttBtn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7GameId) )
      {
         A17GameId = AV7GameId ;
         httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_AmusementParkId) )
      {
         edtAmusementParkId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkId_Enabled), 5, 0), true);
      }
      else
      {
         edtAmusementParkId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CategoryId) )
      {
         edtCategoryId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCategoryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCategoryId_Enabled), 5, 0), true);
      }
      else
      {
         edtCategoryId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCategoryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCategoryId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CategoryId) )
      {
         A19CategoryId = AV12Insert_CategoryId ;
         n19CategoryId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CategoryId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_AmusementParkId) )
      {
         A7AmusementParkId = AV11Insert_AmusementParkId ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
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
         AV14Pgmname = "Game" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
         /* Using cursor T00055 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
         A20CategoryName = T00055_A20CategoryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20CategoryName", A20CategoryName);
         pr_default.close(3);
         /* Using cursor T00054 */
         pr_default.execute(2, new Object[] {Short.valueOf(A7AmusementParkId)});
         A8AmusementParkName = T00054_A8AmusementParkName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
         pr_default.close(2);
      }
   }

   public void load055( )
   {
      /* Using cursor T00056 */
      pr_default.execute(4, new Object[] {Short.valueOf(A17GameId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A18GameName = T00056_A18GameName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
         A8AmusementParkName = T00056_A8AmusementParkName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
         A20CategoryName = T00056_A20CategoryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20CategoryName", A20CategoryName);
         A21GamePhoto = T00056_A21GamePhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A21GamePhoto", A21GamePhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A21GamePhoto)==0) ? A40000GamePhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A21GamePhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A21GamePhoto), true);
         A40000GamePhoto_GXI = T00056_A40000GamePhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A21GamePhoto)==0) ? A40000GamePhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A21GamePhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A21GamePhoto), true);
         A7AmusementParkId = T00056_A7AmusementParkId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
         A19CategoryId = T00056_A19CategoryId[0] ;
         n19CategoryId = T00056_n19CategoryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CategoryId), 4, 0));
         zm055( -11) ;
      }
      pr_default.close(4);
      onLoadActions055( ) ;
   }

   public void onLoadActions055( )
   {
      AV14Pgmname = "Game" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
   }

   public void checkExtendedTable055( )
   {
      nIsDirty_5 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV14Pgmname = "Game" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
      /* Using cursor T00054 */
      pr_default.execute(2, new Object[] {Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Amusement Park'.", "ForeignKeyNotFound", 1, "AMUSEMENTPARKID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAmusementParkId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A8AmusementParkName = T00054_A8AmusementParkName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
      pr_default.close(2);
      /* Using cursor T00055 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A19CategoryId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Category'.", "ForeignKeyNotFound", 1, "CATEGORYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCategoryId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A20CategoryName = T00055_A20CategoryName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A20CategoryName", A20CategoryName);
      pr_default.close(3);
   }

   public void closeExtendedTableCursors055( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( short A7AmusementParkId )
   {
      /* Using cursor T00057 */
      pr_default.execute(5, new Object[] {Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Amusement Park'.", "ForeignKeyNotFound", 1, "AMUSEMENTPARKID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAmusementParkId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A8AmusementParkName = T00057_A8AmusementParkName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A8AmusementParkName))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_13( short A19CategoryId )
   {
      /* Using cursor T00058 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A19CategoryId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Category'.", "ForeignKeyNotFound", 1, "CATEGORYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCategoryId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A20CategoryName = T00058_A20CategoryName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A20CategoryName", A20CategoryName);
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A20CategoryName))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey055( )
   {
      /* Using cursor T00059 */
      pr_default.execute(7, new Object[] {Short.valueOf(A17GameId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound5 = (short)(1) ;
      }
      else
      {
         RcdFound5 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00053 */
      pr_default.execute(1, new Object[] {Short.valueOf(A17GameId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm055( 11) ;
         RcdFound5 = (short)(1) ;
         A17GameId = T00053_A17GameId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
         A18GameName = T00053_A18GameName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
         A21GamePhoto = T00053_A21GamePhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A21GamePhoto", A21GamePhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A21GamePhoto)==0) ? A40000GamePhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A21GamePhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A21GamePhoto), true);
         A40000GamePhoto_GXI = T00053_A40000GamePhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A21GamePhoto)==0) ? A40000GamePhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A21GamePhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A21GamePhoto), true);
         A7AmusementParkId = T00053_A7AmusementParkId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
         A19CategoryId = T00053_A19CategoryId[0] ;
         n19CategoryId = T00053_n19CategoryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CategoryId), 4, 0));
         Z17GameId = A17GameId ;
         sMode5 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load055( ) ;
         if ( AnyError == 1 )
         {
            RcdFound5 = (short)(0) ;
            initializeNonKey055( ) ;
         }
         Gx_mode = sMode5 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound5 = (short)(0) ;
         initializeNonKey055( ) ;
         sMode5 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode5 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey055( ) ;
      if ( RcdFound5 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound5 = (short)(0) ;
      /* Using cursor T000510 */
      pr_default.execute(8, new Object[] {Short.valueOf(A17GameId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000510_A17GameId[0] < A17GameId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000510_A17GameId[0] > A17GameId ) ) )
         {
            A17GameId = T000510_A17GameId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
            RcdFound5 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound5 = (short)(0) ;
      /* Using cursor T000511 */
      pr_default.execute(9, new Object[] {Short.valueOf(A17GameId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000511_A17GameId[0] > A17GameId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000511_A17GameId[0] < A17GameId ) ) )
         {
            A17GameId = T000511_A17GameId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
            RcdFound5 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey055( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtGameName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert055( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound5 == 1 )
         {
            if ( A17GameId != Z17GameId )
            {
               A17GameId = Z17GameId ;
               httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "GAMEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtGameId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtGameName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update055( ) ;
               GX_FocusControl = edtGameName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A17GameId != Z17GameId )
            {
               /* Insert record */
               GX_FocusControl = edtGameName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert055( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "GAMEID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtGameId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtGameName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert055( ) ;
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
      if ( A17GameId != Z17GameId )
      {
         A17GameId = Z17GameId ;
         httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "GAMEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtGameId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtGameName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency055( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00052 */
         pr_default.execute(0, new Object[] {Short.valueOf(A17GameId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Game"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z18GameName, T00052_A18GameName[0]) != 0 ) || ( Z7AmusementParkId != T00052_A7AmusementParkId[0] ) || ( Z19CategoryId != T00052_A19CategoryId[0] ) )
         {
            if ( GXutil.strcmp(Z18GameName, T00052_A18GameName[0]) != 0 )
            {
               GXutil.writeLogln("game:[seudo value changed for attri]"+"GameName");
               GXutil.writeLogRaw("Old: ",Z18GameName);
               GXutil.writeLogRaw("Current: ",T00052_A18GameName[0]);
            }
            if ( Z7AmusementParkId != T00052_A7AmusementParkId[0] )
            {
               GXutil.writeLogln("game:[seudo value changed for attri]"+"AmusementParkId");
               GXutil.writeLogRaw("Old: ",Z7AmusementParkId);
               GXutil.writeLogRaw("Current: ",T00052_A7AmusementParkId[0]);
            }
            if ( Z19CategoryId != T00052_A19CategoryId[0] )
            {
               GXutil.writeLogln("game:[seudo value changed for attri]"+"CategoryId");
               GXutil.writeLogRaw("Old: ",Z19CategoryId);
               GXutil.writeLogRaw("Current: ",T00052_A19CategoryId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Game"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert055( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable055( ) ;
      }
      if ( AnyError == 0 )
      {
         zm055( 0) ;
         checkOptimisticConcurrency055( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm055( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert055( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000512 */
                  pr_default.execute(10, new Object[] {A18GameName, A21GamePhoto, A40000GamePhoto_GXI, Short.valueOf(A7AmusementParkId), Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000513 */
                  pr_default.execute(11);
                  A17GameId = T000513_A17GameId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
                  pr_default.close(11);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Game");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption050( ) ;
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
            load055( ) ;
         }
         endLevel055( ) ;
      }
      closeExtendedTableCursors055( ) ;
   }

   public void update055( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable055( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency055( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm055( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate055( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000514 */
                  pr_default.execute(12, new Object[] {A18GameName, Short.valueOf(A7AmusementParkId), Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId), Short.valueOf(A17GameId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Game");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Game"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate055( ) ;
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
         endLevel055( ) ;
      }
      closeExtendedTableCursors055( ) ;
   }

   public void deferredUpdate055( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000515 */
         pr_default.execute(13, new Object[] {A21GamePhoto, A40000GamePhoto_GXI, Short.valueOf(A17GameId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Game");
      }
   }

   public void delete( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency055( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls055( ) ;
         afterConfirm055( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete055( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000516 */
               pr_default.execute(14, new Object[] {Short.valueOf(A17GameId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Game");
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
      sMode5 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel055( ) ;
      Gx_mode = sMode5 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls055( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV14Pgmname = "Game" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Pgmname", AV14Pgmname);
         /* Using cursor T000517 */
         pr_default.execute(15, new Object[] {Short.valueOf(A7AmusementParkId)});
         A8AmusementParkName = T000517_A8AmusementParkName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
         pr_default.close(15);
         /* Using cursor T000518 */
         pr_default.execute(16, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
         A20CategoryName = T000518_A20CategoryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20CategoryName", A20CategoryName);
         pr_default.close(16);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000519 */
         pr_default.execute(17, new Object[] {Short.valueOf(A17GameId)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Repair"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
   }

   public void endLevel055( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete055( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "game");
         if ( AnyError == 0 )
         {
            confirmValues050( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "game");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart055( )
   {
      /* Scan By routine */
      /* Using cursor T000520 */
      pr_default.execute(18);
      RcdFound5 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A17GameId = T000520_A17GameId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext055( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound5 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A17GameId = T000520_A17GameId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
      }
   }

   public void scanEnd055( )
   {
      pr_default.close(18);
   }

   public void afterConfirm055( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert055( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate055( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete055( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete055( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate055( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes055( )
   {
      edtGameId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtGameId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtGameId_Enabled), 5, 0), true);
      edtGameName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtGameName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtGameName_Enabled), 5, 0), true);
      edtAmusementParkId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkId_Enabled), 5, 0), true);
      edtAmusementParkName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkName_Enabled), 5, 0), true);
      edtCategoryId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCategoryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCategoryId_Enabled), 5, 0), true);
      edtCategoryName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCategoryName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCategoryName_Enabled), 5, 0), true);
      imgGamePhoto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgGamePhoto_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes055( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues050( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20211071155417", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.parks.game", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7GameId,4,0))}, new String[] {"Gx_mode","GameId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Game");
      forbiddenHiddens.add("GameId", localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("game:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z17GameId", GXutil.ltrim( localUtil.ntoc( Z17GameId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z18GameName", GXutil.rtrim( Z18GameName));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z7AmusementParkId", GXutil.ltrim( localUtil.ntoc( Z7AmusementParkId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z19CategoryId", GXutil.ltrim( localUtil.ntoc( Z19CategoryId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "N7AmusementParkId", GXutil.ltrim( localUtil.ntoc( A7AmusementParkId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "N19CategoryId", GXutil.ltrim( localUtil.ntoc( A19CategoryId, (byte)(4), (byte)(0), ",", "")));
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
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vGAMEID", GXutil.ltrim( localUtil.ntoc( AV7GameId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGAMEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7GameId), "ZZZ9")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vINSERT_AMUSEMENTPARKID", GXutil.ltrim( localUtil.ntoc( AV11Insert_AmusementParkId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CATEGORYID", GXutil.ltrim( localUtil.ntoc( AV12Insert_CategoryId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GAMEPHOTO_GXI", A40000GamePhoto_GXI);
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV14Pgmname));
      GXCCtlgxBlob = "GAMEPHOTO" + "_gxBlob" ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A21GamePhoto);
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
      return formatLink("com.parks.game", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7GameId,4,0))}, new String[] {"Gx_mode","GameId"})  ;
   }

   public String getPgmname( )
   {
      return "Game" ;
   }

   public String getPgmdesc( )
   {
      return "Game" ;
   }

   public void initializeNonKey055( )
   {
      A7AmusementParkId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
      A19CategoryId = (short)(0) ;
      n19CategoryId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A19CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CategoryId), 4, 0));
      n19CategoryId = ((0==A19CategoryId) ? true : false) ;
      A18GameName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
      A8AmusementParkName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
      A20CategoryName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A20CategoryName", A20CategoryName);
      A21GamePhoto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A21GamePhoto", A21GamePhoto);
      httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A21GamePhoto)==0) ? A40000GamePhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A21GamePhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A21GamePhoto), true);
      A40000GamePhoto_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A21GamePhoto)==0) ? A40000GamePhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A21GamePhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgGamePhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A21GamePhoto), true);
      Z18GameName = "" ;
      Z7AmusementParkId = (short)(0) ;
      Z19CategoryId = (short)(0) ;
   }

   public void initAll055( )
   {
      A17GameId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
      initializeNonKey055( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20211071155428", true, true);
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
      httpContext.AddJavascriptSource("game.js", "?20211071155429", false, true);
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
      edtGameId_Internalname = "GAMEID" ;
      edtGameName_Internalname = "GAMENAME" ;
      edtAmusementParkId_Internalname = "AMUSEMENTPARKID" ;
      edtAmusementParkName_Internalname = "AMUSEMENTPARKNAME" ;
      edtCategoryId_Internalname = "CATEGORYID" ;
      edtCategoryName_Internalname = "CATEGORYNAME" ;
      imgGamePhoto_Internalname = "GAMEPHOTO" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_7_Internalname = "PROMPT_7" ;
      imgprompt_19_Internalname = "PROMPT_19" ;
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
      Form.setCaption( "Game" );
      bttBtn_delete_Enabled = 0 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      imgGamePhoto_Enabled = 1 ;
      edtCategoryName_Jsonclick = "" ;
      edtCategoryName_Enabled = 0 ;
      imgprompt_19_Visible = 1 ;
      imgprompt_19_Link = "" ;
      edtCategoryId_Jsonclick = "" ;
      edtCategoryId_Enabled = 1 ;
      edtAmusementParkName_Jsonclick = "" ;
      edtAmusementParkName_Enabled = 0 ;
      imgprompt_7_Visible = 1 ;
      imgprompt_7_Link = "" ;
      edtAmusementParkId_Jsonclick = "" ;
      edtAmusementParkId_Enabled = 1 ;
      edtGameName_Jsonclick = "" ;
      edtGameName_Enabled = 1 ;
      edtGameId_Jsonclick = "" ;
      edtGameId_Enabled = 0 ;
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

   public void valid_Amusementparkid( )
   {
      /* Using cursor T000517 */
      pr_default.execute(15, new Object[] {Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Amusement Park'.", "ForeignKeyNotFound", 1, "AMUSEMENTPARKID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAmusementParkId_Internalname ;
      }
      A8AmusementParkName = T000517_A8AmusementParkName[0] ;
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", GXutil.rtrim( A8AmusementParkName));
   }

   public void valid_Categoryid( )
   {
      n19CategoryId = false ;
      /* Using cursor T000518 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         if ( ! ( (0==A19CategoryId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Category'.", "ForeignKeyNotFound", 1, "CATEGORYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCategoryId_Internalname ;
         }
      }
      A20CategoryName = T000518_A20CategoryName[0] ;
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A20CategoryName", GXutil.rtrim( A20CategoryName));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7GameId',fld:'vGAMEID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7GameId',fld:'vGAMEID',pic:'ZZZ9',hsh:true},{av:'A17GameId',fld:'GAMEID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12052',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_GAMEID","{handler:'valid_Gameid',iparms:[]");
      setEventMetadata("VALID_GAMEID",",oparms:[]}");
      setEventMetadata("VALID_AMUSEMENTPARKID","{handler:'valid_Amusementparkid',iparms:[{av:'A7AmusementParkId',fld:'AMUSEMENTPARKID',pic:'ZZZ9'},{av:'A8AmusementParkName',fld:'AMUSEMENTPARKNAME',pic:''}]");
      setEventMetadata("VALID_AMUSEMENTPARKID",",oparms:[{av:'A8AmusementParkName',fld:'AMUSEMENTPARKNAME',pic:''}]}");
      setEventMetadata("VALID_CATEGORYID","{handler:'valid_Categoryid',iparms:[{av:'A19CategoryId',fld:'CATEGORYID',pic:'ZZZ9'},{av:'A20CategoryName',fld:'CATEGORYNAME',pic:''}]");
      setEventMetadata("VALID_CATEGORYID",",oparms:[{av:'A20CategoryName',fld:'CATEGORYNAME',pic:''}]}");
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
      Z18GameName = "" ;
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
      A18GameName = "" ;
      sImgUrl = "" ;
      A8AmusementParkName = "" ;
      A20CategoryName = "" ;
      A21GamePhoto = "" ;
      A40000GamePhoto_GXI = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      AV14Pgmname = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode5 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9TrnContext = new com.parks.SdtTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new com.parks.SdtTransactionContext_Attribute(remoteHandle, context);
      Z21GamePhoto = "" ;
      Z40000GamePhoto_GXI = "" ;
      Z8AmusementParkName = "" ;
      Z20CategoryName = "" ;
      T00055_A20CategoryName = new String[] {""} ;
      T00054_A8AmusementParkName = new String[] {""} ;
      T00056_A17GameId = new short[1] ;
      T00056_A18GameName = new String[] {""} ;
      T00056_A8AmusementParkName = new String[] {""} ;
      T00056_A20CategoryName = new String[] {""} ;
      T00056_A21GamePhoto = new String[] {""} ;
      T00056_A40000GamePhoto_GXI = new String[] {""} ;
      T00056_A7AmusementParkId = new short[1] ;
      T00056_A19CategoryId = new short[1] ;
      T00056_n19CategoryId = new boolean[] {false} ;
      T00057_A8AmusementParkName = new String[] {""} ;
      T00058_A20CategoryName = new String[] {""} ;
      T00059_A17GameId = new short[1] ;
      T00053_A17GameId = new short[1] ;
      T00053_A18GameName = new String[] {""} ;
      T00053_A21GamePhoto = new String[] {""} ;
      T00053_A40000GamePhoto_GXI = new String[] {""} ;
      T00053_A7AmusementParkId = new short[1] ;
      T00053_A19CategoryId = new short[1] ;
      T00053_n19CategoryId = new boolean[] {false} ;
      T000510_A17GameId = new short[1] ;
      T000511_A17GameId = new short[1] ;
      T00052_A17GameId = new short[1] ;
      T00052_A18GameName = new String[] {""} ;
      T00052_A21GamePhoto = new String[] {""} ;
      T00052_A40000GamePhoto_GXI = new String[] {""} ;
      T00052_A7AmusementParkId = new short[1] ;
      T00052_A19CategoryId = new short[1] ;
      T00052_n19CategoryId = new boolean[] {false} ;
      T000513_A17GameId = new short[1] ;
      T000517_A8AmusementParkName = new String[] {""} ;
      T000518_A20CategoryName = new String[] {""} ;
      T000519_A27RepairId = new short[1] ;
      T000520_A17GameId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.game__default(),
         new Object[] {
             new Object[] {
            T00052_A17GameId, T00052_A18GameName, T00052_A21GamePhoto, T00052_A40000GamePhoto_GXI, T00052_A7AmusementParkId, T00052_A19CategoryId, T00052_n19CategoryId
            }
            , new Object[] {
            T00053_A17GameId, T00053_A18GameName, T00053_A21GamePhoto, T00053_A40000GamePhoto_GXI, T00053_A7AmusementParkId, T00053_A19CategoryId, T00053_n19CategoryId
            }
            , new Object[] {
            T00054_A8AmusementParkName
            }
            , new Object[] {
            T00055_A20CategoryName
            }
            , new Object[] {
            T00056_A17GameId, T00056_A18GameName, T00056_A8AmusementParkName, T00056_A20CategoryName, T00056_A21GamePhoto, T00056_A40000GamePhoto_GXI, T00056_A7AmusementParkId, T00056_A19CategoryId, T00056_n19CategoryId
            }
            , new Object[] {
            T00057_A8AmusementParkName
            }
            , new Object[] {
            T00058_A20CategoryName
            }
            , new Object[] {
            T00059_A17GameId
            }
            , new Object[] {
            T000510_A17GameId
            }
            , new Object[] {
            T000511_A17GameId
            }
            , new Object[] {
            }
            , new Object[] {
            T000513_A17GameId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000517_A8AmusementParkName
            }
            , new Object[] {
            T000518_A20CategoryName
            }
            , new Object[] {
            T000519_A27RepairId
            }
            , new Object[] {
            T000520_A17GameId
            }
         }
      );
      AV14Pgmname = "Game" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7GameId ;
   private short Z17GameId ;
   private short Z7AmusementParkId ;
   private short Z19CategoryId ;
   private short N7AmusementParkId ;
   private short N19CategoryId ;
   private short A7AmusementParkId ;
   private short A19CategoryId ;
   private short AV7GameId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A17GameId ;
   private short AV11Insert_AmusementParkId ;
   private short AV12Insert_CategoryId ;
   private short RcdFound5 ;
   private short nIsDirty_5 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtGameId_Enabled ;
   private int edtGameName_Enabled ;
   private int edtAmusementParkId_Enabled ;
   private int imgprompt_7_Visible ;
   private int edtAmusementParkName_Enabled ;
   private int edtCategoryId_Enabled ;
   private int imgprompt_19_Visible ;
   private int edtCategoryName_Enabled ;
   private int imgGamePhoto_Enabled ;
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
   private String Z18GameName ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtGameName_Internalname ;
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
   private String edtGameId_Internalname ;
   private String edtGameId_Jsonclick ;
   private String A18GameName ;
   private String edtGameName_Jsonclick ;
   private String edtAmusementParkId_Internalname ;
   private String edtAmusementParkId_Jsonclick ;
   private String sImgUrl ;
   private String imgprompt_7_Internalname ;
   private String imgprompt_7_Link ;
   private String edtAmusementParkName_Internalname ;
   private String A8AmusementParkName ;
   private String edtAmusementParkName_Jsonclick ;
   private String edtCategoryId_Internalname ;
   private String edtCategoryId_Jsonclick ;
   private String imgprompt_19_Internalname ;
   private String imgprompt_19_Link ;
   private String edtCategoryName_Internalname ;
   private String A20CategoryName ;
   private String edtCategoryName_Jsonclick ;
   private String imgGamePhoto_Internalname ;
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
   private String sMode5 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z8AmusementParkName ;
   private String Z20CategoryName ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXCCtlgxBlob ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n19CategoryId ;
   private boolean wbErr ;
   private boolean A21GamePhoto_IsBlob ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String A40000GamePhoto_GXI ;
   private String Z40000GamePhoto_GXI ;
   private String A21GamePhoto ;
   private String Z21GamePhoto ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00055_A20CategoryName ;
   private String[] T00054_A8AmusementParkName ;
   private short[] T00056_A17GameId ;
   private String[] T00056_A18GameName ;
   private String[] T00056_A8AmusementParkName ;
   private String[] T00056_A20CategoryName ;
   private String[] T00056_A21GamePhoto ;
   private String[] T00056_A40000GamePhoto_GXI ;
   private short[] T00056_A7AmusementParkId ;
   private short[] T00056_A19CategoryId ;
   private boolean[] T00056_n19CategoryId ;
   private String[] T00057_A8AmusementParkName ;
   private String[] T00058_A20CategoryName ;
   private short[] T00059_A17GameId ;
   private short[] T00053_A17GameId ;
   private String[] T00053_A18GameName ;
   private String[] T00053_A21GamePhoto ;
   private String[] T00053_A40000GamePhoto_GXI ;
   private short[] T00053_A7AmusementParkId ;
   private short[] T00053_A19CategoryId ;
   private boolean[] T00053_n19CategoryId ;
   private short[] T000510_A17GameId ;
   private short[] T000511_A17GameId ;
   private short[] T00052_A17GameId ;
   private String[] T00052_A18GameName ;
   private String[] T00052_A21GamePhoto ;
   private String[] T00052_A40000GamePhoto_GXI ;
   private short[] T00052_A7AmusementParkId ;
   private short[] T00052_A19CategoryId ;
   private boolean[] T00052_n19CategoryId ;
   private short[] T000513_A17GameId ;
   private String[] T000517_A8AmusementParkName ;
   private String[] T000518_A20CategoryName ;
   private short[] T000519_A27RepairId ;
   private short[] T000520_A17GameId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.parks.SdtTransactionContext AV9TrnContext ;
   private com.parks.SdtTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class game__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00052", "SELECT `GameId`, `GameName`, `GamePhoto`, `GamePhoto_GXI`, `AmusementParkId`, `CategoryId` FROM `Game` WHERE `GameId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00053", "SELECT `GameId`, `GameName`, `GamePhoto`, `GamePhoto_GXI`, `AmusementParkId`, `CategoryId` FROM `Game` WHERE `GameId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00054", "SELECT `AmusementParkName` FROM `AmusementPark` WHERE `AmusementParkId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00055", "SELECT `CategoryName` FROM `Category` WHERE `CategoryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00056", "SELECT TM1.`GameId`, TM1.`GameName`, T2.`AmusementParkName`, T3.`CategoryName`, TM1.`GamePhoto`, TM1.`GamePhoto_GXI`, TM1.`AmusementParkId`, TM1.`CategoryId` FROM ((`Game` TM1 INNER JOIN `AmusementPark` T2 ON T2.`AmusementParkId` = TM1.`AmusementParkId`) LEFT JOIN `Category` T3 ON T3.`CategoryId` = TM1.`CategoryId`) WHERE TM1.`GameId` = ? ORDER BY TM1.`GameId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00057", "SELECT `AmusementParkName` FROM `AmusementPark` WHERE `AmusementParkId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00058", "SELECT `CategoryName` FROM `Category` WHERE `CategoryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00059", "SELECT `GameId` FROM `Game` WHERE `GameId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000510", "SELECT `GameId` FROM `Game` WHERE ( `GameId` > ?) ORDER BY `GameId`  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000511", "SELECT `GameId` FROM `Game` WHERE ( `GameId` < ?) ORDER BY `GameId` DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000512", "INSERT INTO `Game`(`GameName`, `GamePhoto`, `GamePhoto_GXI`, `AmusementParkId`, `CategoryId`) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new ForEachCursor("T000513", "SELECT LAST_INSERT_ID() ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000514", "UPDATE `Game` SET `GameName`=?, `AmusementParkId`=?, `CategoryId`=?  WHERE `GameId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000515", "UPDATE `Game` SET `GamePhoto`=?, `GamePhoto_GXI`=?  WHERE `GameId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000516", "DELETE FROM `Game`  WHERE `GameId` = ?", GX_NOMASK)
         ,new ForEachCursor("T000517", "SELECT `AmusementParkName` FROM `AmusementPark` WHERE `AmusementParkId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000518", "SELECT `CategoryName` FROM `Category` WHERE `CategoryId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000519", "SELECT `RepairId` FROM `Repair` WHERE `GameId` = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000520", "SELECT `GameId` FROM `Game` ORDER BY `GameId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(4));
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 50);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(4));
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
               ((String[]) buf[2])[0] = rslt.getString(3, 50);
               ((String[]) buf[3])[0] = rslt.getString(4, 50);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
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
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 50);
               stmt.setBLOBFile(2, (String)parms[1], true);
               stmt.setGXDbFileURI(3, (String)parms[2], (String)parms[1], 2048,"Game","GamePhoto");
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[5]).shortValue());
               }
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 50);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               stmt.setShort(4, ((Number) parms[4]).shortValue());
               return;
            case 13 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Game","GamePhoto");
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}


package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class repair_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_23") == 0 )
      {
         A27RepairId = (short)(GXutil.lval( httpContext.GetPar( "RepairId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_23( A27RepairId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A17GameId = (short)(GXutil.lval( httpContext.GetPar( "GameId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A17GameId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_21") == 0 )
      {
         A30TechnicianId = (short)(GXutil.lval( httpContext.GetPar( "TechnicianId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_21( A30TechnicianId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_22") == 0 )
      {
         A35TechnicianAlternateId = (short)(GXutil.lval( httpContext.GetPar( "TechnicianAlternateId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A35TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35TechnicianAlternateId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_22( A35TechnicianAlternateId) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridrepair_kind") == 0 )
      {
         nRC_GXsfl_123 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_123"))) ;
         nGXsfl_123_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_123_idx"))) ;
         sGXsfl_123_idx = httpContext.GetPar( "sGXsfl_123_idx") ;
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridrepair_kind_newrow( ) ;
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
            AV7RepairId = (short)(GXutil.lval( httpContext.GetPar( "RepairId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7RepairId), 4, 0));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vREPAIRID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7RepairId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Repair", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtRepairBeginDate_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("Carmine");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public repair_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public repair_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( repair_impl.class ));
   }

   public repair_impl( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbRepairKindName = new HTMLChoice();
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
      com.parks.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Repair", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Repair.htm");
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
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Repair.htm");
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
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRepairId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtRepairId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairId_Internalname, GXutil.ltrim( localUtil.ntoc( A27RepairId, (byte)(4), (byte)(0), ",", "")), ((edtRepairId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A27RepairId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A27RepairId), "ZZZ9")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRepairId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRepairBeginDate_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtRepairBeginDate_Internalname, "Begin Date", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtRepairBeginDate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairBeginDate_Internalname, localUtil.format(A28RepairBeginDate, "99/99/99"), localUtil.format( A28RepairBeginDate, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairBeginDate_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRepairBeginDate_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_bitmap( httpContext, edtRepairBeginDate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtRepairBeginDate_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Repair.htm");
      httpContext.writeTextNL( "</div>") ;
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRepairDays_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtRepairDays_Internalname, "Days", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairDays_Internalname, GXutil.ltrim( localUtil.ntoc( A29RepairDays, (byte)(4), (byte)(0), ",", "")), ((edtRepairDays_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A29RepairDays), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A29RepairDays), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairDays_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRepairDays_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRepairDateTo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtRepairDateTo_Internalname, "Date To", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtRepairDateTo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairDateTo_Internalname, localUtil.format(A41RepairDateTo, "99/99/99"), localUtil.format( A41RepairDateTo, "99/99/99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairDateTo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRepairDateTo_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_bitmap( httpContext, edtRepairDateTo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtRepairDateTo_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Repair.htm");
      httpContext.writeTextNL( "</div>") ;
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtGameId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtGameId_Internalname, "Game Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtGameId_Internalname, GXutil.ltrim( localUtil.ntoc( A17GameId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtGameId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtGameId_Enabled, 1, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Repair.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgprompt_17_Internalname, sImgUrl, imgprompt_17_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_17_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Repair.htm");
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
      com.parks.GxWebStd.gx_label_element( httpContext, edtGameName_Internalname, "Game Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtGameName_Internalname, GXutil.rtrim( A18GameName), GXutil.rtrim( localUtil.format( A18GameName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtGameName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtGameName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTechnicianId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianId_Internalname, "Technician Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianId_Internalname, GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A30TechnicianId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTechnicianId_Enabled, 1, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Repair.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgprompt_30_Internalname, sImgUrl, imgprompt_30_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_30_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTechnicianName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianName_Internalname, "Technician Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianName_Internalname, GXutil.rtrim( A31TechnicianName), GXutil.rtrim( localUtil.format( A31TechnicianName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTechnicianName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTechnicianLastName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianLastName_Internalname, "Technician Last Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianLastName_Internalname, GXutil.rtrim( A32TechnicianLastName), GXutil.rtrim( localUtil.format( A32TechnicianLastName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianLastName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTechnicianLastName_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "LastName", "left", true, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTechnicianAlternateId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianAlternateId_Internalname, "Alternate Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianAlternateId_Internalname, GXutil.ltrim( localUtil.ntoc( A35TechnicianAlternateId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A35TechnicianAlternateId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianAlternateId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTechnicianAlternateId_Enabled, 1, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Repair.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgprompt_35_Internalname, sImgUrl, imgprompt_35_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_35_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTechnicianAlternateName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianAlternateName_Internalname, "Alternate Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianAlternateName_Internalname, GXutil.rtrim( A36TechnicianAlternateName), GXutil.rtrim( localUtil.format( A36TechnicianAlternateName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianAlternateName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTechnicianAlternateName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTechnicianAlternateLastName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianAlternateLastName_Internalname, "Last Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianAlternateLastName_Internalname, GXutil.rtrim( A37TechnicianAlternateLastName), GXutil.rtrim( localUtil.format( A37TechnicianAlternateLastName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianAlternateLastName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTechnicianAlternateLastName_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "LastName", "left", true, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTechnicianAlternatePhone_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianAlternatePhone_Internalname, "Alternate Phone", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      if ( httpContext.isSmartDevice( ) )
      {
         gxphoneLink = "tel:" + GXutil.rtrim( A38TechnicianAlternatePhone) ;
      }
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianAlternatePhone_Internalname, GXutil.rtrim( A38TechnicianAlternatePhone), GXutil.rtrim( localUtil.format( A38TechnicianAlternatePhone, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", gxphoneLink, "", "", "", edtTechnicianAlternatePhone_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTechnicianAlternatePhone_Enabled, 0, "tel", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Phone", "left", true, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRepairCost_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtRepairCost_Internalname, "Cost", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairCost_Internalname, GXutil.ltrim( localUtil.ntoc( A34RepairCost, (byte)(8), (byte)(2), ",", "")), ((edtRepairCost_Enabled!=0) ? GXutil.ltrim( localUtil.format( A34RepairCost, "ZZZZ9.99")) : localUtil.format( A34RepairCost, "ZZZZ9.99")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairCost_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRepairCost_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Cost", "right", false, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRepairDiscountPercentage_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtRepairDiscountPercentage_Internalname, "Discount Percentage", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairDiscountPercentage_Internalname, GXutil.ltrim( localUtil.ntoc( A39RepairDiscountPercentage, (byte)(3), (byte)(0), ",", "")), ((edtRepairDiscountPercentage_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), "ZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), "ZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,104);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairDiscountPercentage_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRepairDiscountPercentage_Enabled, 0, "number", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Percentage", "right", false, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRepairFinalCost_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtRepairFinalCost_Internalname, "Final Cost", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairFinalCost_Internalname, GXutil.ltrim( localUtil.ntoc( A40RepairFinalCost, (byte)(8), (byte)(2), ",", "")), ((edtRepairFinalCost_Enabled!=0) ? GXutil.ltrim( localUtil.format( A40RepairFinalCost, "ZZZZ9.99")) : localUtil.format( A40RepairFinalCost, "ZZZZ9.99")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairFinalCost_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRepairFinalCost_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Cost", "right", false, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRepairProblems_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtRepairProblems_Internalname, "Problems", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairProblems_Internalname, GXutil.ltrim( localUtil.ntoc( A42RepairProblems, (byte)(1), (byte)(0), ",", "")), ((edtRepairProblems_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A42RepairProblems), "9")) : localUtil.format( DecimalUtil.doubleToDec(A42RepairProblems), "9")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairProblems_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRepairProblems_Enabled, 0, "number", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 LevelTable", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, divKindtable_Internalname, 1, 0, "px", 0, "px", "LevelTable", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Text block */
      com.parks.GxWebStd.gx_label_ctrl( httpContext, lblTitlekind_Internalname, "Kind", "", "", lblTitlekind_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      gxdraw_gridrepair_kind( ) ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 131,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 135,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Repair.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridrepair_kind( )
   {
      /*  Grid Control  */
      Gridrepair_kindContainer.AddObjectProperty("GridName", "Gridrepair_kind");
      Gridrepair_kindContainer.AddObjectProperty("Header", subGridrepair_kind_Header);
      Gridrepair_kindContainer.AddObjectProperty("Class", "Grid");
      Gridrepair_kindContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridrepair_kind_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddObjectProperty("CmpContext", "");
      Gridrepair_kindContainer.AddObjectProperty("InMasterPage", "false");
      Gridrepair_kindColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridrepair_kindColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A43RepairKindId, (byte)(4), (byte)(0), ".", "")));
      Gridrepair_kindColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtRepairKindId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddColumnProperties(Gridrepair_kindColumn);
      Gridrepair_kindColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridrepair_kindColumn.AddObjectProperty("Value", GXutil.rtrim( A44RepairKindName));
      Gridrepair_kindColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbRepairKindName.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddColumnProperties(Gridrepair_kindColumn);
      Gridrepair_kindColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridrepair_kindColumn.AddObjectProperty("Value", GXutil.rtrim( A45RepairKindRemarks));
      Gridrepair_kindColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtRepairKindRemarks_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddColumnProperties(Gridrepair_kindColumn);
      Gridrepair_kindContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridrepair_kind_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridrepair_kind_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridrepair_kind_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridrepair_kind_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridrepair_kind_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridrepair_kind_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridrepair_kindContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridrepair_kind_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_123_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount10 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_10 = (short)(1) ;
            scanStart0710( ) ;
            while ( RcdFound10 != 0 )
            {
               init_level_properties10( ) ;
               getByPrimaryKey0710( ) ;
               addRow0710( ) ;
               scanNext0710( ) ;
            }
            scanEnd0710( ) ;
            nBlankRcdCount10 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0710( ) ;
         standaloneModal0710( ) ;
         sMode10 = Gx_mode ;
         while ( nGXsfl_123_idx < nRC_GXsfl_123 )
         {
            bGXsfl_123_Refreshing = true ;
            readRow0710( ) ;
            edtRepairKindId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "REPAIRKINDID_"+sGXsfl_123_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtRepairKindId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairKindId_Enabled), 5, 0), !bGXsfl_123_Refreshing);
            cmbRepairKindName.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "REPAIRKINDNAME_"+sGXsfl_123_idx+"Enabled"), ",", ".")) );
            httpContext.ajax_rsp_assign_prop("", false, cmbRepairKindName.getInternalname(), "Enabled", GXutil.ltrimstr( cmbRepairKindName.getEnabled(), 5, 0), !bGXsfl_123_Refreshing);
            edtRepairKindRemarks_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "REPAIRKINDREMARKS_"+sGXsfl_123_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtRepairKindRemarks_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairKindRemarks_Enabled), 5, 0), !bGXsfl_123_Refreshing);
            if ( ( nRcdExists_10 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0710( ) ;
            }
            sendRow0710( ) ;
            bGXsfl_123_Refreshing = false ;
         }
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount10 = (short)(5) ;
         nRcdExists_10 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0710( ) ;
            while ( RcdFound10 != 0 )
            {
               sGXsfl_123_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_123_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_12310( ) ;
               init_level_properties10( ) ;
               standaloneNotModal0710( ) ;
               getByPrimaryKey0710( ) ;
               standaloneModal0710( ) ;
               addRow0710( ) ;
               scanNext0710( ) ;
            }
            scanEnd0710( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode10 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_123_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_123_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_12310( ) ;
         initAll0710( ) ;
         init_level_properties10( ) ;
         nRcdExists_10 = (short)(0) ;
         nIsMod_10 = (short)(0) ;
         nRcdDeleted_10 = (short)(0) ;
         nBlankRcdCount10 = (short)(nBlankRcdUsr10+nBlankRcdCount10) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount10 > 0 )
         {
            standaloneNotModal0710( ) ;
            standaloneModal0710( ) ;
            addRow0710( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtRepairKindId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount10 = (short)(nBlankRcdCount10-1) ;
         }
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridrepair_kindContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridrepair_kind", Gridrepair_kindContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.parks.GxWebStd.gx_hidden_field( httpContext, "Gridrepair_kindContainerData", Gridrepair_kindContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.parks.GxWebStd.gx_hidden_field( httpContext, "Gridrepair_kindContainerData"+"V", Gridrepair_kindContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridrepair_kindContainerData"+"V"+"\" value='"+Gridrepair_kindContainer.GridValuesHidden()+"'/>") ;
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
      e11072 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z27RepairId = (short)(localUtil.ctol( httpContext.cgiGet( "Z27RepairId"), ",", ".")) ;
            Z28RepairBeginDate = localUtil.ctod( httpContext.cgiGet( "Z28RepairBeginDate"), 0) ;
            Z29RepairDays = (short)(localUtil.ctol( httpContext.cgiGet( "Z29RepairDays"), ",", ".")) ;
            Z34RepairCost = localUtil.ctond( httpContext.cgiGet( "Z34RepairCost")) ;
            Z39RepairDiscountPercentage = (short)(localUtil.ctol( httpContext.cgiGet( "Z39RepairDiscountPercentage"), ",", ".")) ;
            Z17GameId = (short)(localUtil.ctol( httpContext.cgiGet( "Z17GameId"), ",", ".")) ;
            Z30TechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( "Z30TechnicianId"), ",", ".")) ;
            Z35TechnicianAlternateId = (short)(localUtil.ctol( httpContext.cgiGet( "Z35TechnicianAlternateId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_123 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_123"), ",", ".")) ;
            N17GameId = (short)(localUtil.ctol( httpContext.cgiGet( "N17GameId"), ",", ".")) ;
            N30TechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( "N30TechnicianId"), ",", ".")) ;
            N35TechnicianAlternateId = (short)(localUtil.ctol( httpContext.cgiGet( "N35TechnicianAlternateId"), ",", ".")) ;
            AV7RepairId = (short)(localUtil.ctol( httpContext.cgiGet( "vREPAIRID"), ",", ".")) ;
            AV11Insert_GameId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_GAMEID"), ",", ".")) ;
            AV12Insert_TechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_TECHNICIANID"), ",", ".")) ;
            AV13Insert_TechnicianAlternateId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_TECHNICIANALTERNATEID"), ",", ".")) ;
            AV18Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            /* Read variables values. */
            A27RepairId = (short)(localUtil.ctol( httpContext.cgiGet( edtRepairId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
            if ( localUtil.vcdate( httpContext.cgiGet( edtRepairBeginDate_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "REPAIRBEGINDATE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRepairBeginDate_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A28RepairBeginDate = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A28RepairBeginDate", localUtil.format(A28RepairBeginDate, "99/99/99"));
            }
            else
            {
               A28RepairBeginDate = localUtil.ctod( httpContext.cgiGet( edtRepairBeginDate_Internalname), 3) ;
               httpContext.ajax_rsp_assign_attri("", false, "A28RepairBeginDate", localUtil.format(A28RepairBeginDate, "99/99/99"));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRepairDays_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRepairDays_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "REPAIRDAYS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRepairDays_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A29RepairDays = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A29RepairDays", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29RepairDays), 4, 0));
            }
            else
            {
               A29RepairDays = (short)(localUtil.ctol( httpContext.cgiGet( edtRepairDays_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A29RepairDays", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29RepairDays), 4, 0));
            }
            A41RepairDateTo = localUtil.ctod( httpContext.cgiGet( edtRepairDateTo_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "A41RepairDateTo", localUtil.format(A41RepairDateTo, "99/99/99"));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtGameId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtGameId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "GAMEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtGameId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A17GameId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
            }
            else
            {
               A17GameId = (short)(localUtil.ctol( httpContext.cgiGet( edtGameId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
            }
            A18GameName = httpContext.cgiGet( edtGameName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTechnicianId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTechnicianId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TECHNICIANID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTechnicianId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A30TechnicianId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
            }
            else
            {
               A30TechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( edtTechnicianId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
            }
            A31TechnicianName = httpContext.cgiGet( edtTechnicianName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A31TechnicianName", A31TechnicianName);
            A32TechnicianLastName = httpContext.cgiGet( edtTechnicianLastName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A32TechnicianLastName", A32TechnicianLastName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTechnicianAlternateId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTechnicianAlternateId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TECHNICIANALTERNATEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTechnicianAlternateId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A35TechnicianAlternateId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A35TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35TechnicianAlternateId), 4, 0));
            }
            else
            {
               A35TechnicianAlternateId = (short)(localUtil.ctol( httpContext.cgiGet( edtTechnicianAlternateId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A35TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35TechnicianAlternateId), 4, 0));
            }
            A36TechnicianAlternateName = httpContext.cgiGet( edtTechnicianAlternateName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
            A37TechnicianAlternateLastName = httpContext.cgiGet( edtTechnicianAlternateLastName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
            A38TechnicianAlternatePhone = httpContext.cgiGet( edtTechnicianAlternatePhone_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtRepairCost_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtRepairCost_Internalname)), DecimalUtil.stringToDec("99999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "REPAIRCOST");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRepairCost_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A34RepairCost = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A34RepairCost", GXutil.ltrimstr( A34RepairCost, 8, 2));
            }
            else
            {
               A34RepairCost = localUtil.ctond( httpContext.cgiGet( edtRepairCost_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A34RepairCost", GXutil.ltrimstr( A34RepairCost, 8, 2));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRepairDiscountPercentage_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRepairDiscountPercentage_Internalname), ",", ".") > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "REPAIRDISCOUNTPERCENTAGE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRepairDiscountPercentage_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A39RepairDiscountPercentage = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A39RepairDiscountPercentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), 3, 0));
            }
            else
            {
               A39RepairDiscountPercentage = (short)(localUtil.ctol( httpContext.cgiGet( edtRepairDiscountPercentage_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A39RepairDiscountPercentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), 3, 0));
            }
            A40RepairFinalCost = localUtil.ctond( httpContext.cgiGet( edtRepairFinalCost_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A40RepairFinalCost", GXutil.ltrimstr( A40RepairFinalCost, 8, 2));
            A42RepairProblems = (byte)(localUtil.ctol( httpContext.cgiGet( edtRepairProblems_Internalname), ",", ".")) ;
            n42RepairProblems = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Repair");
            A27RepairId = (short)(localUtil.ctol( httpContext.cgiGet( edtRepairId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
            forbiddenHiddens.add("RepairId", localUtil.format( DecimalUtil.doubleToDec(A27RepairId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A27RepairId != Z27RepairId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("repair:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A27RepairId = (short)(GXutil.lval( httpContext.GetPar( "RepairId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
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
                  sMode8 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode8 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound8 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_070( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "REPAIRID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtRepairId_Internalname ;
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
                        e11072 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12072 ();
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
         e12072 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll078( ) ;
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
         disableAttributes078( ) ;
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

   public void confirm_070( )
   {
      beforeValidate078( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls078( ) ;
         }
         else
         {
            checkExtendedTable078( ) ;
            closeExtendedTableCursors078( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode8 = Gx_mode ;
         confirm_0710( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode8 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode8 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0710( )
   {
      nGXsfl_123_idx = 0 ;
      while ( nGXsfl_123_idx < nRC_GXsfl_123 )
      {
         readRow0710( ) ;
         if ( ( nRcdExists_10 != 0 ) || ( nIsMod_10 != 0 ) )
         {
            getKey0710( ) ;
            if ( ( nRcdExists_10 == 0 ) && ( nRcdDeleted_10 == 0 ) )
            {
               if ( RcdFound10 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0710( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0710( ) ;
                     closeExtendedTableCursors0710( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "REPAIRKINDID_" + sGXsfl_123_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtRepairKindId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound10 != 0 )
               {
                  if ( nRcdDeleted_10 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0710( ) ;
                     load0710( ) ;
                     beforeValidate0710( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0710( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_10 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0710( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0710( ) ;
                           closeExtendedTableCursors0710( ) ;
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
                  if ( nRcdDeleted_10 == 0 )
                  {
                     GXCCtl = "REPAIRKINDID_" + sGXsfl_123_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtRepairKindId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtRepairKindId_Internalname, GXutil.ltrim( localUtil.ntoc( A43RepairKindId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( cmbRepairKindName.getInternalname(), GXutil.rtrim( A44RepairKindName)) ;
         httpContext.changePostValue( edtRepairKindRemarks_Internalname, GXutil.rtrim( A45RepairKindRemarks)) ;
         httpContext.changePostValue( "ZT_"+"Z43RepairKindId_"+sGXsfl_123_idx, GXutil.ltrim( localUtil.ntoc( Z43RepairKindId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z44RepairKindName_"+sGXsfl_123_idx, GXutil.rtrim( Z44RepairKindName)) ;
         httpContext.changePostValue( "ZT_"+"Z45RepairKindRemarks_"+sGXsfl_123_idx, GXutil.rtrim( Z45RepairKindRemarks)) ;
         httpContext.changePostValue( "nRcdDeleted_10_"+sGXsfl_123_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_10, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_10_"+sGXsfl_123_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_10, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_10_"+sGXsfl_123_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_10, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_10 != 0 )
         {
            httpContext.changePostValue( "REPAIRKINDID_"+sGXsfl_123_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRepairKindId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "REPAIRKINDNAME_"+sGXsfl_123_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbRepairKindName.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "REPAIRKINDREMARKS_"+sGXsfl_123_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRepairKindRemarks_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* Using cursor T00075 */
      pr_default.execute(2, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         A42RepairProblems = T00075_A42RepairProblems[0] ;
         n42RepairProblems = T00075_n42RepairProblems[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      else
      {
         A42RepairProblems = (byte)(0) ;
         n42RepairProblems = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      /* End of After( level) rules */
   }

   public void resetCaption070( )
   {
   }

   public void e11072( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.parks.isauthorized(remoteHandle, context).executeUdp( AV18Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.parks.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      AV11Insert_GameId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_GameId), 4, 0));
      AV12Insert_TechnicianId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_TechnicianId), 4, 0));
      AV13Insert_TechnicianAlternateId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_TechnicianAlternateId), 4, 0));
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtTransactionContext_Transactionname(), AV18Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV19GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19GXV1), 8, 0));
         while ( AV19GXV1 <= AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.parks.SdtTransactionContext_Attribute)((com.parks.SdtTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().elementAt(-1+AV19GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "GameId") == 0 )
            {
               AV11Insert_GameId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_GameId), 4, 0));
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "TechnicianId") == 0 )
            {
               AV12Insert_TechnicianId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_TechnicianId), 4, 0));
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "TechnicianAlternateId") == 0 )
            {
               AV13Insert_TechnicianAlternateId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_TechnicianAlternateId), 4, 0));
            }
            AV19GXV1 = (int)(AV19GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19GXV1), 8, 0));
         }
      }
   }

   public void e12072( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.parks.wwrepair", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm078( int GX_JID )
   {
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z28RepairBeginDate = T00077_A28RepairBeginDate[0] ;
            Z29RepairDays = T00077_A29RepairDays[0] ;
            Z34RepairCost = T00077_A34RepairCost[0] ;
            Z39RepairDiscountPercentage = T00077_A39RepairDiscountPercentage[0] ;
            Z17GameId = T00077_A17GameId[0] ;
            Z30TechnicianId = T00077_A30TechnicianId[0] ;
            Z35TechnicianAlternateId = T00077_A35TechnicianAlternateId[0] ;
         }
         else
         {
            Z28RepairBeginDate = A28RepairBeginDate ;
            Z29RepairDays = A29RepairDays ;
            Z34RepairCost = A34RepairCost ;
            Z39RepairDiscountPercentage = A39RepairDiscountPercentage ;
            Z17GameId = A17GameId ;
            Z30TechnicianId = A30TechnicianId ;
            Z35TechnicianAlternateId = A35TechnicianAlternateId ;
         }
      }
      if ( GX_JID == -19 )
      {
         Z27RepairId = A27RepairId ;
         Z28RepairBeginDate = A28RepairBeginDate ;
         Z29RepairDays = A29RepairDays ;
         Z34RepairCost = A34RepairCost ;
         Z39RepairDiscountPercentage = A39RepairDiscountPercentage ;
         Z17GameId = A17GameId ;
         Z30TechnicianId = A30TechnicianId ;
         Z35TechnicianAlternateId = A35TechnicianAlternateId ;
         Z42RepairProblems = A42RepairProblems ;
         Z18GameName = A18GameName ;
         Z31TechnicianName = A31TechnicianName ;
         Z32TechnicianLastName = A32TechnicianLastName ;
         Z36TechnicianAlternateName = A36TechnicianAlternateName ;
         Z37TechnicianAlternateLastName = A37TechnicianAlternateLastName ;
         Z38TechnicianAlternatePhone = A38TechnicianAlternatePhone ;
      }
   }

   public void standaloneNotModal( )
   {
      edtRepairId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairId_Enabled), 5, 0), true);
      imgprompt_17_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.parks.gx0050"+"',["+"{Ctrl:gx.dom.el('"+"GAMEID"+"'), id:'"+"GAMEID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_30_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.parks.gx0090"+"',["+"{Ctrl:gx.dom.el('"+"TECHNICIANID"+"'), id:'"+"TECHNICIANID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_35_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.parks.gx0090"+"',["+"{Ctrl:gx.dom.el('"+"TECHNICIANALTERNATEID"+"'), id:'"+"TECHNICIANALTERNATEID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      edtRepairId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairId_Enabled), 5, 0), true);
      bttBtn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7RepairId) )
      {
         A27RepairId = AV7RepairId ;
         httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_GameId) )
      {
         edtGameId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtGameId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtGameId_Enabled), 5, 0), true);
      }
      else
      {
         edtGameId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtGameId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtGameId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_TechnicianId) )
      {
         edtTechnicianId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTechnicianId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianId_Enabled), 5, 0), true);
      }
      else
      {
         edtTechnicianId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTechnicianId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TechnicianAlternateId) )
      {
         edtTechnicianAlternateId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTechnicianAlternateId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianAlternateId_Enabled), 5, 0), true);
      }
      else
      {
         edtTechnicianAlternateId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTechnicianAlternateId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianAlternateId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_TechnicianAlternateId) )
      {
         A35TechnicianAlternateId = AV13Insert_TechnicianAlternateId ;
         httpContext.ajax_rsp_assign_attri("", false, "A35TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35TechnicianAlternateId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_TechnicianId) )
      {
         A30TechnicianId = AV12Insert_TechnicianId ;
         httpContext.ajax_rsp_assign_attri("", false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_GameId) )
      {
         A17GameId = AV11Insert_GameId ;
         httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
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
         /* Using cursor T00075 */
         pr_default.execute(2, new Object[] {Short.valueOf(A27RepairId)});
         if ( (pr_default.getStatus(2) != 101) )
         {
            A42RepairProblems = T00075_A42RepairProblems[0] ;
            n42RepairProblems = T00075_n42RepairProblems[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
         }
         else
         {
            A42RepairProblems = (byte)(0) ;
            n42RepairProblems = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
         }
         pr_default.close(2);
         AV18Pgmname = "Repair" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
         /* Using cursor T000710 */
         pr_default.execute(7, new Object[] {Short.valueOf(A35TechnicianAlternateId)});
         A36TechnicianAlternateName = T000710_A36TechnicianAlternateName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
         A37TechnicianAlternateLastName = T000710_A37TechnicianAlternateLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
         A38TechnicianAlternatePhone = T000710_A38TechnicianAlternatePhone[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
         pr_default.close(7);
         /* Using cursor T00079 */
         pr_default.execute(6, new Object[] {Short.valueOf(A30TechnicianId)});
         A31TechnicianName = T00079_A31TechnicianName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31TechnicianName", A31TechnicianName);
         A32TechnicianLastName = T00079_A32TechnicianLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TechnicianLastName", A32TechnicianLastName);
         pr_default.close(6);
         /* Using cursor T00078 */
         pr_default.execute(5, new Object[] {Short.valueOf(A17GameId)});
         A18GameName = T00078_A18GameName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
         pr_default.close(5);
      }
   }

   public void load078( )
   {
      /* Using cursor T000712 */
      pr_default.execute(8, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A28RepairBeginDate = T000712_A28RepairBeginDate[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A28RepairBeginDate", localUtil.format(A28RepairBeginDate, "99/99/99"));
         A29RepairDays = T000712_A29RepairDays[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29RepairDays", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29RepairDays), 4, 0));
         A18GameName = T000712_A18GameName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
         A31TechnicianName = T000712_A31TechnicianName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31TechnicianName", A31TechnicianName);
         A32TechnicianLastName = T000712_A32TechnicianLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TechnicianLastName", A32TechnicianLastName);
         A36TechnicianAlternateName = T000712_A36TechnicianAlternateName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
         A37TechnicianAlternateLastName = T000712_A37TechnicianAlternateLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
         A38TechnicianAlternatePhone = T000712_A38TechnicianAlternatePhone[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
         A34RepairCost = T000712_A34RepairCost[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34RepairCost", GXutil.ltrimstr( A34RepairCost, 8, 2));
         A39RepairDiscountPercentage = T000712_A39RepairDiscountPercentage[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39RepairDiscountPercentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), 3, 0));
         A17GameId = T000712_A17GameId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
         A30TechnicianId = T000712_A30TechnicianId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
         A35TechnicianAlternateId = T000712_A35TechnicianAlternateId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A35TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35TechnicianAlternateId), 4, 0));
         A42RepairProblems = T000712_A42RepairProblems[0] ;
         n42RepairProblems = T000712_n42RepairProblems[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
         zm078( -19) ;
      }
      pr_default.close(8);
      onLoadActions078( ) ;
   }

   public void onLoadActions078( )
   {
      AV18Pgmname = "Repair" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      A41RepairDateTo = GXutil.dadd(A28RepairBeginDate,+((int)(A29RepairDays))) ;
      httpContext.ajax_rsp_assign_attri("", false, "A41RepairDateTo", localUtil.format(A41RepairDateTo, "99/99/99"));
      A40RepairFinalCost = A34RepairCost.multiply(DecimalUtil.doubleToDec((1-A39RepairDiscountPercentage/ (double) (100)))) ;
      httpContext.ajax_rsp_assign_attri("", false, "A40RepairFinalCost", GXutil.ltrimstr( A40RepairFinalCost, 8, 2));
   }

   public void checkExtendedTable078( )
   {
      nIsDirty_8 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV18Pgmname = "Repair" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      /* Using cursor T00075 */
      pr_default.execute(2, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         A42RepairProblems = T00075_A42RepairProblems[0] ;
         n42RepairProblems = T00075_n42RepairProblems[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      else
      {
         nIsDirty_8 = (short)(1) ;
         A42RepairProblems = (byte)(0) ;
         n42RepairProblems = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      pr_default.close(2);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A28RepairBeginDate)) || (( GXutil.resetTime(A28RepairBeginDate).after( GXutil.resetTime( localUtil.ymdtod( 1000, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A28RepairBeginDate), GXutil.resetTime(localUtil.ymdtod( 1000, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Repair Begin Date fuera de rango", "OutOfRange", 1, "REPAIRBEGINDATE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRepairBeginDate_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_8 = (short)(1) ;
      A41RepairDateTo = GXutil.dadd(A28RepairBeginDate,+((int)(A29RepairDays))) ;
      httpContext.ajax_rsp_assign_attri("", false, "A41RepairDateTo", localUtil.format(A41RepairDateTo, "99/99/99"));
      /* Using cursor T00078 */
      pr_default.execute(5, new Object[] {Short.valueOf(A17GameId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Game'.", "ForeignKeyNotFound", 1, "GAMEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtGameId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A18GameName = T00078_A18GameName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
      pr_default.close(5);
      /* Using cursor T00079 */
      pr_default.execute(6, new Object[] {Short.valueOf(A30TechnicianId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Technician'.", "ForeignKeyNotFound", 1, "TECHNICIANID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTechnicianId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A31TechnicianName = T00079_A31TechnicianName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A31TechnicianName", A31TechnicianName);
      A32TechnicianLastName = T00079_A32TechnicianLastName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A32TechnicianLastName", A32TechnicianLastName);
      pr_default.close(6);
      /* Using cursor T000710 */
      pr_default.execute(7, new Object[] {Short.valueOf(A35TechnicianAlternateId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Technician Alternate'.", "ForeignKeyNotFound", 1, "TECHNICIANALTERNATEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTechnicianAlternateId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A36TechnicianAlternateName = T000710_A36TechnicianAlternateName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
      A37TechnicianAlternateLastName = T000710_A37TechnicianAlternateLastName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
      A38TechnicianAlternatePhone = T000710_A38TechnicianAlternatePhone[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
      pr_default.close(7);
      nIsDirty_8 = (short)(1) ;
      A40RepairFinalCost = A34RepairCost.multiply(DecimalUtil.doubleToDec((1-A39RepairDiscountPercentage/ (double) (100)))) ;
      httpContext.ajax_rsp_assign_attri("", false, "A40RepairFinalCost", GXutil.ltrimstr( A40RepairFinalCost, 8, 2));
   }

   public void closeExtendedTableCursors078( )
   {
      pr_default.close(2);
      pr_default.close(5);
      pr_default.close(6);
      pr_default.close(7);
   }

   public void enableDisable( )
   {
   }

   public void gxload_23( short A27RepairId )
   {
      /* Using cursor T000714 */
      pr_default.execute(9, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         A42RepairProblems = T000714_A42RepairProblems[0] ;
         n42RepairProblems = T000714_n42RepairProblems[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      else
      {
         A42RepairProblems = (byte)(0) ;
         n42RepairProblems = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A42RepairProblems, (byte)(1), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_20( short A17GameId )
   {
      /* Using cursor T000715 */
      pr_default.execute(10, new Object[] {Short.valueOf(A17GameId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Game'.", "ForeignKeyNotFound", 1, "GAMEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtGameId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A18GameName = T000715_A18GameName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A18GameName))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_21( short A30TechnicianId )
   {
      /* Using cursor T000716 */
      pr_default.execute(11, new Object[] {Short.valueOf(A30TechnicianId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Technician'.", "ForeignKeyNotFound", 1, "TECHNICIANID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTechnicianId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A31TechnicianName = T000716_A31TechnicianName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A31TechnicianName", A31TechnicianName);
      A32TechnicianLastName = T000716_A32TechnicianLastName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A32TechnicianLastName", A32TechnicianLastName);
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A31TechnicianName))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A32TechnicianLastName))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_22( short A35TechnicianAlternateId )
   {
      /* Using cursor T000717 */
      pr_default.execute(12, new Object[] {Short.valueOf(A35TechnicianAlternateId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Technician Alternate'.", "ForeignKeyNotFound", 1, "TECHNICIANALTERNATEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTechnicianAlternateId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A36TechnicianAlternateName = T000717_A36TechnicianAlternateName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
      A37TechnicianAlternateLastName = T000717_A37TechnicianAlternateLastName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
      A38TechnicianAlternatePhone = T000717_A38TechnicianAlternatePhone[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A36TechnicianAlternateName))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A37TechnicianAlternateLastName))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A38TechnicianAlternatePhone))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void getKey078( )
   {
      /* Using cursor T000718 */
      pr_default.execute(13, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound8 = (short)(1) ;
      }
      else
      {
         RcdFound8 = (short)(0) ;
      }
      pr_default.close(13);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00077 */
      pr_default.execute(4, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm078( 19) ;
         RcdFound8 = (short)(1) ;
         A27RepairId = T00077_A27RepairId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
         A28RepairBeginDate = T00077_A28RepairBeginDate[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A28RepairBeginDate", localUtil.format(A28RepairBeginDate, "99/99/99"));
         A29RepairDays = T00077_A29RepairDays[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29RepairDays", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29RepairDays), 4, 0));
         A34RepairCost = T00077_A34RepairCost[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34RepairCost", GXutil.ltrimstr( A34RepairCost, 8, 2));
         A39RepairDiscountPercentage = T00077_A39RepairDiscountPercentage[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39RepairDiscountPercentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), 3, 0));
         A17GameId = T00077_A17GameId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
         A30TechnicianId = T00077_A30TechnicianId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
         A35TechnicianAlternateId = T00077_A35TechnicianAlternateId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A35TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35TechnicianAlternateId), 4, 0));
         Z27RepairId = A27RepairId ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load078( ) ;
         if ( AnyError == 1 )
         {
            RcdFound8 = (short)(0) ;
            initializeNonKey078( ) ;
         }
         Gx_mode = sMode8 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound8 = (short)(0) ;
         initializeNonKey078( ) ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode8 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey078( ) ;
      if ( RcdFound8 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound8 = (short)(0) ;
      /* Using cursor T000719 */
      pr_default.execute(14, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         while ( (pr_default.getStatus(14) != 101) && ( ( T000719_A27RepairId[0] < A27RepairId ) ) )
         {
            pr_default.readNext(14);
         }
         if ( (pr_default.getStatus(14) != 101) && ( ( T000719_A27RepairId[0] > A27RepairId ) ) )
         {
            A27RepairId = T000719_A27RepairId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
            RcdFound8 = (short)(1) ;
         }
      }
      pr_default.close(14);
   }

   public void move_previous( )
   {
      RcdFound8 = (short)(0) ;
      /* Using cursor T000720 */
      pr_default.execute(15, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         while ( (pr_default.getStatus(15) != 101) && ( ( T000720_A27RepairId[0] > A27RepairId ) ) )
         {
            pr_default.readNext(15);
         }
         if ( (pr_default.getStatus(15) != 101) && ( ( T000720_A27RepairId[0] < A27RepairId ) ) )
         {
            A27RepairId = T000720_A27RepairId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
            RcdFound8 = (short)(1) ;
         }
      }
      pr_default.close(15);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey078( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtRepairBeginDate_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert078( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound8 == 1 )
         {
            if ( A27RepairId != Z27RepairId )
            {
               A27RepairId = Z27RepairId ;
               httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "REPAIRID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRepairId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtRepairBeginDate_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update078( ) ;
               GX_FocusControl = edtRepairBeginDate_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A27RepairId != Z27RepairId )
            {
               /* Insert record */
               GX_FocusControl = edtRepairBeginDate_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert078( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "REPAIRID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtRepairId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtRepairBeginDate_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert078( ) ;
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
      if ( A27RepairId != Z27RepairId )
      {
         A27RepairId = Z27RepairId ;
         httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "REPAIRID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRepairId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtRepairBeginDate_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency078( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00076 */
         pr_default.execute(3, new Object[] {Short.valueOf(A27RepairId)});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Repair"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(3) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z28RepairBeginDate), GXutil.resetTime(T00076_A28RepairBeginDate[0])) ) || ( Z29RepairDays != T00076_A29RepairDays[0] ) || ( DecimalUtil.compareTo(Z34RepairCost, T00076_A34RepairCost[0]) != 0 ) || ( Z39RepairDiscountPercentage != T00076_A39RepairDiscountPercentage[0] ) || ( Z17GameId != T00076_A17GameId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z30TechnicianId != T00076_A30TechnicianId[0] ) || ( Z35TechnicianAlternateId != T00076_A35TechnicianAlternateId[0] ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z28RepairBeginDate), GXutil.resetTime(T00076_A28RepairBeginDate[0])) ) )
            {
               GXutil.writeLogln("repair:[seudo value changed for attri]"+"RepairBeginDate");
               GXutil.writeLogRaw("Old: ",Z28RepairBeginDate);
               GXutil.writeLogRaw("Current: ",T00076_A28RepairBeginDate[0]);
            }
            if ( Z29RepairDays != T00076_A29RepairDays[0] )
            {
               GXutil.writeLogln("repair:[seudo value changed for attri]"+"RepairDays");
               GXutil.writeLogRaw("Old: ",Z29RepairDays);
               GXutil.writeLogRaw("Current: ",T00076_A29RepairDays[0]);
            }
            if ( DecimalUtil.compareTo(Z34RepairCost, T00076_A34RepairCost[0]) != 0 )
            {
               GXutil.writeLogln("repair:[seudo value changed for attri]"+"RepairCost");
               GXutil.writeLogRaw("Old: ",Z34RepairCost);
               GXutil.writeLogRaw("Current: ",T00076_A34RepairCost[0]);
            }
            if ( Z39RepairDiscountPercentage != T00076_A39RepairDiscountPercentage[0] )
            {
               GXutil.writeLogln("repair:[seudo value changed for attri]"+"RepairDiscountPercentage");
               GXutil.writeLogRaw("Old: ",Z39RepairDiscountPercentage);
               GXutil.writeLogRaw("Current: ",T00076_A39RepairDiscountPercentage[0]);
            }
            if ( Z17GameId != T00076_A17GameId[0] )
            {
               GXutil.writeLogln("repair:[seudo value changed for attri]"+"GameId");
               GXutil.writeLogRaw("Old: ",Z17GameId);
               GXutil.writeLogRaw("Current: ",T00076_A17GameId[0]);
            }
            if ( Z30TechnicianId != T00076_A30TechnicianId[0] )
            {
               GXutil.writeLogln("repair:[seudo value changed for attri]"+"TechnicianId");
               GXutil.writeLogRaw("Old: ",Z30TechnicianId);
               GXutil.writeLogRaw("Current: ",T00076_A30TechnicianId[0]);
            }
            if ( Z35TechnicianAlternateId != T00076_A35TechnicianAlternateId[0] )
            {
               GXutil.writeLogln("repair:[seudo value changed for attri]"+"TechnicianAlternateId");
               GXutil.writeLogRaw("Old: ",Z35TechnicianAlternateId);
               GXutil.writeLogRaw("Current: ",T00076_A35TechnicianAlternateId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Repair"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert078( )
   {
      beforeValidate078( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable078( ) ;
      }
      if ( AnyError == 0 )
      {
         zm078( 0) ;
         checkOptimisticConcurrency078( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm078( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert078( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000721 */
                  pr_default.execute(16, new Object[] {A28RepairBeginDate, Short.valueOf(A29RepairDays), A34RepairCost, Short.valueOf(A39RepairDiscountPercentage), Short.valueOf(A17GameId), Short.valueOf(A30TechnicianId), Short.valueOf(A35TechnicianAlternateId)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000722 */
                  pr_default.execute(17);
                  A27RepairId = T000722_A27RepairId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
                  pr_default.close(17);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Repair");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( level) rules */
                     if ( A35TechnicianAlternateId == A30TechnicianId )
                     {
                        httpContext.GX_msglist.addItem("El tecnico suplente no puede ser el mismo que el titular", 1, "TECHNICIANID");
                        AnyError = (short)(1) ;
                        GX_FocusControl = edtTechnicianId_Internalname ;
                        httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                     }
                     /* End of After( level) rules */
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel078( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption070( ) ;
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
            load078( ) ;
         }
         endLevel078( ) ;
      }
      closeExtendedTableCursors078( ) ;
   }

   public void update078( )
   {
      beforeValidate078( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable078( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency078( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm078( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate078( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000723 */
                  pr_default.execute(18, new Object[] {A28RepairBeginDate, Short.valueOf(A29RepairDays), A34RepairCost, Short.valueOf(A39RepairDiscountPercentage), Short.valueOf(A17GameId), Short.valueOf(A30TechnicianId), Short.valueOf(A35TechnicianAlternateId), Short.valueOf(A27RepairId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Repair");
                  if ( (pr_default.getStatus(18) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Repair"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate078( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( level) rules */
                     if ( A35TechnicianAlternateId == A30TechnicianId )
                     {
                        httpContext.GX_msglist.addItem("El tecnico suplente no puede ser el mismo que el titular", 1, "TECHNICIANID");
                        AnyError = (short)(1) ;
                        GX_FocusControl = edtTechnicianId_Internalname ;
                        httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                     }
                     /* End of After( level) rules */
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel078( ) ;
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
         endLevel078( ) ;
      }
      closeExtendedTableCursors078( ) ;
   }

   public void deferredUpdate078( )
   {
   }

   public void delete( )
   {
      beforeValidate078( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency078( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls078( ) ;
         afterConfirm078( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete078( ) ;
            if ( AnyError == 0 )
            {
               scanStart0710( ) ;
               while ( RcdFound10 != 0 )
               {
                  getByPrimaryKey0710( ) ;
                  delete0710( ) ;
                  scanNext0710( ) ;
               }
               scanEnd0710( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000724 */
                  pr_default.execute(19, new Object[] {Short.valueOf(A27RepairId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Repair");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( level) rules */
                     if ( A35TechnicianAlternateId == A30TechnicianId )
                     {
                        httpContext.GX_msglist.addItem("El tecnico suplente no puede ser el mismo que el titular", 1, "TECHNICIANID");
                        AnyError = (short)(1) ;
                        GX_FocusControl = edtTechnicianId_Internalname ;
                        httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                     }
                     /* End of After( level) rules */
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
      sMode8 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel078( ) ;
      Gx_mode = sMode8 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls078( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV18Pgmname = "Repair" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
         /* Using cursor T000726 */
         pr_default.execute(20, new Object[] {Short.valueOf(A27RepairId)});
         if ( (pr_default.getStatus(20) != 101) )
         {
            A42RepairProblems = T000726_A42RepairProblems[0] ;
            n42RepairProblems = T000726_n42RepairProblems[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
         }
         else
         {
            A42RepairProblems = (byte)(0) ;
            n42RepairProblems = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
         }
         pr_default.close(20);
         A41RepairDateTo = GXutil.dadd(A28RepairBeginDate,+((int)(A29RepairDays))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A41RepairDateTo", localUtil.format(A41RepairDateTo, "99/99/99"));
         /* Using cursor T000727 */
         pr_default.execute(21, new Object[] {Short.valueOf(A17GameId)});
         A18GameName = T000727_A18GameName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
         pr_default.close(21);
         /* Using cursor T000728 */
         pr_default.execute(22, new Object[] {Short.valueOf(A30TechnicianId)});
         A31TechnicianName = T000728_A31TechnicianName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31TechnicianName", A31TechnicianName);
         A32TechnicianLastName = T000728_A32TechnicianLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TechnicianLastName", A32TechnicianLastName);
         pr_default.close(22);
         /* Using cursor T000729 */
         pr_default.execute(23, new Object[] {Short.valueOf(A35TechnicianAlternateId)});
         A36TechnicianAlternateName = T000729_A36TechnicianAlternateName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
         A37TechnicianAlternateLastName = T000729_A37TechnicianAlternateLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
         A38TechnicianAlternatePhone = T000729_A38TechnicianAlternatePhone[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
         pr_default.close(23);
         A40RepairFinalCost = A34RepairCost.multiply(DecimalUtil.doubleToDec((1-A39RepairDiscountPercentage/ (double) (100)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A40RepairFinalCost", GXutil.ltrimstr( A40RepairFinalCost, 8, 2));
      }
   }

   public void processNestedLevel0710( )
   {
      nGXsfl_123_idx = 0 ;
      while ( nGXsfl_123_idx < nRC_GXsfl_123 )
      {
         readRow0710( ) ;
         if ( ( nRcdExists_10 != 0 ) || ( nIsMod_10 != 0 ) )
         {
            standaloneNotModal0710( ) ;
            getKey0710( ) ;
            if ( ( nRcdExists_10 == 0 ) && ( nRcdDeleted_10 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0710( ) ;
            }
            else
            {
               if ( RcdFound10 != 0 )
               {
                  if ( ( nRcdDeleted_10 != 0 ) && ( nRcdExists_10 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0710( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_10 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0710( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_10 == 0 )
                  {
                     GXCCtl = "REPAIRKINDID_" + sGXsfl_123_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtRepairKindId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtRepairKindId_Internalname, GXutil.ltrim( localUtil.ntoc( A43RepairKindId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( cmbRepairKindName.getInternalname(), GXutil.rtrim( A44RepairKindName)) ;
         httpContext.changePostValue( edtRepairKindRemarks_Internalname, GXutil.rtrim( A45RepairKindRemarks)) ;
         httpContext.changePostValue( "ZT_"+"Z43RepairKindId_"+sGXsfl_123_idx, GXutil.ltrim( localUtil.ntoc( Z43RepairKindId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z44RepairKindName_"+sGXsfl_123_idx, GXutil.rtrim( Z44RepairKindName)) ;
         httpContext.changePostValue( "ZT_"+"Z45RepairKindRemarks_"+sGXsfl_123_idx, GXutil.rtrim( Z45RepairKindRemarks)) ;
         httpContext.changePostValue( "nRcdDeleted_10_"+sGXsfl_123_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_10, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_10_"+sGXsfl_123_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_10, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_10_"+sGXsfl_123_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_10, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_10 != 0 )
         {
            httpContext.changePostValue( "REPAIRKINDID_"+sGXsfl_123_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRepairKindId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "REPAIRKINDNAME_"+sGXsfl_123_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbRepairKindName.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "REPAIRKINDREMARKS_"+sGXsfl_123_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRepairKindRemarks_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* Using cursor T000726 */
      pr_default.execute(20, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(20) != 101) )
      {
         A42RepairProblems = T000726_A42RepairProblems[0] ;
         n42RepairProblems = T000726_n42RepairProblems[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      else
      {
         A42RepairProblems = (byte)(0) ;
         n42RepairProblems = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      /* End of After( level) rules */
      initAll0710( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_10 = (short)(0) ;
      nIsMod_10 = (short)(0) ;
      nRcdDeleted_10 = (short)(0) ;
   }

   public void processLevel078( )
   {
      /* Save parent mode. */
      sMode8 = Gx_mode ;
      processNestedLevel0710( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode8 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel078( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete078( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "repair");
         if ( AnyError == 0 )
         {
            confirmValues070( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "repair");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart078( )
   {
      /* Scan By routine */
      /* Using cursor T000730 */
      pr_default.execute(24);
      RcdFound8 = (short)(0) ;
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A27RepairId = T000730_A27RepairId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext078( )
   {
      /* Scan next routine */
      pr_default.readNext(24);
      RcdFound8 = (short)(0) ;
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A27RepairId = T000730_A27RepairId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
      }
   }

   public void scanEnd078( )
   {
      pr_default.close(24);
   }

   public void afterConfirm078( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert078( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate078( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete078( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete078( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate078( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes078( )
   {
      edtRepairId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairId_Enabled), 5, 0), true);
      edtRepairBeginDate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairBeginDate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairBeginDate_Enabled), 5, 0), true);
      edtRepairDays_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairDays_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairDays_Enabled), 5, 0), true);
      edtRepairDateTo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairDateTo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairDateTo_Enabled), 5, 0), true);
      edtGameId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtGameId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtGameId_Enabled), 5, 0), true);
      edtGameName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtGameName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtGameName_Enabled), 5, 0), true);
      edtTechnicianId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTechnicianId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianId_Enabled), 5, 0), true);
      edtTechnicianName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTechnicianName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianName_Enabled), 5, 0), true);
      edtTechnicianLastName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTechnicianLastName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianLastName_Enabled), 5, 0), true);
      edtTechnicianAlternateId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTechnicianAlternateId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianAlternateId_Enabled), 5, 0), true);
      edtTechnicianAlternateName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTechnicianAlternateName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianAlternateName_Enabled), 5, 0), true);
      edtTechnicianAlternateLastName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTechnicianAlternateLastName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianAlternateLastName_Enabled), 5, 0), true);
      edtTechnicianAlternatePhone_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTechnicianAlternatePhone_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTechnicianAlternatePhone_Enabled), 5, 0), true);
      edtRepairCost_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairCost_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairCost_Enabled), 5, 0), true);
      edtRepairDiscountPercentage_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairDiscountPercentage_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairDiscountPercentage_Enabled), 5, 0), true);
      edtRepairFinalCost_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairFinalCost_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairFinalCost_Enabled), 5, 0), true);
      edtRepairProblems_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairProblems_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairProblems_Enabled), 5, 0), true);
   }

   public void zm0710( int GX_JID )
   {
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z44RepairKindName = T00073_A44RepairKindName[0] ;
            Z45RepairKindRemarks = T00073_A45RepairKindRemarks[0] ;
         }
         else
         {
            Z44RepairKindName = A44RepairKindName ;
            Z45RepairKindRemarks = A45RepairKindRemarks ;
         }
      }
      if ( GX_JID == -24 )
      {
         Z27RepairId = A27RepairId ;
         Z43RepairKindId = A43RepairKindId ;
         Z44RepairKindName = A44RepairKindName ;
         Z45RepairKindRemarks = A45RepairKindRemarks ;
      }
   }

   public void standaloneNotModal0710( )
   {
   }

   public void standaloneModal0710( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtRepairKindId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRepairKindId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairKindId_Enabled), 5, 0), !bGXsfl_123_Refreshing);
      }
      else
      {
         edtRepairKindId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRepairKindId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairKindId_Enabled), 5, 0), !bGXsfl_123_Refreshing);
      }
   }

   public void load0710( )
   {
      /* Using cursor T000731 */
      pr_default.execute(25, new Object[] {Short.valueOf(A27RepairId), Short.valueOf(A43RepairKindId)});
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A44RepairKindName = T000731_A44RepairKindName[0] ;
         A45RepairKindRemarks = T000731_A45RepairKindRemarks[0] ;
         zm0710( -24) ;
      }
      pr_default.close(25);
      onLoadActions0710( ) ;
   }

   public void onLoadActions0710( )
   {
   }

   public void checkExtendedTable0710( )
   {
      nIsDirty_10 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0710( ) ;
      if ( ! ( ( GXutil.strcmp(A44RepairKindName, "E") == 0 ) || ( GXutil.strcmp(A44RepairKindName, "M") == 0 ) || ( GXutil.strcmp(A44RepairKindName, "R") == 0 ) ) )
      {
         GXCCtl = "REPAIRKINDNAME_" + sGXsfl_123_idx ;
         httpContext.GX_msglist.addItem("Campo Repair Kind Name fuera de rango", "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = cmbRepairKindName.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0710( )
   {
   }

   public void enableDisable0710( )
   {
   }

   public void getKey0710( )
   {
      /* Using cursor T000732 */
      pr_default.execute(26, new Object[] {Short.valueOf(A27RepairId), Short.valueOf(A43RepairKindId)});
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound10 = (short)(1) ;
      }
      else
      {
         RcdFound10 = (short)(0) ;
      }
      pr_default.close(26);
   }

   public void getByPrimaryKey0710( )
   {
      /* Using cursor T00073 */
      pr_default.execute(1, new Object[] {Short.valueOf(A27RepairId), Short.valueOf(A43RepairKindId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0710( 24) ;
         RcdFound10 = (short)(1) ;
         initializeNonKey0710( ) ;
         A43RepairKindId = T00073_A43RepairKindId[0] ;
         A44RepairKindName = T00073_A44RepairKindName[0] ;
         A45RepairKindRemarks = T00073_A45RepairKindRemarks[0] ;
         Z27RepairId = A27RepairId ;
         Z43RepairKindId = A43RepairKindId ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0710( ) ;
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound10 = (short)(0) ;
         initializeNonKey0710( ) ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0710( ) ;
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0710( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0710( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00072 */
         pr_default.execute(0, new Object[] {Short.valueOf(A27RepairId), Short.valueOf(A43RepairKindId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RepairKind"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z44RepairKindName, T00072_A44RepairKindName[0]) != 0 ) || ( GXutil.strcmp(Z45RepairKindRemarks, T00072_A45RepairKindRemarks[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z44RepairKindName, T00072_A44RepairKindName[0]) != 0 )
            {
               GXutil.writeLogln("repair:[seudo value changed for attri]"+"RepairKindName");
               GXutil.writeLogRaw("Old: ",Z44RepairKindName);
               GXutil.writeLogRaw("Current: ",T00072_A44RepairKindName[0]);
            }
            if ( GXutil.strcmp(Z45RepairKindRemarks, T00072_A45RepairKindRemarks[0]) != 0 )
            {
               GXutil.writeLogln("repair:[seudo value changed for attri]"+"RepairKindRemarks");
               GXutil.writeLogRaw("Old: ",Z45RepairKindRemarks);
               GXutil.writeLogRaw("Current: ",T00072_A45RepairKindRemarks[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"RepairKind"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0710( )
   {
      beforeValidate0710( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0710( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0710( 0) ;
         checkOptimisticConcurrency0710( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0710( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0710( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000733 */
                  pr_default.execute(27, new Object[] {Short.valueOf(A27RepairId), Short.valueOf(A43RepairKindId), A44RepairKindName, A45RepairKindRemarks});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RepairKind");
                  if ( (pr_default.getStatus(27) == 1) )
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
            load0710( ) ;
         }
         endLevel0710( ) ;
      }
      closeExtendedTableCursors0710( ) ;
   }

   public void update0710( )
   {
      beforeValidate0710( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0710( ) ;
      }
      if ( ( nIsMod_10 != 0 ) || ( nIsDirty_10 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0710( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0710( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0710( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000734 */
                     pr_default.execute(28, new Object[] {A44RepairKindName, A45RepairKindRemarks, Short.valueOf(A27RepairId), Short.valueOf(A43RepairKindId)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("RepairKind");
                     if ( (pr_default.getStatus(28) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RepairKind"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0710( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0710( ) ;
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
            endLevel0710( ) ;
         }
      }
      closeExtendedTableCursors0710( ) ;
   }

   public void deferredUpdate0710( )
   {
   }

   public void delete0710( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0710( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0710( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0710( ) ;
         afterConfirm0710( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0710( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000735 */
               pr_default.execute(29, new Object[] {Short.valueOf(A27RepairId), Short.valueOf(A43RepairKindId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("RepairKind");
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
      sMode10 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0710( ) ;
      Gx_mode = sMode10 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0710( )
   {
      standaloneModal0710( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0710( )
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

   public void scanStart0710( )
   {
      /* Scan By routine */
      /* Using cursor T000736 */
      pr_default.execute(30, new Object[] {Short.valueOf(A27RepairId)});
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A43RepairKindId = T000736_A43RepairKindId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0710( )
   {
      /* Scan next routine */
      pr_default.readNext(30);
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A43RepairKindId = T000736_A43RepairKindId[0] ;
      }
   }

   public void scanEnd0710( )
   {
      pr_default.close(30);
   }

   public void afterConfirm0710( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0710( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0710( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0710( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0710( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0710( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0710( )
   {
      edtRepairKindId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairKindId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairKindId_Enabled), 5, 0), !bGXsfl_123_Refreshing);
      cmbRepairKindName.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbRepairKindName.getInternalname(), "Enabled", GXutil.ltrimstr( cmbRepairKindName.getEnabled(), 5, 0), !bGXsfl_123_Refreshing);
      edtRepairKindRemarks_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairKindRemarks_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairKindRemarks_Enabled), 5, 0), !bGXsfl_123_Refreshing);
   }

   public void send_integrity_lvl_hashes0710( )
   {
   }

   public void send_integrity_lvl_hashes078( )
   {
   }

   public void subsflControlProps_12310( )
   {
      edtRepairKindId_Internalname = "REPAIRKINDID_"+sGXsfl_123_idx ;
      cmbRepairKindName.setInternalname( "REPAIRKINDNAME_"+sGXsfl_123_idx );
      edtRepairKindRemarks_Internalname = "REPAIRKINDREMARKS_"+sGXsfl_123_idx ;
   }

   public void subsflControlProps_fel_12310( )
   {
      edtRepairKindId_Internalname = "REPAIRKINDID_"+sGXsfl_123_fel_idx ;
      cmbRepairKindName.setInternalname( "REPAIRKINDNAME_"+sGXsfl_123_fel_idx );
      edtRepairKindRemarks_Internalname = "REPAIRKINDREMARKS_"+sGXsfl_123_fel_idx ;
   }

   public void addRow0710( )
   {
      nGXsfl_123_idx = (int)(nGXsfl_123_idx+1) ;
      sGXsfl_123_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_123_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_12310( ) ;
      sendRow0710( ) ;
   }

   public void sendRow0710( )
   {
      Gridrepair_kindRow = GXWebRow.GetNew(context) ;
      if ( subGridrepair_kind_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridrepair_kind_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridrepair_kind_Class, "") != 0 )
         {
            subGridrepair_kind_Linesclass = subGridrepair_kind_Class+"Odd" ;
         }
      }
      else if ( subGridrepair_kind_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridrepair_kind_Backstyle = (byte)(0) ;
         subGridrepair_kind_Backcolor = subGridrepair_kind_Allbackcolor ;
         if ( GXutil.strcmp(subGridrepair_kind_Class, "") != 0 )
         {
            subGridrepair_kind_Linesclass = subGridrepair_kind_Class+"Uniform" ;
         }
      }
      else if ( subGridrepair_kind_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridrepair_kind_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridrepair_kind_Class, "") != 0 )
         {
            subGridrepair_kind_Linesclass = subGridrepair_kind_Class+"Odd" ;
         }
         subGridrepair_kind_Backcolor = (int)(0x0) ;
      }
      else if ( subGridrepair_kind_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridrepair_kind_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_123_idx) % (2))) == 0 )
         {
            subGridrepair_kind_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridrepair_kind_Class, "") != 0 )
            {
               subGridrepair_kind_Linesclass = subGridrepair_kind_Class+"Even" ;
            }
         }
         else
         {
            subGridrepair_kind_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridrepair_kind_Class, "") != 0 )
            {
               subGridrepair_kind_Linesclass = subGridrepair_kind_Class+"Odd" ;
            }
         }
      }
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /*
         Assignment error:
         ================
         Expression: [ t('iif(',1),t('Gx_mode',23),t(=,10),t('''DSP''',3),t('OR',9),t('Gx_mode',23),t(=,10),t('''UPD''',3),t(',',7),t('""',3),t(',',7),t('"javascript:"',3),t(+,5),t('"gx.popup.openPrompt(''"',3),t(+,5),t('"com.parks.gx00a1"',3),t(+,5),t('"'',["',3),t(+,5),t('"''"',3),t(+,5),t('htmlencode(',1),t('strreplace(',1),t('ltrim(',1),t('ntoc(',1),t(27,2),t(',',7),t(4,3),t(',',7),t(0,3),t(',',7),t('"."',3),t(',',7),t('""',3),t(')',4),t(')',4),t(',',7),t('"''"',3),t(',',7),t('"\''"',3),t(')',4),t(')',4),t(+,5),t('"''"',3),t(+,5),t('","',3),t(+,5),t('"{Ctrl:gx.dom.el(''"',3),t(+,5),t('"REPAIRKINDID_"',3),t(+,5),t(sGXsfl_123_idx,23),t(+,5),t('"''), id:''"',3),t(+,5),t('"REPAIRKINDID_"',3),t(+,5),t(sGXsfl_123_idx,23),t(+,5),t('"''"',3),t(+,5),t('",IOType:''out''}"',3),t(+,5),t('"],"',3),t(+,5),t('"gx.dom.form()."',3),t(+,5),t('"nIsMod_10_"',3),t(+,5),t(sGXsfl_123_idx,23),t(+,5),t('","',3),t(+,5),t('"'''', false"',3),t(+,5),t('","',3),t(+,5),t('"false"',3),t(+,5),t('");"',3),t(')',4) ]
         Target    : [ t(prompt_27,3),t('Link',3) ]
         ForType   : 29
         Type      : []
      */
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_10_" + sGXsfl_123_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 124,'',false,'" + sGXsfl_123_idx + "',123)\"" ;
      ROClassString = "Attribute" ;
      Gridrepair_kindRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRepairKindId_Internalname,GXutil.ltrim( localUtil.ntoc( A43RepairKindId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A43RepairKindId), "ZZZ9")),TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,124);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRepairKindId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtRepairKindId_Enabled),Integer.valueOf(1),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(123),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_10_" + sGXsfl_123_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 125,'',false,'" + sGXsfl_123_idx + "',123)\"" ;
      if ( ( cmbRepairKindName.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "REPAIRKINDNAME_" + sGXsfl_123_idx ;
         cmbRepairKindName.setName( GXCCtl );
         cmbRepairKindName.setWebtags( "" );
         cmbRepairKindName.addItem("E", "Electricity", (short)(0));
         cmbRepairKindName.addItem("M", "Mechanical", (short)(0));
         cmbRepairKindName.addItem("R", "Replacemente", (short)(0));
         if ( cmbRepairKindName.getItemCount() > 0 )
         {
            A44RepairKindName = cmbRepairKindName.getValidValue(A44RepairKindName) ;
         }
      }
      /* ComboBox */
      Gridrepair_kindRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbRepairKindName,cmbRepairKindName.getInternalname(),GXutil.rtrim( A44RepairKindName),Integer.valueOf(1),cmbRepairKindName.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbRepairKindName.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,125);\"","",Boolean.valueOf(true)});
      cmbRepairKindName.setValue( GXutil.rtrim( A44RepairKindName) );
      httpContext.ajax_rsp_assign_prop("", false, cmbRepairKindName.getInternalname(), "Values", cmbRepairKindName.ToJavascriptSource(), !bGXsfl_123_Refreshing);
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_10_" + sGXsfl_123_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 126,'',false,'" + sGXsfl_123_idx + "',123)\"" ;
      ROClassString = "Attribute" ;
      Gridrepair_kindRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRepairKindRemarks_Internalname,GXutil.rtrim( A45RepairKindRemarks),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,126);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRepairKindRemarks_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtRepairKindRemarks_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(120),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(123),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridrepair_kindRow);
      send_integrity_lvl_hashes0710( ) ;
      GXCCtl = "Z43RepairKindId_" + sGXsfl_123_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z43RepairKindId, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "Z44RepairKindName_" + sGXsfl_123_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z44RepairKindName));
      GXCCtl = "Z45RepairKindRemarks_" + sGXsfl_123_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z45RepairKindRemarks));
      GXCCtl = "nRcdDeleted_10_" + sGXsfl_123_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_10, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_10_" + sGXsfl_123_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_10, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_10_" + sGXsfl_123_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_10, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "vMODE_" + sGXsfl_123_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_123_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV9TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV9TrnContext);
      }
      GXCCtl = "vREPAIRID_" + sGXsfl_123_idx ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7RepairId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRKINDID_"+sGXsfl_123_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRepairKindId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRKINDNAME_"+sGXsfl_123_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbRepairKindName.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRKINDREMARKS_"+sGXsfl_123_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRepairKindRemarks_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridrepair_kindContainer.AddRow(Gridrepair_kindRow);
   }

   public void readRow0710( )
   {
      nGXsfl_123_idx = (int)(nGXsfl_123_idx+1) ;
      sGXsfl_123_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_123_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_12310( ) ;
      edtRepairKindId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "REPAIRKINDID_"+sGXsfl_123_idx+"Enabled"), ",", ".")) ;
      cmbRepairKindName.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "REPAIRKINDNAME_"+sGXsfl_123_idx+"Enabled"), ",", ".")) );
      edtRepairKindRemarks_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "REPAIRKINDREMARKS_"+sGXsfl_123_idx+"Enabled"), ",", ".")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRepairKindId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRepairKindId_Internalname), ",", ".") > 9999 ) ) )
      {
         GXCCtl = "REPAIRKINDID_" + sGXsfl_123_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtRepairKindId_Internalname ;
         wbErr = true ;
         A43RepairKindId = (short)(0) ;
      }
      else
      {
         A43RepairKindId = (short)(localUtil.ctol( httpContext.cgiGet( edtRepairKindId_Internalname), ",", ".")) ;
      }
      cmbRepairKindName.setName( cmbRepairKindName.getInternalname() );
      cmbRepairKindName.setValue( httpContext.cgiGet( cmbRepairKindName.getInternalname()) );
      A44RepairKindName = httpContext.cgiGet( cmbRepairKindName.getInternalname()) ;
      A45RepairKindRemarks = httpContext.cgiGet( edtRepairKindRemarks_Internalname) ;
      GXCCtl = "Z43RepairKindId_" + sGXsfl_123_idx ;
      Z43RepairKindId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "Z44RepairKindName_" + sGXsfl_123_idx ;
      Z44RepairKindName = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z45RepairKindRemarks_" + sGXsfl_123_idx ;
      Z45RepairKindRemarks = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_10_" + sGXsfl_123_idx ;
      nRcdDeleted_10 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_10_" + sGXsfl_123_idx ;
      nRcdExists_10 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_10_" + sGXsfl_123_idx ;
      nIsMod_10 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void assign_properties_default( )
   {
      defedtRepairKindId_Enabled = edtRepairKindId_Enabled ;
   }

   public void confirmValues070( )
   {
      nGXsfl_123_idx = 0 ;
      sGXsfl_123_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_123_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_12310( ) ;
      while ( nGXsfl_123_idx < nRC_GXsfl_123 )
      {
         nGXsfl_123_idx = (int)(nGXsfl_123_idx+1) ;
         sGXsfl_123_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_123_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_12310( ) ;
         httpContext.changePostValue( "Z43RepairKindId_"+sGXsfl_123_idx, httpContext.cgiGet( "ZT_"+"Z43RepairKindId_"+sGXsfl_123_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z43RepairKindId_"+sGXsfl_123_idx) ;
         httpContext.changePostValue( "Z44RepairKindName_"+sGXsfl_123_idx, httpContext.cgiGet( "ZT_"+"Z44RepairKindName_"+sGXsfl_123_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z44RepairKindName_"+sGXsfl_123_idx) ;
         httpContext.changePostValue( "Z45RepairKindRemarks_"+sGXsfl_123_idx, httpContext.cgiGet( "ZT_"+"Z45RepairKindRemarks_"+sGXsfl_123_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z45RepairKindRemarks_"+sGXsfl_123_idx) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?202110711551068", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 75940), false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.parks.repair", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7RepairId,4,0))}, new String[] {"Gx_mode","RepairId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Repair");
      forbiddenHiddens.add("RepairId", localUtil.format( DecimalUtil.doubleToDec(A27RepairId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("repair:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z27RepairId", GXutil.ltrim( localUtil.ntoc( Z27RepairId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z28RepairBeginDate", localUtil.dtoc( Z28RepairBeginDate, 0, "/"));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z29RepairDays", GXutil.ltrim( localUtil.ntoc( Z29RepairDays, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z34RepairCost", GXutil.ltrim( localUtil.ntoc( Z34RepairCost, (byte)(8), (byte)(2), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z39RepairDiscountPercentage", GXutil.ltrim( localUtil.ntoc( Z39RepairDiscountPercentage, (byte)(3), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z17GameId", GXutil.ltrim( localUtil.ntoc( Z17GameId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z30TechnicianId", GXutil.ltrim( localUtil.ntoc( Z30TechnicianId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z35TechnicianAlternateId", GXutil.ltrim( localUtil.ntoc( Z35TechnicianAlternateId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_123", GXutil.ltrim( localUtil.ntoc( nGXsfl_123_idx, (byte)(8), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "N17GameId", GXutil.ltrim( localUtil.ntoc( A17GameId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "N30TechnicianId", GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "N35TechnicianAlternateId", GXutil.ltrim( localUtil.ntoc( A35TechnicianAlternateId, (byte)(4), (byte)(0), ",", "")));
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
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vREPAIRID", GXutil.ltrim( localUtil.ntoc( AV7RepairId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vREPAIRID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7RepairId), "ZZZ9")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vINSERT_GAMEID", GXutil.ltrim( localUtil.ntoc( AV11Insert_GameId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TECHNICIANID", GXutil.ltrim( localUtil.ntoc( AV12Insert_TechnicianId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TECHNICIANALTERNATEID", GXutil.ltrim( localUtil.ntoc( AV13Insert_TechnicianAlternateId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV18Pgmname));
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
      return formatLink("com.parks.repair", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7RepairId,4,0))}, new String[] {"Gx_mode","RepairId"})  ;
   }

   public String getPgmname( )
   {
      return "Repair" ;
   }

   public String getPgmdesc( )
   {
      return "Repair" ;
   }

   public void initializeNonKey078( )
   {
      A17GameId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
      A30TechnicianId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
      A35TechnicianAlternateId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A35TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35TechnicianAlternateId), 4, 0));
      A40RepairFinalCost = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A40RepairFinalCost", GXutil.ltrimstr( A40RepairFinalCost, 8, 2));
      A41RepairDateTo = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A41RepairDateTo", localUtil.format(A41RepairDateTo, "99/99/99"));
      A28RepairBeginDate = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A28RepairBeginDate", localUtil.format(A28RepairBeginDate, "99/99/99"));
      A29RepairDays = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A29RepairDays", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29RepairDays), 4, 0));
      A18GameName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A18GameName", A18GameName);
      A31TechnicianName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A31TechnicianName", A31TechnicianName);
      A32TechnicianLastName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A32TechnicianLastName", A32TechnicianLastName);
      A36TechnicianAlternateName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
      A37TechnicianAlternateLastName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
      A38TechnicianAlternatePhone = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
      A34RepairCost = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A34RepairCost", GXutil.ltrimstr( A34RepairCost, 8, 2));
      A39RepairDiscountPercentage = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A39RepairDiscountPercentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), 3, 0));
      A42RepairProblems = (byte)(0) ;
      n42RepairProblems = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      Z28RepairBeginDate = GXutil.nullDate() ;
      Z29RepairDays = (short)(0) ;
      Z34RepairCost = DecimalUtil.ZERO ;
      Z39RepairDiscountPercentage = (short)(0) ;
      Z17GameId = (short)(0) ;
      Z30TechnicianId = (short)(0) ;
      Z35TechnicianAlternateId = (short)(0) ;
   }

   public void initAll078( )
   {
      A27RepairId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
      initializeNonKey078( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0710( )
   {
      A44RepairKindName = "" ;
      A45RepairKindRemarks = "" ;
      Z44RepairKindName = "" ;
      Z45RepairKindRemarks = "" ;
   }

   public void initAll0710( )
   {
      A43RepairKindId = (short)(0) ;
      initializeNonKey0710( ) ;
   }

   public void standaloneModalInsert0710( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202110711551084", true, true);
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
      httpContext.AddJavascriptSource("repair.js", "?202110711551085", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties10( )
   {
      edtRepairKindId_Enabled = defedtRepairKindId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtRepairKindId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRepairKindId_Enabled), 5, 0), !bGXsfl_123_Refreshing);
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
      edtRepairId_Internalname = "REPAIRID" ;
      edtRepairBeginDate_Internalname = "REPAIRBEGINDATE" ;
      edtRepairDays_Internalname = "REPAIRDAYS" ;
      edtRepairDateTo_Internalname = "REPAIRDATETO" ;
      edtGameId_Internalname = "GAMEID" ;
      edtGameName_Internalname = "GAMENAME" ;
      edtTechnicianId_Internalname = "TECHNICIANID" ;
      edtTechnicianName_Internalname = "TECHNICIANNAME" ;
      edtTechnicianLastName_Internalname = "TECHNICIANLASTNAME" ;
      edtTechnicianAlternateId_Internalname = "TECHNICIANALTERNATEID" ;
      edtTechnicianAlternateName_Internalname = "TECHNICIANALTERNATENAME" ;
      edtTechnicianAlternateLastName_Internalname = "TECHNICIANALTERNATELASTNAME" ;
      edtTechnicianAlternatePhone_Internalname = "TECHNICIANALTERNATEPHONE" ;
      edtRepairCost_Internalname = "REPAIRCOST" ;
      edtRepairDiscountPercentage_Internalname = "REPAIRDISCOUNTPERCENTAGE" ;
      edtRepairFinalCost_Internalname = "REPAIRFINALCOST" ;
      edtRepairProblems_Internalname = "REPAIRPROBLEMS" ;
      lblTitlekind_Internalname = "TITLEKIND" ;
      edtRepairKindId_Internalname = "REPAIRKINDID" ;
      cmbRepairKindName.setInternalname( "REPAIRKINDNAME" );
      edtRepairKindRemarks_Internalname = "REPAIRKINDREMARKS" ;
      divKindtable_Internalname = "KINDTABLE" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_17_Internalname = "PROMPT_17" ;
      imgprompt_30_Internalname = "PROMPT_30" ;
      imgprompt_35_Internalname = "PROMPT_35" ;
      subGridrepair_kind_Internalname = "GRIDREPAIR_KIND" ;
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
      Form.setCaption( "Repair" );
      edtRepairKindRemarks_Jsonclick = "" ;
      cmbRepairKindName.setJsonclick( "" );
      edtRepairKindId_Jsonclick = "" ;
      subGridrepair_kind_Class = "Grid" ;
      subGridrepair_kind_Backcolorstyle = (byte)(0) ;
      subGridrepair_kind_Allowcollapsing = (byte)(0) ;
      subGridrepair_kind_Allowselection = (byte)(0) ;
      edtRepairKindRemarks_Enabled = 1 ;
      cmbRepairKindName.setEnabled( 1 );
      edtRepairKindId_Enabled = 1 ;
      subGridrepair_kind_Header = "" ;
      bttBtn_delete_Enabled = 0 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtRepairProblems_Jsonclick = "" ;
      edtRepairProblems_Enabled = 0 ;
      edtRepairFinalCost_Jsonclick = "" ;
      edtRepairFinalCost_Enabled = 0 ;
      edtRepairDiscountPercentage_Jsonclick = "" ;
      edtRepairDiscountPercentage_Enabled = 1 ;
      edtRepairCost_Jsonclick = "" ;
      edtRepairCost_Enabled = 1 ;
      edtTechnicianAlternatePhone_Jsonclick = "" ;
      edtTechnicianAlternatePhone_Enabled = 0 ;
      edtTechnicianAlternateLastName_Jsonclick = "" ;
      edtTechnicianAlternateLastName_Enabled = 0 ;
      edtTechnicianAlternateName_Jsonclick = "" ;
      edtTechnicianAlternateName_Enabled = 0 ;
      imgprompt_35_Visible = 1 ;
      imgprompt_35_Link = "" ;
      edtTechnicianAlternateId_Jsonclick = "" ;
      edtTechnicianAlternateId_Enabled = 1 ;
      edtTechnicianLastName_Jsonclick = "" ;
      edtTechnicianLastName_Enabled = 0 ;
      edtTechnicianName_Jsonclick = "" ;
      edtTechnicianName_Enabled = 0 ;
      imgprompt_30_Visible = 1 ;
      imgprompt_30_Link = "" ;
      edtTechnicianId_Jsonclick = "" ;
      edtTechnicianId_Enabled = 1 ;
      edtGameName_Jsonclick = "" ;
      edtGameName_Enabled = 0 ;
      imgprompt_17_Visible = 1 ;
      imgprompt_17_Link = "" ;
      edtGameId_Jsonclick = "" ;
      edtGameId_Enabled = 1 ;
      edtRepairDateTo_Jsonclick = "" ;
      edtRepairDateTo_Enabled = 0 ;
      edtRepairDays_Jsonclick = "" ;
      edtRepairDays_Enabled = 1 ;
      edtRepairBeginDate_Jsonclick = "" ;
      edtRepairBeginDate_Enabled = 1 ;
      edtRepairId_Jsonclick = "" ;
      edtRepairId_Enabled = 0 ;
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

   public void gxnrgridrepair_kind_newrow( )
   {
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_12310( ) ;
      while ( nGXsfl_123_idx <= nRC_GXsfl_123 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0710( ) ;
         standaloneModal0710( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0710( ) ;
         nGXsfl_123_idx = (int)(nGXsfl_123_idx+1) ;
         sGXsfl_123_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_123_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_12310( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridrepair_kindContainer)) ;
      /* End function gxnrGridrepair_kind_newrow */
   }

   public void init_web_controls( )
   {
      GXCCtl = "REPAIRKINDNAME_" + sGXsfl_123_idx ;
      cmbRepairKindName.setName( GXCCtl );
      cmbRepairKindName.setWebtags( "" );
      cmbRepairKindName.addItem("E", "Electricity", (short)(0));
      cmbRepairKindName.addItem("M", "Mechanical", (short)(0));
      cmbRepairKindName.addItem("R", "Replacemente", (short)(0));
      if ( cmbRepairKindName.getItemCount() > 0 )
      {
         A44RepairKindName = cmbRepairKindName.getValidValue(A44RepairKindName) ;
      }
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

   public void valid_Repairid( )
   {
      n42RepairProblems = false ;
      /* Using cursor T000726 */
      pr_default.execute(20, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(20) != 101) )
      {
         A42RepairProblems = T000726_A42RepairProblems[0] ;
         n42RepairProblems = T000726_n42RepairProblems[0] ;
      }
      else
      {
         A42RepairProblems = (byte)(0) ;
         n42RepairProblems = false ;
      }
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A42RepairProblems", GXutil.ltrim( localUtil.ntoc( A42RepairProblems, (byte)(1), (byte)(0), ".", "")));
   }

   public void valid_Gameid( )
   {
      /* Using cursor T000727 */
      pr_default.execute(21, new Object[] {Short.valueOf(A17GameId)});
      if ( (pr_default.getStatus(21) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Game'.", "ForeignKeyNotFound", 1, "GAMEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtGameId_Internalname ;
      }
      A18GameName = T000727_A18GameName[0] ;
      pr_default.close(21);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A18GameName", GXutil.rtrim( A18GameName));
   }

   public void valid_Technicianid( )
   {
      /* Using cursor T000728 */
      pr_default.execute(22, new Object[] {Short.valueOf(A30TechnicianId)});
      if ( (pr_default.getStatus(22) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Technician'.", "ForeignKeyNotFound", 1, "TECHNICIANID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTechnicianId_Internalname ;
      }
      A31TechnicianName = T000728_A31TechnicianName[0] ;
      A32TechnicianLastName = T000728_A32TechnicianLastName[0] ;
      pr_default.close(22);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A31TechnicianName", GXutil.rtrim( A31TechnicianName));
      httpContext.ajax_rsp_assign_attri("", false, "A32TechnicianLastName", GXutil.rtrim( A32TechnicianLastName));
   }

   public void valid_Technicianalternateid( )
   {
      /* Using cursor T000729 */
      pr_default.execute(23, new Object[] {Short.valueOf(A35TechnicianAlternateId)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Technician Alternate'.", "ForeignKeyNotFound", 1, "TECHNICIANALTERNATEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTechnicianAlternateId_Internalname ;
      }
      A36TechnicianAlternateName = T000729_A36TechnicianAlternateName[0] ;
      A37TechnicianAlternateLastName = T000729_A37TechnicianAlternateLastName[0] ;
      A38TechnicianAlternatePhone = T000729_A38TechnicianAlternatePhone[0] ;
      pr_default.close(23);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A36TechnicianAlternateName", GXutil.rtrim( A36TechnicianAlternateName));
      httpContext.ajax_rsp_assign_attri("", false, "A37TechnicianAlternateLastName", GXutil.rtrim( A37TechnicianAlternateLastName));
      httpContext.ajax_rsp_assign_attri("", false, "A38TechnicianAlternatePhone", GXutil.rtrim( A38TechnicianAlternatePhone));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7RepairId',fld:'vREPAIRID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7RepairId',fld:'vREPAIRID',pic:'ZZZ9',hsh:true},{av:'A27RepairId',fld:'REPAIRID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12072',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_REPAIRID","{handler:'valid_Repairid',iparms:[{av:'A27RepairId',fld:'REPAIRID',pic:'ZZZ9'},{av:'A42RepairProblems',fld:'REPAIRPROBLEMS',pic:'9'}]");
      setEventMetadata("VALID_REPAIRID",",oparms:[{av:'A42RepairProblems',fld:'REPAIRPROBLEMS',pic:'9'}]}");
      setEventMetadata("VALID_REPAIRBEGINDATE","{handler:'valid_Repairbegindate',iparms:[]");
      setEventMetadata("VALID_REPAIRBEGINDATE",",oparms:[]}");
      setEventMetadata("VALID_REPAIRDAYS","{handler:'valid_Repairdays',iparms:[]");
      setEventMetadata("VALID_REPAIRDAYS",",oparms:[]}");
      setEventMetadata("VALID_GAMEID","{handler:'valid_Gameid',iparms:[{av:'A17GameId',fld:'GAMEID',pic:'ZZZ9'},{av:'A18GameName',fld:'GAMENAME',pic:''}]");
      setEventMetadata("VALID_GAMEID",",oparms:[{av:'A18GameName',fld:'GAMENAME',pic:''}]}");
      setEventMetadata("VALID_TECHNICIANID","{handler:'valid_Technicianid',iparms:[{av:'A30TechnicianId',fld:'TECHNICIANID',pic:'ZZZ9'},{av:'A31TechnicianName',fld:'TECHNICIANNAME',pic:''},{av:'A32TechnicianLastName',fld:'TECHNICIANLASTNAME',pic:''}]");
      setEventMetadata("VALID_TECHNICIANID",",oparms:[{av:'A31TechnicianName',fld:'TECHNICIANNAME',pic:''},{av:'A32TechnicianLastName',fld:'TECHNICIANLASTNAME',pic:''}]}");
      setEventMetadata("VALID_TECHNICIANALTERNATEID","{handler:'valid_Technicianalternateid',iparms:[{av:'A35TechnicianAlternateId',fld:'TECHNICIANALTERNATEID',pic:'ZZZ9'},{av:'A36TechnicianAlternateName',fld:'TECHNICIANALTERNATENAME',pic:''},{av:'A37TechnicianAlternateLastName',fld:'TECHNICIANALTERNATELASTNAME',pic:''},{av:'A38TechnicianAlternatePhone',fld:'TECHNICIANALTERNATEPHONE',pic:''}]");
      setEventMetadata("VALID_TECHNICIANALTERNATEID",",oparms:[{av:'A36TechnicianAlternateName',fld:'TECHNICIANALTERNATENAME',pic:''},{av:'A37TechnicianAlternateLastName',fld:'TECHNICIANALTERNATELASTNAME',pic:''},{av:'A38TechnicianAlternatePhone',fld:'TECHNICIANALTERNATEPHONE',pic:''}]}");
      setEventMetadata("VALID_REPAIRCOST","{handler:'valid_Repaircost',iparms:[]");
      setEventMetadata("VALID_REPAIRCOST",",oparms:[]}");
      setEventMetadata("VALID_REPAIRDISCOUNTPERCENTAGE","{handler:'valid_Repairdiscountpercentage',iparms:[]");
      setEventMetadata("VALID_REPAIRDISCOUNTPERCENTAGE",",oparms:[]}");
      setEventMetadata("VALID_REPAIRKINDID","{handler:'valid_Repairkindid',iparms:[]");
      setEventMetadata("VALID_REPAIRKINDID",",oparms:[]}");
      setEventMetadata("VALID_REPAIRKINDNAME","{handler:'valid_Repairkindname',iparms:[]");
      setEventMetadata("VALID_REPAIRKINDNAME",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Repairkindremarks',iparms:[]");
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
      pr_default.close(21);
      pr_default.close(22);
      pr_default.close(23);
      pr_default.close(20);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z28RepairBeginDate = GXutil.nullDate() ;
      Z34RepairCost = DecimalUtil.ZERO ;
      Z44RepairKindName = "" ;
      Z45RepairKindRemarks = "" ;
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
      A28RepairBeginDate = GXutil.nullDate() ;
      A41RepairDateTo = GXutil.nullDate() ;
      sImgUrl = "" ;
      A18GameName = "" ;
      A31TechnicianName = "" ;
      A32TechnicianLastName = "" ;
      A36TechnicianAlternateName = "" ;
      A37TechnicianAlternateLastName = "" ;
      gxphoneLink = "" ;
      A38TechnicianAlternatePhone = "" ;
      A34RepairCost = DecimalUtil.ZERO ;
      A40RepairFinalCost = DecimalUtil.ZERO ;
      lblTitlekind_Jsonclick = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gridrepair_kindContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridrepair_kindColumn = new com.genexus.webpanels.GXWebColumn();
      A44RepairKindName = "" ;
      A45RepairKindRemarks = "" ;
      sMode10 = "" ;
      sStyleString = "" ;
      AV18Pgmname = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode8 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      T00075_A42RepairProblems = new byte[1] ;
      T00075_n42RepairProblems = new boolean[] {false} ;
      AV9TrnContext = new com.parks.SdtTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.parks.SdtTransactionContext_Attribute(remoteHandle, context);
      Z18GameName = "" ;
      Z31TechnicianName = "" ;
      Z32TechnicianLastName = "" ;
      Z36TechnicianAlternateName = "" ;
      Z37TechnicianAlternateLastName = "" ;
      Z38TechnicianAlternatePhone = "" ;
      T000710_A36TechnicianAlternateName = new String[] {""} ;
      T000710_A37TechnicianAlternateLastName = new String[] {""} ;
      T000710_A38TechnicianAlternatePhone = new String[] {""} ;
      T00079_A31TechnicianName = new String[] {""} ;
      T00079_A32TechnicianLastName = new String[] {""} ;
      T00078_A18GameName = new String[] {""} ;
      T000712_A27RepairId = new short[1] ;
      T000712_A28RepairBeginDate = new java.util.Date[] {GXutil.nullDate()} ;
      T000712_A29RepairDays = new short[1] ;
      T000712_A18GameName = new String[] {""} ;
      T000712_A31TechnicianName = new String[] {""} ;
      T000712_A32TechnicianLastName = new String[] {""} ;
      T000712_A36TechnicianAlternateName = new String[] {""} ;
      T000712_A37TechnicianAlternateLastName = new String[] {""} ;
      T000712_A38TechnicianAlternatePhone = new String[] {""} ;
      T000712_A34RepairCost = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000712_A39RepairDiscountPercentage = new short[1] ;
      T000712_A17GameId = new short[1] ;
      T000712_A30TechnicianId = new short[1] ;
      T000712_A35TechnicianAlternateId = new short[1] ;
      T000712_A42RepairProblems = new byte[1] ;
      T000712_n42RepairProblems = new boolean[] {false} ;
      T000714_A42RepairProblems = new byte[1] ;
      T000714_n42RepairProblems = new boolean[] {false} ;
      T000715_A18GameName = new String[] {""} ;
      T000716_A31TechnicianName = new String[] {""} ;
      T000716_A32TechnicianLastName = new String[] {""} ;
      T000717_A36TechnicianAlternateName = new String[] {""} ;
      T000717_A37TechnicianAlternateLastName = new String[] {""} ;
      T000717_A38TechnicianAlternatePhone = new String[] {""} ;
      T000718_A27RepairId = new short[1] ;
      T00077_A27RepairId = new short[1] ;
      T00077_A28RepairBeginDate = new java.util.Date[] {GXutil.nullDate()} ;
      T00077_A29RepairDays = new short[1] ;
      T00077_A34RepairCost = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00077_A39RepairDiscountPercentage = new short[1] ;
      T00077_A17GameId = new short[1] ;
      T00077_A30TechnicianId = new short[1] ;
      T00077_A35TechnicianAlternateId = new short[1] ;
      T000719_A27RepairId = new short[1] ;
      T000720_A27RepairId = new short[1] ;
      T00076_A27RepairId = new short[1] ;
      T00076_A28RepairBeginDate = new java.util.Date[] {GXutil.nullDate()} ;
      T00076_A29RepairDays = new short[1] ;
      T00076_A34RepairCost = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00076_A39RepairDiscountPercentage = new short[1] ;
      T00076_A17GameId = new short[1] ;
      T00076_A30TechnicianId = new short[1] ;
      T00076_A35TechnicianAlternateId = new short[1] ;
      T000722_A27RepairId = new short[1] ;
      T000726_A42RepairProblems = new byte[1] ;
      T000726_n42RepairProblems = new boolean[] {false} ;
      T000727_A18GameName = new String[] {""} ;
      T000728_A31TechnicianName = new String[] {""} ;
      T000728_A32TechnicianLastName = new String[] {""} ;
      T000729_A36TechnicianAlternateName = new String[] {""} ;
      T000729_A37TechnicianAlternateLastName = new String[] {""} ;
      T000729_A38TechnicianAlternatePhone = new String[] {""} ;
      T000730_A27RepairId = new short[1] ;
      T000731_A27RepairId = new short[1] ;
      T000731_A43RepairKindId = new short[1] ;
      T000731_A44RepairKindName = new String[] {""} ;
      T000731_A45RepairKindRemarks = new String[] {""} ;
      T000732_A27RepairId = new short[1] ;
      T000732_A43RepairKindId = new short[1] ;
      T00073_A27RepairId = new short[1] ;
      T00073_A43RepairKindId = new short[1] ;
      T00073_A44RepairKindName = new String[] {""} ;
      T00073_A45RepairKindRemarks = new String[] {""} ;
      T00072_A27RepairId = new short[1] ;
      T00072_A43RepairKindId = new short[1] ;
      T00072_A44RepairKindName = new String[] {""} ;
      T00072_A45RepairKindRemarks = new String[] {""} ;
      T000736_A27RepairId = new short[1] ;
      T000736_A43RepairKindId = new short[1] ;
      Gridrepair_kindRow = new com.genexus.webpanels.GXWebRow();
      subGridrepair_kind_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.repair__default(),
         new Object[] {
             new Object[] {
            T00072_A27RepairId, T00072_A43RepairKindId, T00072_A44RepairKindName, T00072_A45RepairKindRemarks
            }
            , new Object[] {
            T00073_A27RepairId, T00073_A43RepairKindId, T00073_A44RepairKindName, T00073_A45RepairKindRemarks
            }
            , new Object[] {
            T00075_A42RepairProblems, T00075_n42RepairProblems
            }
            , new Object[] {
            T00076_A27RepairId, T00076_A28RepairBeginDate, T00076_A29RepairDays, T00076_A34RepairCost, T00076_A39RepairDiscountPercentage, T00076_A17GameId, T00076_A30TechnicianId, T00076_A35TechnicianAlternateId
            }
            , new Object[] {
            T00077_A27RepairId, T00077_A28RepairBeginDate, T00077_A29RepairDays, T00077_A34RepairCost, T00077_A39RepairDiscountPercentage, T00077_A17GameId, T00077_A30TechnicianId, T00077_A35TechnicianAlternateId
            }
            , new Object[] {
            T00078_A18GameName
            }
            , new Object[] {
            T00079_A31TechnicianName, T00079_A32TechnicianLastName
            }
            , new Object[] {
            T000710_A36TechnicianAlternateName, T000710_A37TechnicianAlternateLastName, T000710_A38TechnicianAlternatePhone
            }
            , new Object[] {
            T000712_A27RepairId, T000712_A28RepairBeginDate, T000712_A29RepairDays, T000712_A18GameName, T000712_A31TechnicianName, T000712_A32TechnicianLastName, T000712_A36TechnicianAlternateName, T000712_A37TechnicianAlternateLastName, T000712_A38TechnicianAlternatePhone, T000712_A34RepairCost,
            T000712_A39RepairDiscountPercentage, T000712_A17GameId, T000712_A30TechnicianId, T000712_A35TechnicianAlternateId, T000712_A42RepairProblems, T000712_n42RepairProblems
            }
            , new Object[] {
            T000714_A42RepairProblems, T000714_n42RepairProblems
            }
            , new Object[] {
            T000715_A18GameName
            }
            , new Object[] {
            T000716_A31TechnicianName, T000716_A32TechnicianLastName
            }
            , new Object[] {
            T000717_A36TechnicianAlternateName, T000717_A37TechnicianAlternateLastName, T000717_A38TechnicianAlternatePhone
            }
            , new Object[] {
            T000718_A27RepairId
            }
            , new Object[] {
            T000719_A27RepairId
            }
            , new Object[] {
            T000720_A27RepairId
            }
            , new Object[] {
            }
            , new Object[] {
            T000722_A27RepairId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000726_A42RepairProblems, T000726_n42RepairProblems
            }
            , new Object[] {
            T000727_A18GameName
            }
            , new Object[] {
            T000728_A31TechnicianName, T000728_A32TechnicianLastName
            }
            , new Object[] {
            T000729_A36TechnicianAlternateName, T000729_A37TechnicianAlternateLastName, T000729_A38TechnicianAlternatePhone
            }
            , new Object[] {
            T000730_A27RepairId
            }
            , new Object[] {
            T000731_A27RepairId, T000731_A43RepairKindId, T000731_A44RepairKindName, T000731_A45RepairKindRemarks
            }
            , new Object[] {
            T000732_A27RepairId, T000732_A43RepairKindId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000736_A27RepairId, T000736_A43RepairKindId
            }
         }
      );
      AV18Pgmname = "Repair" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A42RepairProblems ;
   private byte subGridrepair_kind_Backcolorstyle ;
   private byte subGridrepair_kind_Allowselection ;
   private byte subGridrepair_kind_Allowhovering ;
   private byte subGridrepair_kind_Allowcollapsing ;
   private byte subGridrepair_kind_Collapsed ;
   private byte Z42RepairProblems ;
   private byte Gx_BScreen ;
   private byte subGridrepair_kind_Backstyle ;
   private byte gxajaxcallmode ;
   private short wcpOAV7RepairId ;
   private short Z27RepairId ;
   private short Z29RepairDays ;
   private short Z39RepairDiscountPercentage ;
   private short Z17GameId ;
   private short Z30TechnicianId ;
   private short Z35TechnicianAlternateId ;
   private short N17GameId ;
   private short N30TechnicianId ;
   private short N35TechnicianAlternateId ;
   private short Z43RepairKindId ;
   private short nRcdDeleted_10 ;
   private short nRcdExists_10 ;
   private short nIsMod_10 ;
   private short A27RepairId ;
   private short A17GameId ;
   private short A30TechnicianId ;
   private short A35TechnicianAlternateId ;
   private short AV7RepairId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A29RepairDays ;
   private short A39RepairDiscountPercentage ;
   private short A43RepairKindId ;
   private short nBlankRcdCount10 ;
   private short RcdFound10 ;
   private short nBlankRcdUsr10 ;
   private short AV11Insert_GameId ;
   private short AV12Insert_TechnicianId ;
   private short AV13Insert_TechnicianAlternateId ;
   private short RcdFound8 ;
   private short nIsDirty_8 ;
   private short nIsDirty_10 ;
   private int nRC_GXsfl_123 ;
   private int nGXsfl_123_idx=1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtRepairId_Enabled ;
   private int edtRepairBeginDate_Enabled ;
   private int edtRepairDays_Enabled ;
   private int edtRepairDateTo_Enabled ;
   private int edtGameId_Enabled ;
   private int imgprompt_17_Visible ;
   private int edtGameName_Enabled ;
   private int edtTechnicianId_Enabled ;
   private int imgprompt_30_Visible ;
   private int edtTechnicianName_Enabled ;
   private int edtTechnicianLastName_Enabled ;
   private int edtTechnicianAlternateId_Enabled ;
   private int imgprompt_35_Visible ;
   private int edtTechnicianAlternateName_Enabled ;
   private int edtTechnicianAlternateLastName_Enabled ;
   private int edtTechnicianAlternatePhone_Enabled ;
   private int edtRepairCost_Enabled ;
   private int edtRepairDiscountPercentage_Enabled ;
   private int edtRepairFinalCost_Enabled ;
   private int edtRepairProblems_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int edtRepairKindId_Enabled ;
   private int edtRepairKindRemarks_Enabled ;
   private int subGridrepair_kind_Selectedindex ;
   private int subGridrepair_kind_Selectioncolor ;
   private int subGridrepair_kind_Hoveringcolor ;
   private int fRowAdded ;
   private int AV19GXV1 ;
   private int GX_JID ;
   private int subGridrepair_kind_Backcolor ;
   private int subGridrepair_kind_Allbackcolor ;
   private int defedtRepairKindId_Enabled ;
   private int idxLst ;
   private long GRIDREPAIR_KIND_nFirstRecordOnPage ;
   private java.math.BigDecimal Z34RepairCost ;
   private java.math.BigDecimal A34RepairCost ;
   private java.math.BigDecimal A40RepairFinalCost ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z44RepairKindName ;
   private String Z45RepairKindRemarks ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_123_idx="0001" ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtRepairBeginDate_Internalname ;
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
   private String edtRepairId_Internalname ;
   private String edtRepairId_Jsonclick ;
   private String edtRepairBeginDate_Jsonclick ;
   private String edtRepairDays_Internalname ;
   private String edtRepairDays_Jsonclick ;
   private String edtRepairDateTo_Internalname ;
   private String edtRepairDateTo_Jsonclick ;
   private String edtGameId_Internalname ;
   private String edtGameId_Jsonclick ;
   private String sImgUrl ;
   private String imgprompt_17_Internalname ;
   private String imgprompt_17_Link ;
   private String edtGameName_Internalname ;
   private String A18GameName ;
   private String edtGameName_Jsonclick ;
   private String edtTechnicianId_Internalname ;
   private String edtTechnicianId_Jsonclick ;
   private String imgprompt_30_Internalname ;
   private String imgprompt_30_Link ;
   private String edtTechnicianName_Internalname ;
   private String A31TechnicianName ;
   private String edtTechnicianName_Jsonclick ;
   private String edtTechnicianLastName_Internalname ;
   private String A32TechnicianLastName ;
   private String edtTechnicianLastName_Jsonclick ;
   private String edtTechnicianAlternateId_Internalname ;
   private String edtTechnicianAlternateId_Jsonclick ;
   private String imgprompt_35_Internalname ;
   private String imgprompt_35_Link ;
   private String edtTechnicianAlternateName_Internalname ;
   private String A36TechnicianAlternateName ;
   private String edtTechnicianAlternateName_Jsonclick ;
   private String edtTechnicianAlternateLastName_Internalname ;
   private String A37TechnicianAlternateLastName ;
   private String edtTechnicianAlternateLastName_Jsonclick ;
   private String edtTechnicianAlternatePhone_Internalname ;
   private String gxphoneLink ;
   private String A38TechnicianAlternatePhone ;
   private String edtTechnicianAlternatePhone_Jsonclick ;
   private String edtRepairCost_Internalname ;
   private String edtRepairCost_Jsonclick ;
   private String edtRepairDiscountPercentage_Internalname ;
   private String edtRepairDiscountPercentage_Jsonclick ;
   private String edtRepairFinalCost_Internalname ;
   private String edtRepairFinalCost_Jsonclick ;
   private String edtRepairProblems_Internalname ;
   private String edtRepairProblems_Jsonclick ;
   private String divKindtable_Internalname ;
   private String lblTitlekind_Internalname ;
   private String lblTitlekind_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String subGridrepair_kind_Header ;
   private String A44RepairKindName ;
   private String A45RepairKindRemarks ;
   private String sMode10 ;
   private String edtRepairKindId_Internalname ;
   private String edtRepairKindRemarks_Internalname ;
   private String sStyleString ;
   private String AV18Pgmname ;
   private String hsh ;
   private String sMode8 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String Z18GameName ;
   private String Z31TechnicianName ;
   private String Z32TechnicianLastName ;
   private String Z36TechnicianAlternateName ;
   private String Z37TechnicianAlternateLastName ;
   private String Z38TechnicianAlternatePhone ;
   private String sGXsfl_123_fel_idx="0001" ;
   private String subGridrepair_kind_Class ;
   private String subGridrepair_kind_Linesclass ;
   private String ROClassString ;
   private String edtRepairKindId_Jsonclick ;
   private String edtRepairKindRemarks_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridrepair_kind_Internalname ;
   private java.util.Date Z28RepairBeginDate ;
   private java.util.Date A28RepairBeginDate ;
   private java.util.Date A41RepairDateTo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean bGXsfl_123_Refreshing=false ;
   private boolean n42RepairProblems ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean Gx_longc ;
   private com.genexus.webpanels.GXWebGrid Gridrepair_kindContainer ;
   private com.genexus.webpanels.GXWebRow Gridrepair_kindRow ;
   private com.genexus.webpanels.GXWebColumn Gridrepair_kindColumn ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbRepairKindName ;
   private IDataStoreProvider pr_default ;
   private byte[] T00075_A42RepairProblems ;
   private boolean[] T00075_n42RepairProblems ;
   private String[] T000710_A36TechnicianAlternateName ;
   private String[] T000710_A37TechnicianAlternateLastName ;
   private String[] T000710_A38TechnicianAlternatePhone ;
   private String[] T00079_A31TechnicianName ;
   private String[] T00079_A32TechnicianLastName ;
   private String[] T00078_A18GameName ;
   private short[] T000712_A27RepairId ;
   private java.util.Date[] T000712_A28RepairBeginDate ;
   private short[] T000712_A29RepairDays ;
   private String[] T000712_A18GameName ;
   private String[] T000712_A31TechnicianName ;
   private String[] T000712_A32TechnicianLastName ;
   private String[] T000712_A36TechnicianAlternateName ;
   private String[] T000712_A37TechnicianAlternateLastName ;
   private String[] T000712_A38TechnicianAlternatePhone ;
   private java.math.BigDecimal[] T000712_A34RepairCost ;
   private short[] T000712_A39RepairDiscountPercentage ;
   private short[] T000712_A17GameId ;
   private short[] T000712_A30TechnicianId ;
   private short[] T000712_A35TechnicianAlternateId ;
   private byte[] T000712_A42RepairProblems ;
   private boolean[] T000712_n42RepairProblems ;
   private byte[] T000714_A42RepairProblems ;
   private boolean[] T000714_n42RepairProblems ;
   private String[] T000715_A18GameName ;
   private String[] T000716_A31TechnicianName ;
   private String[] T000716_A32TechnicianLastName ;
   private String[] T000717_A36TechnicianAlternateName ;
   private String[] T000717_A37TechnicianAlternateLastName ;
   private String[] T000717_A38TechnicianAlternatePhone ;
   private short[] T000718_A27RepairId ;
   private short[] T00077_A27RepairId ;
   private java.util.Date[] T00077_A28RepairBeginDate ;
   private short[] T00077_A29RepairDays ;
   private java.math.BigDecimal[] T00077_A34RepairCost ;
   private short[] T00077_A39RepairDiscountPercentage ;
   private short[] T00077_A17GameId ;
   private short[] T00077_A30TechnicianId ;
   private short[] T00077_A35TechnicianAlternateId ;
   private short[] T000719_A27RepairId ;
   private short[] T000720_A27RepairId ;
   private short[] T00076_A27RepairId ;
   private java.util.Date[] T00076_A28RepairBeginDate ;
   private short[] T00076_A29RepairDays ;
   private java.math.BigDecimal[] T00076_A34RepairCost ;
   private short[] T00076_A39RepairDiscountPercentage ;
   private short[] T00076_A17GameId ;
   private short[] T00076_A30TechnicianId ;
   private short[] T00076_A35TechnicianAlternateId ;
   private short[] T000722_A27RepairId ;
   private byte[] T000726_A42RepairProblems ;
   private boolean[] T000726_n42RepairProblems ;
   private String[] T000727_A18GameName ;
   private String[] T000728_A31TechnicianName ;
   private String[] T000728_A32TechnicianLastName ;
   private String[] T000729_A36TechnicianAlternateName ;
   private String[] T000729_A37TechnicianAlternateLastName ;
   private String[] T000729_A38TechnicianAlternatePhone ;
   private short[] T000730_A27RepairId ;
   private short[] T000731_A27RepairId ;
   private short[] T000731_A43RepairKindId ;
   private String[] T000731_A44RepairKindName ;
   private String[] T000731_A45RepairKindRemarks ;
   private short[] T000732_A27RepairId ;
   private short[] T000732_A43RepairKindId ;
   private short[] T00073_A27RepairId ;
   private short[] T00073_A43RepairKindId ;
   private String[] T00073_A44RepairKindName ;
   private String[] T00073_A45RepairKindRemarks ;
   private short[] T00072_A27RepairId ;
   private short[] T00072_A43RepairKindId ;
   private String[] T00072_A44RepairKindName ;
   private String[] T00072_A45RepairKindRemarks ;
   private short[] T000736_A27RepairId ;
   private short[] T000736_A43RepairKindId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.parks.SdtTransactionContext AV9TrnContext ;
   private com.parks.SdtTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class repair__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00072", "SELECT `RepairId`, `RepairKindId`, `RepairKindName`, `RepairKindRemarks` FROM `RepairKind` WHERE `RepairId` = ? AND `RepairKindId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00073", "SELECT `RepairId`, `RepairKindId`, `RepairKindName`, `RepairKindRemarks` FROM `RepairKind` WHERE `RepairId` = ? AND `RepairKindId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00075", "SELECT COALESCE( T1.`RepairProblems`, 0) AS RepairProblems FROM (SELECT COUNT(*) AS RepairProblems, `RepairId` FROM `RepairKind` GROUP BY `RepairId` ) T1 WHERE T1.`RepairId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00076", "SELECT `RepairId`, `RepairBeginDate`, `RepairDays`, `RepairCost`, `RepairDiscountPercentage`, `GameId`, `TechnicianId`, `TechnicianAlternateId` AS TechnicianAlternateId FROM `Repair` WHERE `RepairId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00077", "SELECT `RepairId`, `RepairBeginDate`, `RepairDays`, `RepairCost`, `RepairDiscountPercentage`, `GameId`, `TechnicianId`, `TechnicianAlternateId` AS TechnicianAlternateId FROM `Repair` WHERE `RepairId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00078", "SELECT `GameName` FROM `Game` WHERE `GameId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00079", "SELECT `TechnicianName`, `TechnicianLastName` FROM `Technician` WHERE `TechnicianId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000710", "SELECT `TechnicianName` AS TechnicianAlternateName, `TechnicianLastName` AS TechnicianAlternateLastName, `TechnicianPhone` AS TechnicianAlternatePhone FROM `Technician` WHERE `TechnicianId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000712", "SELECT TM1.`RepairId`, TM1.`RepairBeginDate`, TM1.`RepairDays`, T3.`GameName`, T4.`TechnicianName`, T4.`TechnicianLastName`, T5.`TechnicianName` AS TechnicianAlternateName, T5.`TechnicianLastName` AS TechnicianAlternateLastName, T5.`TechnicianPhone` AS TechnicianAlternatePhone, TM1.`RepairCost`, TM1.`RepairDiscountPercentage`, TM1.`GameId`, TM1.`TechnicianId`, TM1.`TechnicianAlternateId` AS TechnicianAlternateId, COALESCE( T2.`RepairProblems`, 0) AS RepairProblems FROM ((((`Repair` TM1 LEFT JOIN (SELECT COUNT(*) AS RepairProblems, `RepairId` FROM `RepairKind` GROUP BY `RepairId` ) T2 ON T2.`RepairId` = TM1.`RepairId`) INNER JOIN `Game` T3 ON T3.`GameId` = TM1.`GameId`) INNER JOIN `Technician` T4 ON T4.`TechnicianId` = TM1.`TechnicianId`) INNER JOIN `Technician` T5 ON T5.`TechnicianId` = TM1.`TechnicianAlternateId`) WHERE TM1.`RepairId` = ? ORDER BY TM1.`RepairId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000714", "SELECT COALESCE( T1.`RepairProblems`, 0) AS RepairProblems FROM (SELECT COUNT(*) AS RepairProblems, `RepairId` FROM `RepairKind` GROUP BY `RepairId` ) T1 WHERE T1.`RepairId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000715", "SELECT `GameName` FROM `Game` WHERE `GameId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000716", "SELECT `TechnicianName`, `TechnicianLastName` FROM `Technician` WHERE `TechnicianId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000717", "SELECT `TechnicianName` AS TechnicianAlternateName, `TechnicianLastName` AS TechnicianAlternateLastName, `TechnicianPhone` AS TechnicianAlternatePhone FROM `Technician` WHERE `TechnicianId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000718", "SELECT `RepairId` FROM `Repair` WHERE `RepairId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000719", "SELECT `RepairId` FROM `Repair` WHERE ( `RepairId` > ?) ORDER BY `RepairId`  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000720", "SELECT `RepairId` FROM `Repair` WHERE ( `RepairId` < ?) ORDER BY `RepairId` DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000721", "INSERT INTO `Repair`(`RepairBeginDate`, `RepairDays`, `RepairCost`, `RepairDiscountPercentage`, `GameId`, `TechnicianId`, `TechnicianAlternateId`) VALUES(?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new ForEachCursor("T000722", "SELECT LAST_INSERT_ID() ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000723", "UPDATE `Repair` SET `RepairBeginDate`=?, `RepairDays`=?, `RepairCost`=?, `RepairDiscountPercentage`=?, `GameId`=?, `TechnicianId`=?, `TechnicianAlternateId`=?  WHERE `RepairId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000724", "DELETE FROM `Repair`  WHERE `RepairId` = ?", GX_NOMASK)
         ,new ForEachCursor("T000726", "SELECT COALESCE( T1.`RepairProblems`, 0) AS RepairProblems FROM (SELECT COUNT(*) AS RepairProblems, `RepairId` FROM `RepairKind` GROUP BY `RepairId` ) T1 WHERE T1.`RepairId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000727", "SELECT `GameName` FROM `Game` WHERE `GameId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000728", "SELECT `TechnicianName`, `TechnicianLastName` FROM `Technician` WHERE `TechnicianId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000729", "SELECT `TechnicianName` AS TechnicianAlternateName, `TechnicianLastName` AS TechnicianAlternateLastName, `TechnicianPhone` AS TechnicianAlternatePhone FROM `Technician` WHERE `TechnicianId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000730", "SELECT `RepairId` FROM `Repair` ORDER BY `RepairId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000731", "SELECT `RepairId`, `RepairKindId`, `RepairKindName`, `RepairKindRemarks` FROM `RepairKind` WHERE `RepairId` = ? and `RepairKindId` = ? ORDER BY `RepairId`, `RepairKindId` ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000732", "SELECT `RepairId`, `RepairKindId` FROM `RepairKind` WHERE `RepairId` = ? AND `RepairKindId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000733", "INSERT INTO `RepairKind`(`RepairId`, `RepairKindId`, `RepairKindName`, `RepairKindRemarks`) VALUES(?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000734", "UPDATE `RepairKind` SET `RepairKindName`=?, `RepairKindRemarks`=?  WHERE `RepairId` = ? AND `RepairKindId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000735", "DELETE FROM `RepairKind`  WHERE `RepairId` = ? AND `RepairKindId` = ?", GX_NOMASK)
         ,new ForEachCursor("T000736", "SELECT `RepairId`, `RepairKindId` FROM `RepairKind` WHERE `RepairId` = ? ORDER BY `RepairId`, `RepairKindId` ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getString(4, 120);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getString(4, 120);
               return;
            case 2 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 50);
               ((String[]) buf[4])[0] = rslt.getString(5, 50);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 50);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               return;
            case 9 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 20 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 24 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 25 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getString(4, 120);
               return;
            case 26 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 18 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 1);
               stmt.setString(4, (String)parms[3], 120);
               return;
            case 28 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setString(2, (String)parms[1], 120);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 29 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}


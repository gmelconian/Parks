package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class employee_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_14") == 0 )
      {
         A7AmusementParkId = (short)(GXutil.lval( httpContext.GetPar( "AmusementParkId"))) ;
         n7AmusementParkId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_14( A7AmusementParkId) ;
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
            AV7EmployeeId = (short)(GXutil.lval( httpContext.GetPar( "EmployeeId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmployeeId), 4, 0));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPLOYEEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmployeeId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Employee", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEmployeeAddedDate_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("Carmine");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public employee_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public employee_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( employee_impl.class ));
   }

   public employee_impl( int remoteHandle ,
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
      com.parks.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Employee", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Employee.htm");
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
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Employee.htm");
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
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmployeeId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtEmployeeId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtEmployeeId_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmployeeId, (byte)(4), (byte)(0), ",", "")), ((edtEmployeeId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmployeeId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A1EmployeeId), "ZZZ9")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmployeeId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmployeeId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmployeeAddedDate_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtEmployeeAddedDate_Internalname, "Added Date", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtEmployeeAddedDate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtEmployeeAddedDate_Internalname, localUtil.format(A26EmployeeAddedDate, "99/99/99"), localUtil.format( A26EmployeeAddedDate, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmployeeAddedDate_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmployeeAddedDate_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Employee.htm");
      com.parks.GxWebStd.gx_bitmap( httpContext, edtEmployeeAddedDate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtEmployeeAddedDate_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Employee.htm");
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
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmployeeName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtEmployeeName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtEmployeeName_Internalname, GXutil.rtrim( A2EmployeeName), GXutil.rtrim( localUtil.format( A2EmployeeName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmployeeName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmployeeName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmployeeLastName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtEmployeeLastName_Internalname, "Last Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtEmployeeLastName_Internalname, GXutil.rtrim( A3EmployeeLastName), GXutil.rtrim( localUtil.format( A3EmployeeLastName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmployeeLastName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmployeeLastName_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "LastName", "left", true, "", "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmployeeAddress_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtEmployeeAddress_Internalname, "Address", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_html_textarea( httpContext, edtEmployeeAddress_Internalname, A4EmployeeAddress, "http://maps.google.com/maps?q="+PrivateUtilities.encodeURL( A4EmployeeAddress), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", (short)(0), 1, edtEmployeeAddress_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "1024", -1, 0, "_blank", "", (byte)(0), true, "GeneXus\\Address", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmployeePhone_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtEmployeePhone_Internalname, "Phone", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      if ( httpContext.isSmartDevice( ) )
      {
         gxphoneLink = "tel:" + GXutil.rtrim( A5EmployeePhone) ;
      }
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtEmployeePhone_Internalname, GXutil.rtrim( A5EmployeePhone), GXutil.rtrim( localUtil.format( A5EmployeePhone, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", gxphoneLink, "", "", "", edtEmployeePhone_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmployeePhone_Enabled, 0, "tel", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Phone", "left", true, "", "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmployeeEmail_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.parks.GxWebStd.gx_label_element( httpContext, edtEmployeeEmail_Internalname, "Email", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtEmployeeEmail_Internalname, A6EmployeeEmail, GXutil.rtrim( localUtil.format( A6EmployeeEmail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A6EmployeeEmail, "", "", "", edtEmployeeEmail_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmployeeEmail_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Employee.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtAmusementParkId_Internalname, GXutil.ltrim( localUtil.ntoc( A7AmusementParkId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAmusementParkId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAmusementParkId_Enabled, 1, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Employee.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.parks.GxWebStd.gx_bitmap( httpContext, imgprompt_7_Internalname, sImgUrl, imgprompt_7_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_7_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Employee.htm");
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
      com.parks.GxWebStd.gx_single_line_edit( httpContext, edtAmusementParkName_Internalname, GXutil.rtrim( A8AmusementParkName), GXutil.rtrim( localUtil.format( A8AmusementParkName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAmusementParkName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAmusementParkName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Employee.htm");
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
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Employee.htm");
      com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Employee.htm");
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
      e11012 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z1EmployeeId = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmployeeId"), ",", ".")) ;
            Z26EmployeeAddedDate = localUtil.ctod( httpContext.cgiGet( "Z26EmployeeAddedDate"), 0) ;
            Z2EmployeeName = httpContext.cgiGet( "Z2EmployeeName") ;
            Z3EmployeeLastName = httpContext.cgiGet( "Z3EmployeeLastName") ;
            Z4EmployeeAddress = httpContext.cgiGet( "Z4EmployeeAddress") ;
            Z5EmployeePhone = httpContext.cgiGet( "Z5EmployeePhone") ;
            Z6EmployeeEmail = httpContext.cgiGet( "Z6EmployeeEmail") ;
            Z7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( "Z7AmusementParkId"), ",", ".")) ;
            n7AmusementParkId = ((0==A7AmusementParkId) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( "N7AmusementParkId"), ",", ".")) ;
            n7AmusementParkId = ((0==A7AmusementParkId) ? true : false) ;
            AV7EmployeeId = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPLOYEEID"), ",", ".")) ;
            AV11Insert_AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_AMUSEMENTPARKID"), ",", ".")) ;
            Gx_date = localUtil.ctod( httpContext.cgiGet( "vTODAY"), 0) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), ",", ".")) ;
            AV15Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            /* Read variables values. */
            A1EmployeeId = (short)(localUtil.ctol( httpContext.cgiGet( edtEmployeeId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
            if ( localUtil.vcdate( httpContext.cgiGet( edtEmployeeAddedDate_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "EMPLOYEEADDEDDATE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmployeeAddedDate_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A26EmployeeAddedDate = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A26EmployeeAddedDate", localUtil.format(A26EmployeeAddedDate, "99/99/99"));
            }
            else
            {
               A26EmployeeAddedDate = localUtil.ctod( httpContext.cgiGet( edtEmployeeAddedDate_Internalname), 3) ;
               httpContext.ajax_rsp_assign_attri("", false, "A26EmployeeAddedDate", localUtil.format(A26EmployeeAddedDate, "99/99/99"));
            }
            A2EmployeeName = httpContext.cgiGet( edtEmployeeName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2EmployeeName", A2EmployeeName);
            A3EmployeeLastName = httpContext.cgiGet( edtEmployeeLastName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A3EmployeeLastName", A3EmployeeLastName);
            A4EmployeeAddress = httpContext.cgiGet( edtEmployeeAddress_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A4EmployeeAddress", A4EmployeeAddress);
            A5EmployeePhone = httpContext.cgiGet( edtEmployeePhone_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A5EmployeePhone", A5EmployeePhone);
            A6EmployeeEmail = httpContext.cgiGet( edtEmployeeEmail_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6EmployeeEmail", A6EmployeeEmail);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtAmusementParkId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtAmusementParkId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "AMUSEMENTPARKID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAmusementParkId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A7AmusementParkId = (short)(0) ;
               n7AmusementParkId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
            }
            else
            {
               A7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( edtAmusementParkId_Internalname), ",", ".")) ;
               n7AmusementParkId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
            }
            n7AmusementParkId = ((0==A7AmusementParkId) ? true : false) ;
            A8AmusementParkName = httpContext.cgiGet( edtAmusementParkName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Employee");
            A1EmployeeId = (short)(localUtil.ctol( httpContext.cgiGet( edtEmployeeId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
            forbiddenHiddens.add("EmployeeId", localUtil.format( DecimalUtil.doubleToDec(A1EmployeeId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1EmployeeId != Z1EmployeeId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("employee:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1EmployeeId = (short)(GXutil.lval( httpContext.GetPar( "EmployeeId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
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
                  sMode1 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode1 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound1 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_010( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "EMPLOYEEID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEmployeeId_Internalname ;
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
                        e11012 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12012 ();
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
         e12012 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll011( ) ;
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
         disableAttributes011( ) ;
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

   public void confirm_010( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls011( ) ;
         }
         else
         {
            checkExtendedTable011( ) ;
            closeExtendedTableCursors011( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption010( )
   {
   }

   public void e11012( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.parks.isauthorized(remoteHandle, context).executeUdp( AV15Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.parks.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      AV11Insert_AmusementParkId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_AmusementParkId), 4, 0));
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtTransactionContext_Transactionname(), AV15Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV16GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GXV1), 8, 0));
         while ( AV16GXV1 <= AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().size() )
         {
            AV12TrnContextAtt = (com.parks.SdtTransactionContext_Attribute)((com.parks.SdtTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().elementAt(-1+AV16GXV1));
            if ( GXutil.strcmp(AV12TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "AmusementParkId") == 0 )
            {
               AV11Insert_AmusementParkId = (short)(GXutil.lval( AV12TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_AmusementParkId), 4, 0));
            }
            AV16GXV1 = (int)(AV16GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GXV1), 8, 0));
         }
      }
   }

   public void e12012( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.parks.wwemployee", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm011( int GX_JID )
   {
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z26EmployeeAddedDate = T00013_A26EmployeeAddedDate[0] ;
            Z2EmployeeName = T00013_A2EmployeeName[0] ;
            Z3EmployeeLastName = T00013_A3EmployeeLastName[0] ;
            Z4EmployeeAddress = T00013_A4EmployeeAddress[0] ;
            Z5EmployeePhone = T00013_A5EmployeePhone[0] ;
            Z6EmployeeEmail = T00013_A6EmployeeEmail[0] ;
            Z7AmusementParkId = T00013_A7AmusementParkId[0] ;
         }
         else
         {
            Z26EmployeeAddedDate = A26EmployeeAddedDate ;
            Z2EmployeeName = A2EmployeeName ;
            Z3EmployeeLastName = A3EmployeeLastName ;
            Z4EmployeeAddress = A4EmployeeAddress ;
            Z5EmployeePhone = A5EmployeePhone ;
            Z6EmployeeEmail = A6EmployeeEmail ;
            Z7AmusementParkId = A7AmusementParkId ;
         }
      }
      if ( GX_JID == -13 )
      {
         Z1EmployeeId = A1EmployeeId ;
         Z26EmployeeAddedDate = A26EmployeeAddedDate ;
         Z2EmployeeName = A2EmployeeName ;
         Z3EmployeeLastName = A3EmployeeLastName ;
         Z4EmployeeAddress = A4EmployeeAddress ;
         Z5EmployeePhone = A5EmployeePhone ;
         Z6EmployeeEmail = A6EmployeeEmail ;
         Z7AmusementParkId = A7AmusementParkId ;
         Z8AmusementParkName = A8AmusementParkName ;
      }
   }

   public void standaloneNotModal( )
   {
      edtEmployeeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmployeeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmployeeId_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      Gx_date = GXutil.today( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_date", localUtil.format(Gx_date, "99/99/99"));
      imgprompt_7_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.parks.gx0020"+"',["+"{Ctrl:gx.dom.el('"+"AMUSEMENTPARKID"+"'), id:'"+"AMUSEMENTPARKID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      edtEmployeeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmployeeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmployeeId_Enabled), 5, 0), true);
      bttBtn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7EmployeeId) )
      {
         A1EmployeeId = AV7EmployeeId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
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
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_AmusementParkId) )
      {
         A7AmusementParkId = AV11Insert_AmusementParkId ;
         n7AmusementParkId = false ;
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
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A26EmployeeAddedDate)) && ( Gx_BScreen == 0 ) )
      {
         A26EmployeeAddedDate = Gx_date ;
         httpContext.ajax_rsp_assign_attri("", false, "A26EmployeeAddedDate", localUtil.format(A26EmployeeAddedDate, "99/99/99"));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV15Pgmname = "Employee" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
         /* Using cursor T00014 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
         A8AmusementParkName = T00014_A8AmusementParkName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
         pr_default.close(2);
      }
   }

   public void load011( )
   {
      /* Using cursor T00015 */
      pr_default.execute(3, new Object[] {Short.valueOf(A1EmployeeId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A26EmployeeAddedDate = T00015_A26EmployeeAddedDate[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26EmployeeAddedDate", localUtil.format(A26EmployeeAddedDate, "99/99/99"));
         A2EmployeeName = T00015_A2EmployeeName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2EmployeeName", A2EmployeeName);
         A3EmployeeLastName = T00015_A3EmployeeLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3EmployeeLastName", A3EmployeeLastName);
         A4EmployeeAddress = T00015_A4EmployeeAddress[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4EmployeeAddress", A4EmployeeAddress);
         A5EmployeePhone = T00015_A5EmployeePhone[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5EmployeePhone", A5EmployeePhone);
         A6EmployeeEmail = T00015_A6EmployeeEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6EmployeeEmail", A6EmployeeEmail);
         A8AmusementParkName = T00015_A8AmusementParkName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
         A7AmusementParkId = T00015_A7AmusementParkId[0] ;
         n7AmusementParkId = T00015_n7AmusementParkId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
         zm011( -13) ;
      }
      pr_default.close(3);
      onLoadActions011( ) ;
   }

   public void onLoadActions011( )
   {
      AV15Pgmname = "Employee" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
   }

   public void checkExtendedTable011( )
   {
      nIsDirty_1 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV15Pgmname = "Employee" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A26EmployeeAddedDate)) || (( GXutil.resetTime(A26EmployeeAddedDate).after( GXutil.resetTime( localUtil.ymdtod( 1000, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A26EmployeeAddedDate), GXutil.resetTime(localUtil.ymdtod( 1000, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Employee Added Date fuera de rango", "OutOfRange", 1, "EMPLOYEEADDEDDATE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmployeeAddedDate_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A2EmployeeName)==0) || (GXutil.strcmp("", A3EmployeeLastName)==0) )
      {
         httpContext.GX_msglist.addItem("Ingrese el nombre del Empleado", 1, "EMPLOYEENAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmployeeName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A5EmployeePhone)==0) )
      {
         httpContext.GX_msglist.addItem("Telefono sin ingresar", 0, "EMPLOYEEPHONE");
      }
      if ( ! ( GxRegex.IsMatch(A6EmployeeEmail,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Employee Email no coincide con el patrón especificado", "OutOfRange", 1, "EMPLOYEEEMAIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmployeeEmail_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00014 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A7AmusementParkId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Amusement Park'.", "ForeignKeyNotFound", 1, "AMUSEMENTPARKID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtAmusementParkId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A8AmusementParkName = T00014_A8AmusementParkName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
      pr_default.close(2);
   }

   public void closeExtendedTableCursors011( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_14( short A7AmusementParkId )
   {
      /* Using cursor T00016 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A7AmusementParkId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Amusement Park'.", "ForeignKeyNotFound", 1, "AMUSEMENTPARKID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtAmusementParkId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A8AmusementParkName = T00016_A8AmusementParkName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A8AmusementParkName))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey011( )
   {
      /* Using cursor T00017 */
      pr_default.execute(5, new Object[] {Short.valueOf(A1EmployeeId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound1 = (short)(1) ;
      }
      else
      {
         RcdFound1 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00013 */
      pr_default.execute(1, new Object[] {Short.valueOf(A1EmployeeId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm011( 13) ;
         RcdFound1 = (short)(1) ;
         A1EmployeeId = T00013_A1EmployeeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
         A26EmployeeAddedDate = T00013_A26EmployeeAddedDate[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26EmployeeAddedDate", localUtil.format(A26EmployeeAddedDate, "99/99/99"));
         A2EmployeeName = T00013_A2EmployeeName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2EmployeeName", A2EmployeeName);
         A3EmployeeLastName = T00013_A3EmployeeLastName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3EmployeeLastName", A3EmployeeLastName);
         A4EmployeeAddress = T00013_A4EmployeeAddress[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4EmployeeAddress", A4EmployeeAddress);
         A5EmployeePhone = T00013_A5EmployeePhone[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5EmployeePhone", A5EmployeePhone);
         A6EmployeeEmail = T00013_A6EmployeeEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6EmployeeEmail", A6EmployeeEmail);
         A7AmusementParkId = T00013_A7AmusementParkId[0] ;
         n7AmusementParkId = T00013_n7AmusementParkId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
         Z1EmployeeId = A1EmployeeId ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load011( ) ;
         if ( AnyError == 1 )
         {
            RcdFound1 = (short)(0) ;
            initializeNonKey011( ) ;
         }
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound1 = (short)(0) ;
         initializeNonKey011( ) ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey011( ) ;
      if ( RcdFound1 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T00018 */
      pr_default.execute(6, new Object[] {Short.valueOf(A1EmployeeId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00018_A1EmployeeId[0] < A1EmployeeId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00018_A1EmployeeId[0] > A1EmployeeId ) ) )
         {
            A1EmployeeId = T00018_A1EmployeeId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T00019 */
      pr_default.execute(7, new Object[] {Short.valueOf(A1EmployeeId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00019_A1EmployeeId[0] > A1EmployeeId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00019_A1EmployeeId[0] < A1EmployeeId ) ) )
         {
            A1EmployeeId = T00019_A1EmployeeId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey011( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEmployeeAddedDate_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert011( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound1 == 1 )
         {
            if ( A1EmployeeId != Z1EmployeeId )
            {
               A1EmployeeId = Z1EmployeeId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "EMPLOYEEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmployeeId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEmployeeAddedDate_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update011( ) ;
               GX_FocusControl = edtEmployeeAddedDate_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1EmployeeId != Z1EmployeeId )
            {
               /* Insert record */
               GX_FocusControl = edtEmployeeAddedDate_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert011( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "EMPLOYEEID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEmployeeId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtEmployeeAddedDate_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert011( ) ;
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
      if ( A1EmployeeId != Z1EmployeeId )
      {
         A1EmployeeId = Z1EmployeeId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "EMPLOYEEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmployeeId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEmployeeAddedDate_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency011( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00012 */
         pr_default.execute(0, new Object[] {Short.valueOf(A1EmployeeId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Employee"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z26EmployeeAddedDate), GXutil.resetTime(T00012_A26EmployeeAddedDate[0])) ) || ( GXutil.strcmp(Z2EmployeeName, T00012_A2EmployeeName[0]) != 0 ) || ( GXutil.strcmp(Z3EmployeeLastName, T00012_A3EmployeeLastName[0]) != 0 ) || ( GXutil.strcmp(Z4EmployeeAddress, T00012_A4EmployeeAddress[0]) != 0 ) || ( GXutil.strcmp(Z5EmployeePhone, T00012_A5EmployeePhone[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z6EmployeeEmail, T00012_A6EmployeeEmail[0]) != 0 ) || ( Z7AmusementParkId != T00012_A7AmusementParkId[0] ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z26EmployeeAddedDate), GXutil.resetTime(T00012_A26EmployeeAddedDate[0])) ) )
            {
               GXutil.writeLogln("employee:[seudo value changed for attri]"+"EmployeeAddedDate");
               GXutil.writeLogRaw("Old: ",Z26EmployeeAddedDate);
               GXutil.writeLogRaw("Current: ",T00012_A26EmployeeAddedDate[0]);
            }
            if ( GXutil.strcmp(Z2EmployeeName, T00012_A2EmployeeName[0]) != 0 )
            {
               GXutil.writeLogln("employee:[seudo value changed for attri]"+"EmployeeName");
               GXutil.writeLogRaw("Old: ",Z2EmployeeName);
               GXutil.writeLogRaw("Current: ",T00012_A2EmployeeName[0]);
            }
            if ( GXutil.strcmp(Z3EmployeeLastName, T00012_A3EmployeeLastName[0]) != 0 )
            {
               GXutil.writeLogln("employee:[seudo value changed for attri]"+"EmployeeLastName");
               GXutil.writeLogRaw("Old: ",Z3EmployeeLastName);
               GXutil.writeLogRaw("Current: ",T00012_A3EmployeeLastName[0]);
            }
            if ( GXutil.strcmp(Z4EmployeeAddress, T00012_A4EmployeeAddress[0]) != 0 )
            {
               GXutil.writeLogln("employee:[seudo value changed for attri]"+"EmployeeAddress");
               GXutil.writeLogRaw("Old: ",Z4EmployeeAddress);
               GXutil.writeLogRaw("Current: ",T00012_A4EmployeeAddress[0]);
            }
            if ( GXutil.strcmp(Z5EmployeePhone, T00012_A5EmployeePhone[0]) != 0 )
            {
               GXutil.writeLogln("employee:[seudo value changed for attri]"+"EmployeePhone");
               GXutil.writeLogRaw("Old: ",Z5EmployeePhone);
               GXutil.writeLogRaw("Current: ",T00012_A5EmployeePhone[0]);
            }
            if ( GXutil.strcmp(Z6EmployeeEmail, T00012_A6EmployeeEmail[0]) != 0 )
            {
               GXutil.writeLogln("employee:[seudo value changed for attri]"+"EmployeeEmail");
               GXutil.writeLogRaw("Old: ",Z6EmployeeEmail);
               GXutil.writeLogRaw("Current: ",T00012_A6EmployeeEmail[0]);
            }
            if ( Z7AmusementParkId != T00012_A7AmusementParkId[0] )
            {
               GXutil.writeLogln("employee:[seudo value changed for attri]"+"AmusementParkId");
               GXutil.writeLogRaw("Old: ",Z7AmusementParkId);
               GXutil.writeLogRaw("Current: ",T00012_A7AmusementParkId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Employee"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert011( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         zm011( 0) ;
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000110 */
                  pr_default.execute(8, new Object[] {A26EmployeeAddedDate, A2EmployeeName, A3EmployeeLastName, A4EmployeeAddress, A5EmployeePhone, A6EmployeeEmail, Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000111 */
                  pr_default.execute(9);
                  A1EmployeeId = T000111_A1EmployeeId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
                  pr_default.close(9);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Employee");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption010( ) ;
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
            load011( ) ;
         }
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void update011( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000112 */
                  pr_default.execute(10, new Object[] {A26EmployeeAddedDate, A2EmployeeName, A3EmployeeLastName, A4EmployeeAddress, A5EmployeePhone, A6EmployeeEmail, Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId), Short.valueOf(A1EmployeeId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Employee");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Employee"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate011( ) ;
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
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void deferredUpdate011( )
   {
   }

   public void delete( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls011( ) ;
         afterConfirm011( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete011( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000113 */
               pr_default.execute(11, new Object[] {Short.valueOf(A1EmployeeId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Employee");
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
      sMode1 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel011( ) ;
      Gx_mode = sMode1 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls011( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV15Pgmname = "Employee" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
         /* Using cursor T000114 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
         A8AmusementParkName = T000114_A8AmusementParkName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
         pr_default.close(12);
      }
   }

   public void endLevel011( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete011( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "employee");
         if ( AnyError == 0 )
         {
            confirmValues010( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "employee");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart011( )
   {
      /* Scan By routine */
      /* Using cursor T000115 */
      pr_default.execute(13);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1EmployeeId = T000115_A1EmployeeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext011( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1EmployeeId = T000115_A1EmployeeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
      }
   }

   public void scanEnd011( )
   {
      pr_default.close(13);
   }

   public void afterConfirm011( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert011( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate011( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete011( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete011( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate011( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes011( )
   {
      edtEmployeeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmployeeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmployeeId_Enabled), 5, 0), true);
      edtEmployeeAddedDate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmployeeAddedDate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmployeeAddedDate_Enabled), 5, 0), true);
      edtEmployeeName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmployeeName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmployeeName_Enabled), 5, 0), true);
      edtEmployeeLastName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmployeeLastName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmployeeLastName_Enabled), 5, 0), true);
      edtEmployeeAddress_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmployeeAddress_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmployeeAddress_Enabled), 5, 0), true);
      edtEmployeePhone_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmployeePhone_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmployeePhone_Enabled), 5, 0), true);
      edtEmployeeEmail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmployeeEmail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmployeeEmail_Enabled), 5, 0), true);
      edtAmusementParkId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkId_Enabled), 5, 0), true);
      edtAmusementParkName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAmusementParkName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAmusementParkName_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes011( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues010( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2021102014431586", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.parks.employee", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmployeeId,4,0))}, new String[] {"Gx_mode","EmployeeId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Employee");
      forbiddenHiddens.add("EmployeeId", localUtil.format( DecimalUtil.doubleToDec(A1EmployeeId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("employee:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z1EmployeeId", GXutil.ltrim( localUtil.ntoc( Z1EmployeeId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z26EmployeeAddedDate", localUtil.dtoc( Z26EmployeeAddedDate, 0, "/"));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z2EmployeeName", GXutil.rtrim( Z2EmployeeName));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z3EmployeeLastName", GXutil.rtrim( Z3EmployeeLastName));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z4EmployeeAddress", Z4EmployeeAddress);
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z5EmployeePhone", GXutil.rtrim( Z5EmployeePhone));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z6EmployeeEmail", Z6EmployeeEmail);
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Z7AmusementParkId", GXutil.ltrim( localUtil.ntoc( Z7AmusementParkId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "N7AmusementParkId", GXutil.ltrim( localUtil.ntoc( A7AmusementParkId, (byte)(4), (byte)(0), ",", "")));
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
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vEMPLOYEEID", GXutil.ltrim( localUtil.ntoc( AV7EmployeeId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPLOYEEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmployeeId), "ZZZ9")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vINSERT_AMUSEMENTPARKID", GXutil.ltrim( localUtil.ntoc( AV11Insert_AmusementParkId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV15Pgmname));
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
      return formatLink("com.parks.employee", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmployeeId,4,0))}, new String[] {"Gx_mode","EmployeeId"})  ;
   }

   public String getPgmname( )
   {
      return "Employee" ;
   }

   public String getPgmdesc( )
   {
      return "Employee" ;
   }

   public void initializeNonKey011( )
   {
      A7AmusementParkId = (short)(0) ;
      n7AmusementParkId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A7AmusementParkId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7AmusementParkId), 4, 0));
      n7AmusementParkId = ((0==A7AmusementParkId) ? true : false) ;
      A2EmployeeName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2EmployeeName", A2EmployeeName);
      A3EmployeeLastName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A3EmployeeLastName", A3EmployeeLastName);
      A4EmployeeAddress = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A4EmployeeAddress", A4EmployeeAddress);
      A5EmployeePhone = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A5EmployeePhone", A5EmployeePhone);
      A6EmployeeEmail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A6EmployeeEmail", A6EmployeeEmail);
      A8AmusementParkName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", A8AmusementParkName);
      A26EmployeeAddedDate = Gx_date ;
      httpContext.ajax_rsp_assign_attri("", false, "A26EmployeeAddedDate", localUtil.format(A26EmployeeAddedDate, "99/99/99"));
      Z26EmployeeAddedDate = GXutil.nullDate() ;
      Z2EmployeeName = "" ;
      Z3EmployeeLastName = "" ;
      Z4EmployeeAddress = "" ;
      Z5EmployeePhone = "" ;
      Z6EmployeeEmail = "" ;
      Z7AmusementParkId = (short)(0) ;
   }

   public void initAll011( )
   {
      A1EmployeeId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmployeeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmployeeId), 4, 0));
      initializeNonKey011( ) ;
   }

   public void standaloneModalInsert( )
   {
      A26EmployeeAddedDate = i26EmployeeAddedDate ;
      httpContext.ajax_rsp_assign_attri("", false, "A26EmployeeAddedDate", localUtil.format(A26EmployeeAddedDate, "99/99/99"));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2021102014431597", true, true);
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
      httpContext.AddJavascriptSource("employee.js", "?2021102014431597", false, true);
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
      edtEmployeeId_Internalname = "EMPLOYEEID" ;
      edtEmployeeAddedDate_Internalname = "EMPLOYEEADDEDDATE" ;
      edtEmployeeName_Internalname = "EMPLOYEENAME" ;
      edtEmployeeLastName_Internalname = "EMPLOYEELASTNAME" ;
      edtEmployeeAddress_Internalname = "EMPLOYEEADDRESS" ;
      edtEmployeePhone_Internalname = "EMPLOYEEPHONE" ;
      edtEmployeeEmail_Internalname = "EMPLOYEEEMAIL" ;
      edtAmusementParkId_Internalname = "AMUSEMENTPARKID" ;
      edtAmusementParkName_Internalname = "AMUSEMENTPARKNAME" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_7_Internalname = "PROMPT_7" ;
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
      Form.setCaption( "Employee" );
      bttBtn_delete_Enabled = 0 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtAmusementParkName_Jsonclick = "" ;
      edtAmusementParkName_Enabled = 0 ;
      imgprompt_7_Visible = 1 ;
      imgprompt_7_Link = "" ;
      edtAmusementParkId_Jsonclick = "" ;
      edtAmusementParkId_Enabled = 1 ;
      edtEmployeeEmail_Jsonclick = "" ;
      edtEmployeeEmail_Enabled = 1 ;
      edtEmployeePhone_Jsonclick = "" ;
      edtEmployeePhone_Enabled = 1 ;
      edtEmployeeAddress_Enabled = 1 ;
      edtEmployeeLastName_Jsonclick = "" ;
      edtEmployeeLastName_Enabled = 1 ;
      edtEmployeeName_Jsonclick = "" ;
      edtEmployeeName_Enabled = 1 ;
      edtEmployeeAddedDate_Jsonclick = "" ;
      edtEmployeeAddedDate_Enabled = 1 ;
      edtEmployeeId_Jsonclick = "" ;
      edtEmployeeId_Enabled = 0 ;
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
      n7AmusementParkId = false ;
      /* Using cursor T000114 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n7AmusementParkId), Short.valueOf(A7AmusementParkId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A7AmusementParkId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Amusement Park'.", "ForeignKeyNotFound", 1, "AMUSEMENTPARKID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtAmusementParkId_Internalname ;
         }
      }
      A8AmusementParkName = T000114_A8AmusementParkName[0] ;
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A8AmusementParkName", GXutil.rtrim( A8AmusementParkName));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7EmployeeId',fld:'vEMPLOYEEID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7EmployeeId',fld:'vEMPLOYEEID',pic:'ZZZ9',hsh:true},{av:'A1EmployeeId',fld:'EMPLOYEEID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12012',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_EMPLOYEEID","{handler:'valid_Employeeid',iparms:[]");
      setEventMetadata("VALID_EMPLOYEEID",",oparms:[]}");
      setEventMetadata("VALID_EMPLOYEEADDEDDATE","{handler:'valid_Employeeaddeddate',iparms:[]");
      setEventMetadata("VALID_EMPLOYEEADDEDDATE",",oparms:[]}");
      setEventMetadata("VALID_EMPLOYEENAME","{handler:'valid_Employeename',iparms:[]");
      setEventMetadata("VALID_EMPLOYEENAME",",oparms:[]}");
      setEventMetadata("VALID_EMPLOYEELASTNAME","{handler:'valid_Employeelastname',iparms:[]");
      setEventMetadata("VALID_EMPLOYEELASTNAME",",oparms:[]}");
      setEventMetadata("VALID_EMPLOYEEPHONE","{handler:'valid_Employeephone',iparms:[]");
      setEventMetadata("VALID_EMPLOYEEPHONE",",oparms:[]}");
      setEventMetadata("VALID_EMPLOYEEEMAIL","{handler:'valid_Employeeemail',iparms:[]");
      setEventMetadata("VALID_EMPLOYEEEMAIL",",oparms:[]}");
      setEventMetadata("VALID_AMUSEMENTPARKID","{handler:'valid_Amusementparkid',iparms:[{av:'A7AmusementParkId',fld:'AMUSEMENTPARKID',pic:'ZZZ9'},{av:'A8AmusementParkName',fld:'AMUSEMENTPARKNAME',pic:''}]");
      setEventMetadata("VALID_AMUSEMENTPARKID",",oparms:[{av:'A8AmusementParkName',fld:'AMUSEMENTPARKNAME',pic:''}]}");
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z26EmployeeAddedDate = GXutil.nullDate() ;
      Z2EmployeeName = "" ;
      Z3EmployeeLastName = "" ;
      Z4EmployeeAddress = "" ;
      Z5EmployeePhone = "" ;
      Z6EmployeeEmail = "" ;
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
      A26EmployeeAddedDate = GXutil.nullDate() ;
      A2EmployeeName = "" ;
      A3EmployeeLastName = "" ;
      A4EmployeeAddress = "" ;
      gxphoneLink = "" ;
      A5EmployeePhone = "" ;
      A6EmployeeEmail = "" ;
      sImgUrl = "" ;
      A8AmusementParkName = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_date = GXutil.nullDate() ;
      AV15Pgmname = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode1 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9TrnContext = new com.parks.SdtTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV12TrnContextAtt = new com.parks.SdtTransactionContext_Attribute(remoteHandle, context);
      Z8AmusementParkName = "" ;
      T00014_A8AmusementParkName = new String[] {""} ;
      T00015_A1EmployeeId = new short[1] ;
      T00015_A26EmployeeAddedDate = new java.util.Date[] {GXutil.nullDate()} ;
      T00015_A2EmployeeName = new String[] {""} ;
      T00015_A3EmployeeLastName = new String[] {""} ;
      T00015_A4EmployeeAddress = new String[] {""} ;
      T00015_A5EmployeePhone = new String[] {""} ;
      T00015_A6EmployeeEmail = new String[] {""} ;
      T00015_A8AmusementParkName = new String[] {""} ;
      T00015_A7AmusementParkId = new short[1] ;
      T00015_n7AmusementParkId = new boolean[] {false} ;
      T00016_A8AmusementParkName = new String[] {""} ;
      T00017_A1EmployeeId = new short[1] ;
      T00013_A1EmployeeId = new short[1] ;
      T00013_A26EmployeeAddedDate = new java.util.Date[] {GXutil.nullDate()} ;
      T00013_A2EmployeeName = new String[] {""} ;
      T00013_A3EmployeeLastName = new String[] {""} ;
      T00013_A4EmployeeAddress = new String[] {""} ;
      T00013_A5EmployeePhone = new String[] {""} ;
      T00013_A6EmployeeEmail = new String[] {""} ;
      T00013_A7AmusementParkId = new short[1] ;
      T00013_n7AmusementParkId = new boolean[] {false} ;
      T00018_A1EmployeeId = new short[1] ;
      T00019_A1EmployeeId = new short[1] ;
      T00012_A1EmployeeId = new short[1] ;
      T00012_A26EmployeeAddedDate = new java.util.Date[] {GXutil.nullDate()} ;
      T00012_A2EmployeeName = new String[] {""} ;
      T00012_A3EmployeeLastName = new String[] {""} ;
      T00012_A4EmployeeAddress = new String[] {""} ;
      T00012_A5EmployeePhone = new String[] {""} ;
      T00012_A6EmployeeEmail = new String[] {""} ;
      T00012_A7AmusementParkId = new short[1] ;
      T00012_n7AmusementParkId = new boolean[] {false} ;
      T000111_A1EmployeeId = new short[1] ;
      T000114_A8AmusementParkName = new String[] {""} ;
      T000115_A1EmployeeId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i26EmployeeAddedDate = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.employee__default(),
         new Object[] {
             new Object[] {
            T00012_A1EmployeeId, T00012_A26EmployeeAddedDate, T00012_A2EmployeeName, T00012_A3EmployeeLastName, T00012_A4EmployeeAddress, T00012_A5EmployeePhone, T00012_A6EmployeeEmail, T00012_A7AmusementParkId, T00012_n7AmusementParkId
            }
            , new Object[] {
            T00013_A1EmployeeId, T00013_A26EmployeeAddedDate, T00013_A2EmployeeName, T00013_A3EmployeeLastName, T00013_A4EmployeeAddress, T00013_A5EmployeePhone, T00013_A6EmployeeEmail, T00013_A7AmusementParkId, T00013_n7AmusementParkId
            }
            , new Object[] {
            T00014_A8AmusementParkName
            }
            , new Object[] {
            T00015_A1EmployeeId, T00015_A26EmployeeAddedDate, T00015_A2EmployeeName, T00015_A3EmployeeLastName, T00015_A4EmployeeAddress, T00015_A5EmployeePhone, T00015_A6EmployeeEmail, T00015_A8AmusementParkName, T00015_A7AmusementParkId, T00015_n7AmusementParkId
            }
            , new Object[] {
            T00016_A8AmusementParkName
            }
            , new Object[] {
            T00017_A1EmployeeId
            }
            , new Object[] {
            T00018_A1EmployeeId
            }
            , new Object[] {
            T00019_A1EmployeeId
            }
            , new Object[] {
            }
            , new Object[] {
            T000111_A1EmployeeId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000114_A8AmusementParkName
            }
            , new Object[] {
            T000115_A1EmployeeId
            }
         }
      );
      AV15Pgmname = "Employee" ;
      Z26EmployeeAddedDate = GXutil.nullDate() ;
      A26EmployeeAddedDate = GXutil.nullDate() ;
      i26EmployeeAddedDate = GXutil.nullDate() ;
      Gx_date = GXutil.today( ) ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7EmployeeId ;
   private short Z1EmployeeId ;
   private short Z7AmusementParkId ;
   private short N7AmusementParkId ;
   private short A7AmusementParkId ;
   private short AV7EmployeeId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1EmployeeId ;
   private short AV11Insert_AmusementParkId ;
   private short RcdFound1 ;
   private short nIsDirty_1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtEmployeeId_Enabled ;
   private int edtEmployeeAddedDate_Enabled ;
   private int edtEmployeeName_Enabled ;
   private int edtEmployeeLastName_Enabled ;
   private int edtEmployeeAddress_Enabled ;
   private int edtEmployeePhone_Enabled ;
   private int edtEmployeeEmail_Enabled ;
   private int edtAmusementParkId_Enabled ;
   private int imgprompt_7_Visible ;
   private int edtAmusementParkName_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int AV16GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z2EmployeeName ;
   private String Z3EmployeeLastName ;
   private String Z5EmployeePhone ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEmployeeAddedDate_Internalname ;
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
   private String edtEmployeeId_Internalname ;
   private String edtEmployeeId_Jsonclick ;
   private String edtEmployeeAddedDate_Jsonclick ;
   private String edtEmployeeName_Internalname ;
   private String A2EmployeeName ;
   private String edtEmployeeName_Jsonclick ;
   private String edtEmployeeLastName_Internalname ;
   private String A3EmployeeLastName ;
   private String edtEmployeeLastName_Jsonclick ;
   private String edtEmployeeAddress_Internalname ;
   private String edtEmployeePhone_Internalname ;
   private String gxphoneLink ;
   private String A5EmployeePhone ;
   private String edtEmployeePhone_Jsonclick ;
   private String edtEmployeeEmail_Internalname ;
   private String edtEmployeeEmail_Jsonclick ;
   private String edtAmusementParkId_Internalname ;
   private String edtAmusementParkId_Jsonclick ;
   private String sImgUrl ;
   private String imgprompt_7_Internalname ;
   private String imgprompt_7_Link ;
   private String edtAmusementParkName_Internalname ;
   private String A8AmusementParkName ;
   private String edtAmusementParkName_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String AV15Pgmname ;
   private String hsh ;
   private String sMode1 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z8AmusementParkName ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z26EmployeeAddedDate ;
   private java.util.Date A26EmployeeAddedDate ;
   private java.util.Date Gx_date ;
   private java.util.Date i26EmployeeAddedDate ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n7AmusementParkId ;
   private boolean wbErr ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean Gx_longc ;
   private String Z4EmployeeAddress ;
   private String Z6EmployeeEmail ;
   private String A4EmployeeAddress ;
   private String A6EmployeeEmail ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00014_A8AmusementParkName ;
   private short[] T00015_A1EmployeeId ;
   private java.util.Date[] T00015_A26EmployeeAddedDate ;
   private String[] T00015_A2EmployeeName ;
   private String[] T00015_A3EmployeeLastName ;
   private String[] T00015_A4EmployeeAddress ;
   private String[] T00015_A5EmployeePhone ;
   private String[] T00015_A6EmployeeEmail ;
   private String[] T00015_A8AmusementParkName ;
   private short[] T00015_A7AmusementParkId ;
   private boolean[] T00015_n7AmusementParkId ;
   private String[] T00016_A8AmusementParkName ;
   private short[] T00017_A1EmployeeId ;
   private short[] T00013_A1EmployeeId ;
   private java.util.Date[] T00013_A26EmployeeAddedDate ;
   private String[] T00013_A2EmployeeName ;
   private String[] T00013_A3EmployeeLastName ;
   private String[] T00013_A4EmployeeAddress ;
   private String[] T00013_A5EmployeePhone ;
   private String[] T00013_A6EmployeeEmail ;
   private short[] T00013_A7AmusementParkId ;
   private boolean[] T00013_n7AmusementParkId ;
   private short[] T00018_A1EmployeeId ;
   private short[] T00019_A1EmployeeId ;
   private short[] T00012_A1EmployeeId ;
   private java.util.Date[] T00012_A26EmployeeAddedDate ;
   private String[] T00012_A2EmployeeName ;
   private String[] T00012_A3EmployeeLastName ;
   private String[] T00012_A4EmployeeAddress ;
   private String[] T00012_A5EmployeePhone ;
   private String[] T00012_A6EmployeeEmail ;
   private short[] T00012_A7AmusementParkId ;
   private boolean[] T00012_n7AmusementParkId ;
   private short[] T000111_A1EmployeeId ;
   private String[] T000114_A8AmusementParkName ;
   private short[] T000115_A1EmployeeId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.parks.SdtTransactionContext AV9TrnContext ;
   private com.parks.SdtTransactionContext_Attribute AV12TrnContextAtt ;
}

final  class employee__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00012", "SELECT `EmployeeId`, `EmployeeAddedDate`, `EmployeeName`, `EmployeeLastName`, `EmployeeAddress`, `EmployeePhone`, `EmployeeEmail`, `AmusementParkId` FROM `Employee` WHERE `EmployeeId` = ?  FOR UPDATE ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00013", "SELECT `EmployeeId`, `EmployeeAddedDate`, `EmployeeName`, `EmployeeLastName`, `EmployeeAddress`, `EmployeePhone`, `EmployeeEmail`, `AmusementParkId` FROM `Employee` WHERE `EmployeeId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00014", "SELECT `AmusementParkName` FROM `AmusementPark` WHERE `AmusementParkId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00015", "SELECT TM1.`EmployeeId`, TM1.`EmployeeAddedDate`, TM1.`EmployeeName`, TM1.`EmployeeLastName`, TM1.`EmployeeAddress`, TM1.`EmployeePhone`, TM1.`EmployeeEmail`, T2.`AmusementParkName`, TM1.`AmusementParkId` FROM (`Employee` TM1 LEFT JOIN `AmusementPark` T2 ON T2.`AmusementParkId` = TM1.`AmusementParkId`) WHERE TM1.`EmployeeId` = ? ORDER BY TM1.`EmployeeId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00016", "SELECT `AmusementParkName` FROM `AmusementPark` WHERE `AmusementParkId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00017", "SELECT `EmployeeId` FROM `Employee` WHERE `EmployeeId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00018", "SELECT `EmployeeId` FROM `Employee` WHERE ( `EmployeeId` > ?) ORDER BY `EmployeeId`  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00019", "SELECT `EmployeeId` FROM `Employee` WHERE ( `EmployeeId` < ?) ORDER BY `EmployeeId` DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000110", "INSERT INTO `Employee`(`EmployeeAddedDate`, `EmployeeName`, `EmployeeLastName`, `EmployeeAddress`, `EmployeePhone`, `EmployeeEmail`, `AmusementParkId`) VALUES(?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new ForEachCursor("T000111", "SELECT LAST_INSERT_ID() ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000112", "UPDATE `Employee` SET `EmployeeAddedDate`=?, `EmployeeName`=?, `EmployeeLastName`=?, `EmployeeAddress`=?, `EmployeePhone`=?, `EmployeeEmail`=?, `AmusementParkId`=?  WHERE `EmployeeId` = ?", GX_NOMASK)
         ,new UpdateCursor("T000113", "DELETE FROM `Employee`  WHERE `EmployeeId` = ?", GX_NOMASK)
         ,new ForEachCursor("T000114", "SELECT `AmusementParkName` FROM `AmusementPark` WHERE `AmusementParkId` = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000115", "SELECT `EmployeeId` FROM `Employee` ORDER BY `EmployeeId` ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 50);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 50);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 50);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 50);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
               return;
            case 13 :
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setString(2, (String)parms[1], 50);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 1024, false);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(7, ((Number) parms[7]).shortValue());
               }
               return;
            case 10 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setString(2, (String)parms[1], 50);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 1024, false);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(7, ((Number) parms[7]).shortValue());
               }
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
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


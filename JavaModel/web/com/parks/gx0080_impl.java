package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gx0080_impl extends GXDataArea
{
   public gx0080_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gx0080_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gx0080_impl.class ));
   }

   public gx0080_impl( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "pRepairId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "pRepairId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "pRepairId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid1") == 0 )
         {
            nRC_GXsfl_84 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_84"))) ;
            nGXsfl_84_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_84_idx"))) ;
            sGXsfl_84_idx = httpContext.GetPar( "sGXsfl_84_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgrid1_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid1") == 0 )
         {
            subGrid1_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid1_Rows"))) ;
            AV6cRepairId = (short)(GXutil.lval( httpContext.GetPar( "cRepairId"))) ;
            AV7cRepairBeginDate = localUtil.parseDateParm( httpContext.GetPar( "cRepairBeginDate")) ;
            AV8cRepairDays = (short)(GXutil.lval( httpContext.GetPar( "cRepairDays"))) ;
            AV9cGameId = (short)(GXutil.lval( httpContext.GetPar( "cGameId"))) ;
            AV10cTechnicianId = (short)(GXutil.lval( httpContext.GetPar( "cTechnicianId"))) ;
            AV11cRepairCost = CommonUtil.decimalVal( httpContext.GetPar( "cRepairCost"), ".") ;
            AV12cTechnicianAlternateId = (short)(GXutil.lval( httpContext.GetPar( "cTechnicianAlternateId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid1_refresh( subGrid1_Rows, AV6cRepairId, AV7cRepairBeginDate, AV8cRepairDays, AV9cGameId, AV10cTechnicianId, AV11cRepairCost, AV12cTechnicianAlternateId) ;
            com.parks.GxWebStd.gx_hidden_field( httpContext, "ADVANCEDCONTAINER_Class", GXutil.rtrim( divAdvancedcontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "BTNTOGGLE_Class", GXutil.rtrim( bttBtntoggle_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRIDFILTERCONTAINER_Class", GXutil.rtrim( divRepairidfiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRBEGINDATEFILTERCONTAINER_Class", GXutil.rtrim( divRepairbegindatefiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRDAYSFILTERCONTAINER_Class", GXutil.rtrim( divRepairdaysfiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "GAMEIDFILTERCONTAINER_Class", GXutil.rtrim( divGameidfiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANIDFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianidfiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRCOSTFILTERCONTAINER_Class", GXutil.rtrim( divRepaircostfiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANALTERNATEIDFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianalternateidfiltercontainer_Class));
            addString( httpContext.getJSONResponse( )) ;
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
            AV13pRepairId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13pRepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13pRepairId), 4, 0));
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.parks.rwdpromptmasterpage");
         MasterPageObj.setDataArea(this,true);
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

   public byte executeStartEvent( )
   {
      pa152( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start152( ) ;
      }
      return gxajaxcallmode ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?2021102014433188", false, true);
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
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.parks.gx0080", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV13pRepairId,4,0))}, new String[] {"pRepairId"}) +"\">") ;
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
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCREPAIRID", GXutil.ltrim( localUtil.ntoc( AV6cRepairId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCREPAIRBEGINDATE", localUtil.format(AV7cRepairBeginDate, "99/99/99"));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCREPAIRDAYS", GXutil.ltrim( localUtil.ntoc( AV8cRepairDays, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCGAMEID", GXutil.ltrim( localUtil.ntoc( AV9cGameId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCTECHNICIANID", GXutil.ltrim( localUtil.ntoc( AV10cTechnicianId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCREPAIRCOST", GXutil.ltrim( localUtil.ntoc( AV11cRepairCost, (byte)(8), (byte)(2), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCTECHNICIANALTERNATEID", GXutil.ltrim( localUtil.ntoc( AV12cTechnicianAlternateId, (byte)(4), (byte)(0), ",", "")));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_84", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_84, (byte)(8), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vPREPAIRID", GXutil.ltrim( localUtil.ntoc( AV13pRepairId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "ADVANCEDCONTAINER_Class", GXutil.rtrim( divAdvancedcontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "BTNTOGGLE_Class", GXutil.rtrim( bttBtntoggle_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRIDFILTERCONTAINER_Class", GXutil.rtrim( divRepairidfiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRBEGINDATEFILTERCONTAINER_Class", GXutil.rtrim( divRepairbegindatefiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRDAYSFILTERCONTAINER_Class", GXutil.rtrim( divRepairdaysfiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GAMEIDFILTERCONTAINER_Class", GXutil.rtrim( divGameidfiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANIDFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianidfiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRCOSTFILTERCONTAINER_Class", GXutil.rtrim( divRepaircostfiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANALTERNATEIDFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianalternateidfiltercontainer_Class));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", "notset");
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

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.parks.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we152( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt152( ) ;
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
      return formatLink("com.parks.gx0080", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV13pRepairId,4,0))}, new String[] {"pRepairId"})  ;
   }

   public String getPgmname( )
   {
      return "Gx0080" ;
   }

   public String getPgmdesc( )
   {
      return "Selection List Repair" ;
   }

   public void wb150( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         com.parks.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divMain_Internalname, 1, 0, "px", 0, "px", "ContainerFluid PromptContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 PromptAdvancedBarCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divAdvancedcontainer_Internalname, 1, 0, "px", 0, "px", divAdvancedcontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divRepairidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divRepairidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLblrepairidfilter_Internalname, "Repair Id", "", "", lblLblrepairidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e11151_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCrepairid_Internalname, "Repair Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'" + sGXsfl_84_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCrepairid_Internalname, GXutil.ltrim( localUtil.ntoc( AV6cRepairId, (byte)(4), (byte)(0), ",", "")), ((edtavCrepairid_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV6cRepairId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(AV6cRepairId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,16);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCrepairid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCrepairid_Visible, edtavCrepairid_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divRepairbegindatefiltercontainer_Internalname, 1, 0, "px", 0, "px", divRepairbegindatefiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLblrepairbegindatefilter_Internalname, "Repair Begin Date", "", "", lblLblrepairbegindatefilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e12151_client"+"'", "", "WWAdvancedLabel WWDateFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCrepairbegindate_Internalname, "Repair Begin Date", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'" + sGXsfl_84_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavCrepairbegindate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCrepairbegindate_Internalname, localUtil.format(AV7cRepairBeginDate, "99/99/99"), localUtil.format( AV7cRepairBeginDate, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,26);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCrepairbegindate_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCrepairbegindate_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0080.htm");
         httpContext.writeTextNL( "</div>") ;
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divRepairdaysfiltercontainer_Internalname, 1, 0, "px", 0, "px", divRepairdaysfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLblrepairdaysfilter_Internalname, "Repair Days", "", "", lblLblrepairdaysfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e13151_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCrepairdays_Internalname, "Repair Days", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'" + sGXsfl_84_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCrepairdays_Internalname, GXutil.ltrim( localUtil.ntoc( AV8cRepairDays, (byte)(4), (byte)(0), ",", "")), ((edtavCrepairdays_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV8cRepairDays), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(AV8cRepairDays), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,36);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCrepairdays_Jsonclick, 0, "Attribute", "", "", "", "", edtavCrepairdays_Visible, edtavCrepairdays_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divGameidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divGameidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLblgameidfilter_Internalname, "Game Id", "", "", lblLblgameidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e14151_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCgameid_Internalname, "Game Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'" + sGXsfl_84_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCgameid_Internalname, GXutil.ltrim( localUtil.ntoc( AV9cGameId, (byte)(4), (byte)(0), ",", "")), ((edtavCgameid_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV9cGameId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(AV9cGameId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,46);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCgameid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCgameid_Visible, edtavCgameid_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divTechnicianidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divTechnicianidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLbltechnicianidfilter_Internalname, "Technician Id", "", "", lblLbltechnicianidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e15151_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCtechnicianid_Internalname, "Technician Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'" + sGXsfl_84_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCtechnicianid_Internalname, GXutil.ltrim( localUtil.ntoc( AV10cTechnicianId, (byte)(4), (byte)(0), ",", "")), ((edtavCtechnicianid_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV10cTechnicianId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(AV10cTechnicianId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCtechnicianid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCtechnicianid_Visible, edtavCtechnicianid_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divRepaircostfiltercontainer_Internalname, 1, 0, "px", 0, "px", divRepaircostfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLblrepaircostfilter_Internalname, "Repair Cost", "", "", lblLblrepaircostfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e16151_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCrepaircost_Internalname, "Repair Cost", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'" + sGXsfl_84_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCrepaircost_Internalname, GXutil.ltrim( localUtil.ntoc( AV11cRepairCost, (byte)(8), (byte)(2), ",", "")), ((edtavCrepaircost_Enabled!=0) ? GXutil.ltrim( localUtil.format( AV11cRepairCost, "ZZZZ9.99")) : localUtil.format( AV11cRepairCost, "ZZZZ9.99")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCrepaircost_Jsonclick, 0, "Attribute", "", "", "", "", edtavCrepaircost_Visible, edtavCrepaircost_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divTechnicianalternateidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divTechnicianalternateidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLbltechnicianalternateidfilter_Internalname, "Technician Alternate Id", "", "", lblLbltechnicianalternateidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e17151_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCtechnicianalternateid_Internalname, "Technician Alternate Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'" + sGXsfl_84_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCtechnicianalternateid_Internalname, GXutil.ltrim( localUtil.ntoc( AV12cTechnicianAlternateId, (byte)(4), (byte)(0), ",", "")), ((edtavCtechnicianalternateid_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV12cTechnicianAlternateId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(AV12cTechnicianAlternateId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,76);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCtechnicianalternateid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCtechnicianalternateid_Visible, edtavCtechnicianalternateid_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 WWGridCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divGridtable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-sm hidden-md hidden-lg ToggleCell", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
         ClassString = bttBtntoggle_Class ;
         StyleString = "" ;
         com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtntoggle_Internalname, "gx.evt.setGridEvt("+GXutil.str( 84, 2, 0)+","+"null"+");", "|||", bttBtntoggle_Jsonclick, 7, "|||", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e18151_client"+"'", TempTags, "", 2, "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"84\">") ;
            sStyleString = "" ;
            com.parks.GxWebStd.gx_table_start( httpContext, subGrid1_Internalname, subGrid1_Internalname, "", "PromptGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGrid1_Backcolorstyle == 0 )
            {
               subGrid1_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Title" ;
               }
            }
            else
            {
               subGrid1_Titlebackstyle = (byte)(1) ;
               if ( subGrid1_Backcolorstyle == 1 )
               {
                  subGrid1_Titlebackcolor = subGrid1_Allbackcolor ;
                  if ( GXutil.len( subGrid1_Class) > 0 )
                  {
                     subGrid1_Linesclass = subGrid1_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGrid1_Class) > 0 )
                  {
                     subGrid1_Linesclass = subGrid1_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"SelectionAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"DescriptionAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Begin Date") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Days") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Game Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Technician Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Cost") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Alternate Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            Grid1Container.AddObjectProperty("GridName", "Grid1");
         }
         else
         {
            if ( isAjaxCallMode( ) )
            {
               Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
            }
            else
            {
               Grid1Container.Clear();
            }
            Grid1Container.SetWrapped(nGXWrapped);
            Grid1Container.AddObjectProperty("GridName", "Grid1");
            Grid1Container.AddObjectProperty("Header", subGrid1_Header);
            Grid1Container.AddObjectProperty("Class", "PromptGrid");
            Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            Grid1Container.AddObjectProperty("CmpContext", "");
            Grid1Container.AddObjectProperty("InMasterPage", "false");
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", httpContext.convertURL( AV5LinkSelection));
            Grid1Column.AddObjectProperty("Link", GXutil.rtrim( edtavLinkselection_Link));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A27RepairId, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", localUtil.format(A28RepairBeginDate, "99/99/99"));
            Grid1Column.AddObjectProperty("Link", GXutil.rtrim( edtRepairBeginDate_Link));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A29RepairDays, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A17GameId, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A34RepairCost, (byte)(8), (byte)(2), ".", "")));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A35TechnicianAlternateId, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowselection, (byte)(1), (byte)(0), ".", "")));
            Grid1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            Grid1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            Grid1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            Grid1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            Grid1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid1_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 84 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_84 = (int)(nGXsfl_84_idx-1) ;
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Grid1Container.AddObjectProperty("GRID1_nEOF", GRID1_nEOF);
            Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.parks.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.parks.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
            }
         }
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'',0)\"" ;
         ClassString = "BtnCancel" ;
         StyleString = "" ;
         com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 84, 2, 0)+","+"null"+");", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Gx0080.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 84 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid1Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Grid1Container.AddObjectProperty("GRID1_nEOF", GRID1_nEOF);
               Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.parks.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.parks.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start152( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_5-152925", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Selection List Repair", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup150( ) ;
   }

   public void ws152( )
   {
      start152( ) ;
      evt152( ) ;
   }

   public void evt152( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
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
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRID1PAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRID1PAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid1_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid1_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid1_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid1_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 4), "LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) )
                        {
                           nGXsfl_84_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_84_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_84_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_842( ) ;
                           AV5LinkSelection = httpContext.cgiGet( edtavLinkselection_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavLinkselection_Internalname, "Bitmap", ((GXutil.strcmp("", AV5LinkSelection)==0) ? AV17Linkselection_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV5LinkSelection))), !bGXsfl_84_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavLinkselection_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV5LinkSelection), true);
                           A27RepairId = (short)(localUtil.ctol( httpContext.cgiGet( edtRepairId_Internalname), ",", ".")) ;
                           A28RepairBeginDate = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtRepairBeginDate_Internalname), 0)) ;
                           A29RepairDays = (short)(localUtil.ctol( httpContext.cgiGet( edtRepairDays_Internalname), ",", ".")) ;
                           A17GameId = (short)(localUtil.ctol( httpContext.cgiGet( edtGameId_Internalname), ",", ".")) ;
                           A30TechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( edtTechnicianId_Internalname), ",", ".")) ;
                           A34RepairCost = localUtil.ctond( httpContext.cgiGet( edtRepairCost_Internalname)) ;
                           A35TechnicianAlternateId = (short)(localUtil.ctol( httpContext.cgiGet( edtTechnicianAlternateId_Internalname), ",", ".")) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19152 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e20152 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Crepairid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCREPAIRID"), ",", ".") != AV6cRepairId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Crepairbegindate Changed */
                                    if ( !( GXutil.dateCompare(localUtil.ctot( httpContext.cgiGet( "GXH_vCREPAIRBEGINDATE"), 0), AV7cRepairBeginDate) ) )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Crepairdays Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCREPAIRDAYS"), ",", ".") != AV8cRepairDays )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Cgameid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCGAMEID"), ",", ".") != AV9cGameId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ctechnicianid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCTECHNICIANID"), ",", ".") != AV10cTechnicianId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Crepaircost Changed */
                                    if ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( "GXH_vCREPAIRCOST")), AV11cRepairCost) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ctechnicianalternateid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCTECHNICIANALTERNATEID"), ",", ".") != AV12cTechnicianAlternateId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    if ( ! Rfr0gs )
                                    {
                                       /* Execute user event: Enter */
                                       e21152 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we152( )
   {
      if ( ! com.parks.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.parks.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa152( )
   {
      if ( nDonePA == 0 )
      {
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
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid1_newrow( )
   {
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_842( ) ;
      while ( nGXsfl_84_idx <= nRC_GXsfl_84 )
      {
         sendrow_842( ) ;
         nGXsfl_84_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_84_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_84_idx+1) ;
         sGXsfl_84_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_84_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_842( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( int subGrid1_Rows ,
                                  short AV6cRepairId ,
                                  java.util.Date AV7cRepairBeginDate ,
                                  short AV8cRepairDays ,
                                  short AV9cGameId ,
                                  short AV10cTechnicianId ,
                                  java.math.BigDecimal AV11cRepairCost ,
                                  short AV12cTechnicianAlternateId )
   {
      initialize_formulas( ) ;
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID1_nCurrentRecord = 0 ;
      rf152( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid1_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_REPAIRID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A27RepairId), "ZZZ9")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "REPAIRID", GXutil.ltrim( localUtil.ntoc( A27RepairId, (byte)(4), (byte)(0), ".", "")));
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf152( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   public void rf152( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(84) ;
      nGXsfl_84_idx = 1 ;
      sGXsfl_84_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_84_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_842( ) ;
      bGXsfl_84_Refreshing = true ;
      Grid1Container.AddObjectProperty("GridName", "Grid1");
      Grid1Container.AddObjectProperty("CmpContext", "");
      Grid1Container.AddObjectProperty("InMasterPage", "false");
      Grid1Container.AddObjectProperty("Class", "PromptGrid");
      Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.setPageSize( subgrid1_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_842( ) ;
         GXPagingFrom2 = (int)(GRID1_nFirstRecordOnPage) ;
         GXPagingTo2 = (int)(subgrid1_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV7cRepairBeginDate ,
                                              Short.valueOf(AV8cRepairDays) ,
                                              Short.valueOf(AV9cGameId) ,
                                              Short.valueOf(AV10cTechnicianId) ,
                                              AV11cRepairCost ,
                                              Short.valueOf(AV12cTechnicianAlternateId) ,
                                              A28RepairBeginDate ,
                                              Short.valueOf(A29RepairDays) ,
                                              Short.valueOf(A17GameId) ,
                                              Short.valueOf(A30TechnicianId) ,
                                              A34RepairCost ,
                                              Short.valueOf(A35TechnicianAlternateId) ,
                                              Short.valueOf(AV6cRepairId) } ,
                                              new int[]{
                                              TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor H00152 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV6cRepairId), AV7cRepairBeginDate, Short.valueOf(AV8cRepairDays), Short.valueOf(AV9cGameId), Short.valueOf(AV10cTechnicianId), AV11cRepairCost, Short.valueOf(AV12cTechnicianAlternateId), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_84_idx = 1 ;
         sGXsfl_84_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_84_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_842( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( GRID1_nCurrentRecord < subgrid1_fnc_recordsperpage( ) ) ) )
         {
            A35TechnicianAlternateId = H00152_A35TechnicianAlternateId[0] ;
            A34RepairCost = H00152_A34RepairCost[0] ;
            A30TechnicianId = H00152_A30TechnicianId[0] ;
            A17GameId = H00152_A17GameId[0] ;
            A29RepairDays = H00152_A29RepairDays[0] ;
            A28RepairBeginDate = H00152_A28RepairBeginDate[0] ;
            A27RepairId = H00152_A27RepairId[0] ;
            /* Execute user event: Load */
            e20152 ();
            pr_default.readNext(0);
         }
         GRID1_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(84) ;
         wb150( ) ;
      }
      bGXsfl_84_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes152( )
   {
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_REPAIRID"+"_"+sGXsfl_84_idx, getSecureSignedToken( sGXsfl_84_idx, localUtil.format( DecimalUtil.doubleToDec(A27RepairId), "ZZZ9")));
   }

   public int subgrid1_fnc_pagecount( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID1_nRecordCount/ (double) (subgrid1_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID1_nRecordCount/ (double) (subgrid1_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid1_fnc_recordcount( )
   {
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV7cRepairBeginDate ,
                                           Short.valueOf(AV8cRepairDays) ,
                                           Short.valueOf(AV9cGameId) ,
                                           Short.valueOf(AV10cTechnicianId) ,
                                           AV11cRepairCost ,
                                           Short.valueOf(AV12cTechnicianAlternateId) ,
                                           A28RepairBeginDate ,
                                           Short.valueOf(A29RepairDays) ,
                                           Short.valueOf(A17GameId) ,
                                           Short.valueOf(A30TechnicianId) ,
                                           A34RepairCost ,
                                           Short.valueOf(A35TechnicianAlternateId) ,
                                           Short.valueOf(AV6cRepairId) } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor H00153 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV6cRepairId), AV7cRepairBeginDate, Short.valueOf(AV8cRepairDays), Short.valueOf(AV9cGameId), Short.valueOf(AV10cTechnicianId), AV11cRepairCost, Short.valueOf(AV12cTechnicianAlternateId)});
      GRID1_nRecordCount = H00153_AGRID1_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID1_nRecordCount) ;
   }

   public int subgrid1_fnc_recordsperpage( )
   {
      return 10*1 ;
   }

   public int subgrid1_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID1_nFirstRecordOnPage/ (double) (subgrid1_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid1_firstpage( )
   {
      GRID1_nFirstRecordOnPage = 0 ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cRepairId, AV7cRepairBeginDate, AV8cRepairDays, AV9cGameId, AV10cTechnicianId, AV11cRepairCost, AV12cTechnicianAlternateId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_nextpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ( GRID1_nRecordCount >= subgrid1_fnc_recordsperpage( ) ) && ( GRID1_nEOF == 0 ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage+subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cRepairId, AV7cRepairBeginDate, AV8cRepairDays, AV9cGameId, AV10cTechnicianId, AV11cRepairCost, AV12cTechnicianAlternateId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID1_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid1_previouspage( )
   {
      if ( GRID1_nFirstRecordOnPage >= subgrid1_fnc_recordsperpage( ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage-subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cRepairId, AV7cRepairBeginDate, AV8cRepairDays, AV9cGameId, AV10cTechnicianId, AV11cRepairCost, AV12cTechnicianAlternateId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_lastpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( GRID1_nRecordCount > subgrid1_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-subgrid1_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cRepairId, AV7cRepairBeginDate, AV8cRepairDays, AV9cGameId, AV10cTechnicianId, AV11cRepairCost, AV12cTechnicianAlternateId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid1_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID1_nFirstRecordOnPage = (long)(subgrid1_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cRepairId, AV7cRepairBeginDate, AV8cRepairDays, AV9cGameId, AV10cTechnicianId, AV11cRepairCost, AV12cTechnicianAlternateId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup150( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19152 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_84 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_84"), ",", ".")) ;
         GRID1_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID1_nFirstRecordOnPage"), ",", ".") ;
         GRID1_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID1_nEOF"), ",", ".")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCrepairid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCrepairid_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCREPAIRID");
            GX_FocusControl = edtavCrepairid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV6cRepairId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6cRepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6cRepairId), 4, 0));
         }
         else
         {
            AV6cRepairId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCrepairid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6cRepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6cRepairId), 4, 0));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavCrepairbegindate_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vCREPAIRBEGINDATE");
            GX_FocusControl = edtavCrepairbegindate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7cRepairBeginDate = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7cRepairBeginDate", localUtil.format(AV7cRepairBeginDate, "99/99/99"));
         }
         else
         {
            AV7cRepairBeginDate = localUtil.ctod( httpContext.cgiGet( edtavCrepairbegindate_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7cRepairBeginDate", localUtil.format(AV7cRepairBeginDate, "99/99/99"));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCrepairdays_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCrepairdays_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCREPAIRDAYS");
            GX_FocusControl = edtavCrepairdays_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV8cRepairDays = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8cRepairDays", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8cRepairDays), 4, 0));
         }
         else
         {
            AV8cRepairDays = (short)(localUtil.ctol( httpContext.cgiGet( edtavCrepairdays_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8cRepairDays", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8cRepairDays), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCgameid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCgameid_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCGAMEID");
            GX_FocusControl = edtavCgameid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV9cGameId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9cGameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9cGameId), 4, 0));
         }
         else
         {
            AV9cGameId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCgameid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9cGameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9cGameId), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCtechnicianid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCtechnicianid_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCTECHNICIANID");
            GX_FocusControl = edtavCtechnicianid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV10cTechnicianId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10cTechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10cTechnicianId), 4, 0));
         }
         else
         {
            AV10cTechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCtechnicianid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10cTechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10cTechnicianId), 4, 0));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavCrepaircost_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavCrepaircost_Internalname)), DecimalUtil.stringToDec("99999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCREPAIRCOST");
            GX_FocusControl = edtavCrepaircost_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11cRepairCost = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11cRepairCost", GXutil.ltrimstr( AV11cRepairCost, 8, 2));
         }
         else
         {
            AV11cRepairCost = localUtil.ctond( httpContext.cgiGet( edtavCrepaircost_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11cRepairCost", GXutil.ltrimstr( AV11cRepairCost, 8, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCtechnicianalternateid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCtechnicianalternateid_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCTECHNICIANALTERNATEID");
            GX_FocusControl = edtavCtechnicianalternateid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12cTechnicianAlternateId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12cTechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12cTechnicianAlternateId), 4, 0));
         }
         else
         {
            AV12cTechnicianAlternateId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCtechnicianalternateid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12cTechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12cTechnicianAlternateId), 4, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCREPAIRID"), ",", ".") != AV6cRepairId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( !( GXutil.dateCompare(GXutil.resetTime(localUtil.ctod( httpContext.cgiGet( "GXH_vCREPAIRBEGINDATE"), 3)), GXutil.resetTime(AV7cRepairBeginDate)) ) )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCREPAIRDAYS"), ",", ".") != AV8cRepairDays )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCGAMEID"), ",", ".") != AV9cGameId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCTECHNICIANID"), ",", ".") != AV10cTechnicianId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( "GXH_vCREPAIRCOST")), AV11cRepairCost) != 0 )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCTECHNICIANALTERNATEID"), ",", ".") != AV12cTechnicianAlternateId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e19152 ();
      if (returnInSub) return;
   }

   public void e19152( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setCaption( GXutil.format( "Lista de Selección %1", "Repair", "", "", "", "", "", "", "", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      AV14ADVANCED_LABEL_TEMPLATE = "%1 <strong>%2</strong>" ;
   }

   private void e20152( )
   {
      /* Load Routine */
      returnInSub = false ;
      AV5LinkSelection = context.getHttpContext().getImagePath( "3914535b-0c03-44c5-9538-906a99cdd2bc", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavLinkselection_Internalname, AV5LinkSelection);
      AV17Linkselection_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "3914535b-0c03-44c5-9538-906a99cdd2bc", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      sendrow_842( ) ;
      GRID1_nCurrentRecord = (long)(GRID1_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_84_Refreshing )
      {
         httpContext.doAjaxLoad(84, Grid1Row);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e21152 ();
      if (returnInSub) return;
   }

   public void e21152( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV13pRepairId = A27RepairId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13pRepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13pRepairId), 4, 0));
      httpContext.setWebReturnParms(new Object[] {Short.valueOf(AV13pRepairId)});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV13pRepairId"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV13pRepairId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13pRepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13pRepairId), 4, 0));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa152( ) ;
      ws152( ) ;
      we152( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2021102014433248", true, true);
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
      httpContext.AddJavascriptSource("gx0080.js", "?2021102014433248", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_842( )
   {
      edtavLinkselection_Internalname = "vLINKSELECTION_"+sGXsfl_84_idx ;
      edtRepairId_Internalname = "REPAIRID_"+sGXsfl_84_idx ;
      edtRepairBeginDate_Internalname = "REPAIRBEGINDATE_"+sGXsfl_84_idx ;
      edtRepairDays_Internalname = "REPAIRDAYS_"+sGXsfl_84_idx ;
      edtGameId_Internalname = "GAMEID_"+sGXsfl_84_idx ;
      edtTechnicianId_Internalname = "TECHNICIANID_"+sGXsfl_84_idx ;
      edtRepairCost_Internalname = "REPAIRCOST_"+sGXsfl_84_idx ;
      edtTechnicianAlternateId_Internalname = "TECHNICIANALTERNATEID_"+sGXsfl_84_idx ;
   }

   public void subsflControlProps_fel_842( )
   {
      edtavLinkselection_Internalname = "vLINKSELECTION_"+sGXsfl_84_fel_idx ;
      edtRepairId_Internalname = "REPAIRID_"+sGXsfl_84_fel_idx ;
      edtRepairBeginDate_Internalname = "REPAIRBEGINDATE_"+sGXsfl_84_fel_idx ;
      edtRepairDays_Internalname = "REPAIRDAYS_"+sGXsfl_84_fel_idx ;
      edtGameId_Internalname = "GAMEID_"+sGXsfl_84_fel_idx ;
      edtTechnicianId_Internalname = "TECHNICIANID_"+sGXsfl_84_fel_idx ;
      edtRepairCost_Internalname = "REPAIRCOST_"+sGXsfl_84_fel_idx ;
      edtTechnicianAlternateId_Internalname = "TECHNICIANALTERNATEID_"+sGXsfl_84_fel_idx ;
   }

   public void sendrow_842( )
   {
      subsflControlProps_842( ) ;
      wb150( ) ;
      if ( ( 10 * 1 == 0 ) || ( nGXsfl_84_idx <= subgrid1_fnc_recordsperpage( ) * 1 ) )
      {
         Grid1Row = GXWebRow.GetNew(context,Grid1Container) ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            subGrid1_Backcolor = subGrid1_Allbackcolor ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Uniform" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
            subGrid1_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid1_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_84_idx) % (2))) == 0 )
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Even" ;
               }
            }
            else
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Odd" ;
               }
            }
         }
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"PromptGrid"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_84_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         edtavLinkselection_Link = "javascript:gx.popup.gxReturn(["+"'"+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A27RepairId, (byte)(4), (byte)(0), ",", "")))+"'"+"]);" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLinkselection_Internalname, "Link", edtavLinkselection_Link, !bGXsfl_84_Refreshing);
         ClassString = "SelectionAttribute" ;
         StyleString = "" ;
         AV5LinkSelection_IsBlob = (boolean)(((GXutil.strcmp("", AV5LinkSelection)==0)&&(GXutil.strcmp("", AV17Linkselection_GXI)==0))||!(GXutil.strcmp("", AV5LinkSelection)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV5LinkSelection)==0) ? AV17Linkselection_GXI : httpContext.getResourceRelative(AV5LinkSelection)) ;
         Grid1Row.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavLinkselection_Internalname,sImgUrl,edtavLinkselection_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWActionColumn","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV5LinkSelection_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRepairId_Internalname,GXutil.ltrim( localUtil.ntoc( A27RepairId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A27RepairId), "ZZZ9"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRepairId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(84),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "DescriptionAttribute" ;
         edtRepairBeginDate_Link = "javascript:gx.popup.gxReturn(["+"'"+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A27RepairId, (byte)(4), (byte)(0), ",", "")))+"'"+"]);" ;
         httpContext.ajax_rsp_assign_prop("", false, edtRepairBeginDate_Internalname, "Link", edtRepairBeginDate_Link, !bGXsfl_84_Refreshing);
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRepairBeginDate_Internalname,localUtil.format(A28RepairBeginDate, "99/99/99"),localUtil.format( A28RepairBeginDate, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'",edtRepairBeginDate_Link,"","","",edtRepairBeginDate_Jsonclick,Integer.valueOf(0),"DescriptionAttribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(84),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRepairDays_Internalname,GXutil.ltrim( localUtil.ntoc( A29RepairDays, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A29RepairDays), "ZZZ9"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRepairDays_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(84),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtGameId_Internalname,GXutil.ltrim( localUtil.ntoc( A17GameId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtGameId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(84),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTechnicianId_Internalname,GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A30TechnicianId), "ZZZ9"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTechnicianId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(84),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRepairCost_Internalname,GXutil.ltrim( localUtil.ntoc( A34RepairCost, (byte)(8), (byte)(2), ",", "")),localUtil.format( A34RepairCost, "ZZZZ9.99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRepairCost_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(84),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Cost","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTechnicianAlternateId_Internalname,GXutil.ltrim( localUtil.ntoc( A35TechnicianAlternateId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A35TechnicianAlternateId), "ZZZ9"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTechnicianAlternateId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(84),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes152( ) ;
         Grid1Container.AddRow(Grid1Row);
         nGXsfl_84_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_84_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_84_idx+1) ;
         sGXsfl_84_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_84_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_842( ) ;
      }
      /* End function sendrow_842 */
   }

   public void init_default_properties( )
   {
      lblLblrepairidfilter_Internalname = "LBLREPAIRIDFILTER" ;
      edtavCrepairid_Internalname = "vCREPAIRID" ;
      divRepairidfiltercontainer_Internalname = "REPAIRIDFILTERCONTAINER" ;
      lblLblrepairbegindatefilter_Internalname = "LBLREPAIRBEGINDATEFILTER" ;
      edtavCrepairbegindate_Internalname = "vCREPAIRBEGINDATE" ;
      divRepairbegindatefiltercontainer_Internalname = "REPAIRBEGINDATEFILTERCONTAINER" ;
      lblLblrepairdaysfilter_Internalname = "LBLREPAIRDAYSFILTER" ;
      edtavCrepairdays_Internalname = "vCREPAIRDAYS" ;
      divRepairdaysfiltercontainer_Internalname = "REPAIRDAYSFILTERCONTAINER" ;
      lblLblgameidfilter_Internalname = "LBLGAMEIDFILTER" ;
      edtavCgameid_Internalname = "vCGAMEID" ;
      divGameidfiltercontainer_Internalname = "GAMEIDFILTERCONTAINER" ;
      lblLbltechnicianidfilter_Internalname = "LBLTECHNICIANIDFILTER" ;
      edtavCtechnicianid_Internalname = "vCTECHNICIANID" ;
      divTechnicianidfiltercontainer_Internalname = "TECHNICIANIDFILTERCONTAINER" ;
      lblLblrepaircostfilter_Internalname = "LBLREPAIRCOSTFILTER" ;
      edtavCrepaircost_Internalname = "vCREPAIRCOST" ;
      divRepaircostfiltercontainer_Internalname = "REPAIRCOSTFILTERCONTAINER" ;
      lblLbltechnicianalternateidfilter_Internalname = "LBLTECHNICIANALTERNATEIDFILTER" ;
      edtavCtechnicianalternateid_Internalname = "vCTECHNICIANALTERNATEID" ;
      divTechnicianalternateidfiltercontainer_Internalname = "TECHNICIANALTERNATEIDFILTERCONTAINER" ;
      divAdvancedcontainer_Internalname = "ADVANCEDCONTAINER" ;
      bttBtntoggle_Internalname = "BTNTOGGLE" ;
      edtavLinkselection_Internalname = "vLINKSELECTION" ;
      edtRepairId_Internalname = "REPAIRID" ;
      edtRepairBeginDate_Internalname = "REPAIRBEGINDATE" ;
      edtRepairDays_Internalname = "REPAIRDAYS" ;
      edtGameId_Internalname = "GAMEID" ;
      edtTechnicianId_Internalname = "TECHNICIANID" ;
      edtRepairCost_Internalname = "REPAIRCOST" ;
      edtTechnicianAlternateId_Internalname = "TECHNICIANALTERNATEID" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      divGridtable_Internalname = "GRIDTABLE" ;
      divMain_Internalname = "MAIN" ;
      Form.setInternalname( "FORM" );
      subGrid1_Internalname = "GRID1" ;
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
      edtTechnicianAlternateId_Jsonclick = "" ;
      edtRepairCost_Jsonclick = "" ;
      edtTechnicianId_Jsonclick = "" ;
      edtGameId_Jsonclick = "" ;
      edtRepairDays_Jsonclick = "" ;
      edtRepairBeginDate_Jsonclick = "" ;
      edtRepairId_Jsonclick = "" ;
      subGrid1_Allowcollapsing = (byte)(0) ;
      subGrid1_Allowselection = (byte)(0) ;
      edtRepairBeginDate_Link = "" ;
      edtavLinkselection_Link = "" ;
      subGrid1_Header = "" ;
      subGrid1_Class = "PromptGrid" ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      edtavCtechnicianalternateid_Jsonclick = "" ;
      edtavCtechnicianalternateid_Enabled = 1 ;
      edtavCtechnicianalternateid_Visible = 1 ;
      edtavCrepaircost_Jsonclick = "" ;
      edtavCrepaircost_Enabled = 1 ;
      edtavCrepaircost_Visible = 1 ;
      edtavCtechnicianid_Jsonclick = "" ;
      edtavCtechnicianid_Enabled = 1 ;
      edtavCtechnicianid_Visible = 1 ;
      edtavCgameid_Jsonclick = "" ;
      edtavCgameid_Enabled = 1 ;
      edtavCgameid_Visible = 1 ;
      edtavCrepairdays_Jsonclick = "" ;
      edtavCrepairdays_Enabled = 1 ;
      edtavCrepairdays_Visible = 1 ;
      edtavCrepairbegindate_Jsonclick = "" ;
      edtavCrepairbegindate_Enabled = 1 ;
      edtavCrepairid_Jsonclick = "" ;
      edtavCrepairid_Enabled = 1 ;
      edtavCrepairid_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Selection List Repair" );
      divTechnicianalternateidfiltercontainer_Class = "AdvancedContainerItem" ;
      divRepaircostfiltercontainer_Class = "AdvancedContainerItem" ;
      divTechnicianidfiltercontainer_Class = "AdvancedContainerItem" ;
      divGameidfiltercontainer_Class = "AdvancedContainerItem" ;
      divRepairdaysfiltercontainer_Class = "AdvancedContainerItem" ;
      divRepairbegindatefiltercontainer_Class = "AdvancedContainerItem" ;
      divRepairidfiltercontainer_Class = "AdvancedContainerItem" ;
      bttBtntoggle_Class = "BtnToggle" ;
      divAdvancedcontainer_Class = "AdvancedContainerVisible" ;
      subGrid1_Rows = 10 ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cRepairId',fld:'vCREPAIRID',pic:'ZZZ9'},{av:'AV7cRepairBeginDate',fld:'vCREPAIRBEGINDATE',pic:''},{av:'AV8cRepairDays',fld:'vCREPAIRDAYS',pic:'ZZZ9'},{av:'AV9cGameId',fld:'vCGAMEID',pic:'ZZZ9'},{av:'AV10cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV11cRepairCost',fld:'vCREPAIRCOST',pic:'ZZZZ9.99'},{av:'AV12cTechnicianAlternateId',fld:'vCTECHNICIANALTERNATEID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'TOGGLE'","{handler:'e18151',iparms:[{av:'divAdvancedcontainer_Class',ctrl:'ADVANCEDCONTAINER',prop:'Class'},{ctrl:'BTNTOGGLE',prop:'Class'}]");
      setEventMetadata("'TOGGLE'",",oparms:[{av:'divAdvancedcontainer_Class',ctrl:'ADVANCEDCONTAINER',prop:'Class'},{ctrl:'BTNTOGGLE',prop:'Class'}]}");
      setEventMetadata("LBLREPAIRIDFILTER.CLICK","{handler:'e11151',iparms:[{av:'divRepairidfiltercontainer_Class',ctrl:'REPAIRIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLREPAIRIDFILTER.CLICK",",oparms:[{av:'divRepairidfiltercontainer_Class',ctrl:'REPAIRIDFILTERCONTAINER',prop:'Class'},{av:'edtavCrepairid_Visible',ctrl:'vCREPAIRID',prop:'Visible'}]}");
      setEventMetadata("LBLREPAIRBEGINDATEFILTER.CLICK","{handler:'e12151',iparms:[{av:'divRepairbegindatefiltercontainer_Class',ctrl:'REPAIRBEGINDATEFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLREPAIRBEGINDATEFILTER.CLICK",",oparms:[{av:'divRepairbegindatefiltercontainer_Class',ctrl:'REPAIRBEGINDATEFILTERCONTAINER',prop:'Class'}]}");
      setEventMetadata("LBLREPAIRDAYSFILTER.CLICK","{handler:'e13151',iparms:[{av:'divRepairdaysfiltercontainer_Class',ctrl:'REPAIRDAYSFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLREPAIRDAYSFILTER.CLICK",",oparms:[{av:'divRepairdaysfiltercontainer_Class',ctrl:'REPAIRDAYSFILTERCONTAINER',prop:'Class'},{av:'edtavCrepairdays_Visible',ctrl:'vCREPAIRDAYS',prop:'Visible'}]}");
      setEventMetadata("LBLGAMEIDFILTER.CLICK","{handler:'e14151',iparms:[{av:'divGameidfiltercontainer_Class',ctrl:'GAMEIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLGAMEIDFILTER.CLICK",",oparms:[{av:'divGameidfiltercontainer_Class',ctrl:'GAMEIDFILTERCONTAINER',prop:'Class'},{av:'edtavCgameid_Visible',ctrl:'vCGAMEID',prop:'Visible'}]}");
      setEventMetadata("LBLTECHNICIANIDFILTER.CLICK","{handler:'e15151',iparms:[{av:'divTechnicianidfiltercontainer_Class',ctrl:'TECHNICIANIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLTECHNICIANIDFILTER.CLICK",",oparms:[{av:'divTechnicianidfiltercontainer_Class',ctrl:'TECHNICIANIDFILTERCONTAINER',prop:'Class'},{av:'edtavCtechnicianid_Visible',ctrl:'vCTECHNICIANID',prop:'Visible'}]}");
      setEventMetadata("LBLREPAIRCOSTFILTER.CLICK","{handler:'e16151',iparms:[{av:'divRepaircostfiltercontainer_Class',ctrl:'REPAIRCOSTFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLREPAIRCOSTFILTER.CLICK",",oparms:[{av:'divRepaircostfiltercontainer_Class',ctrl:'REPAIRCOSTFILTERCONTAINER',prop:'Class'},{av:'edtavCrepaircost_Visible',ctrl:'vCREPAIRCOST',prop:'Visible'}]}");
      setEventMetadata("LBLTECHNICIANALTERNATEIDFILTER.CLICK","{handler:'e17151',iparms:[{av:'divTechnicianalternateidfiltercontainer_Class',ctrl:'TECHNICIANALTERNATEIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLTECHNICIANALTERNATEIDFILTER.CLICK",",oparms:[{av:'divTechnicianalternateidfiltercontainer_Class',ctrl:'TECHNICIANALTERNATEIDFILTERCONTAINER',prop:'Class'},{av:'edtavCtechnicianalternateid_Visible',ctrl:'vCTECHNICIANALTERNATEID',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e21152',iparms:[{av:'A27RepairId',fld:'REPAIRID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV13pRepairId',fld:'vPREPAIRID',pic:'ZZZ9'}]}");
      setEventMetadata("GRID1_FIRSTPAGE","{handler:'subgrid1_firstpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cRepairId',fld:'vCREPAIRID',pic:'ZZZ9'},{av:'AV7cRepairBeginDate',fld:'vCREPAIRBEGINDATE',pic:''},{av:'AV8cRepairDays',fld:'vCREPAIRDAYS',pic:'ZZZ9'},{av:'AV9cGameId',fld:'vCGAMEID',pic:'ZZZ9'},{av:'AV10cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV11cRepairCost',fld:'vCREPAIRCOST',pic:'ZZZZ9.99'},{av:'AV12cTechnicianAlternateId',fld:'vCTECHNICIANALTERNATEID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID1_PREVPAGE","{handler:'subgrid1_previouspage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cRepairId',fld:'vCREPAIRID',pic:'ZZZ9'},{av:'AV7cRepairBeginDate',fld:'vCREPAIRBEGINDATE',pic:''},{av:'AV8cRepairDays',fld:'vCREPAIRDAYS',pic:'ZZZ9'},{av:'AV9cGameId',fld:'vCGAMEID',pic:'ZZZ9'},{av:'AV10cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV11cRepairCost',fld:'vCREPAIRCOST',pic:'ZZZZ9.99'},{av:'AV12cTechnicianAlternateId',fld:'vCTECHNICIANALTERNATEID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID1_NEXTPAGE","{handler:'subgrid1_nextpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cRepairId',fld:'vCREPAIRID',pic:'ZZZ9'},{av:'AV7cRepairBeginDate',fld:'vCREPAIRBEGINDATE',pic:''},{av:'AV8cRepairDays',fld:'vCREPAIRDAYS',pic:'ZZZ9'},{av:'AV9cGameId',fld:'vCGAMEID',pic:'ZZZ9'},{av:'AV10cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV11cRepairCost',fld:'vCREPAIRCOST',pic:'ZZZZ9.99'},{av:'AV12cTechnicianAlternateId',fld:'vCTECHNICIANALTERNATEID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID1_LASTPAGE","{handler:'subgrid1_lastpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cRepairId',fld:'vCREPAIRID',pic:'ZZZ9'},{av:'AV7cRepairBeginDate',fld:'vCREPAIRBEGINDATE',pic:''},{av:'AV8cRepairDays',fld:'vCREPAIRDAYS',pic:'ZZZ9'},{av:'AV9cGameId',fld:'vCGAMEID',pic:'ZZZ9'},{av:'AV10cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV11cRepairCost',fld:'vCREPAIRCOST',pic:'ZZZZ9.99'},{av:'AV12cTechnicianAlternateId',fld:'vCTECHNICIANALTERNATEID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALIDV_CREPAIRBEGINDATE","{handler:'validv_Crepairbegindate',iparms:[]");
      setEventMetadata("VALIDV_CREPAIRBEGINDATE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Technicianalternateid',iparms:[]");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV7cRepairBeginDate = GXutil.nullDate() ;
      AV11cRepairCost = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblLblrepairidfilter_Jsonclick = "" ;
      TempTags = "" ;
      lblLblrepairbegindatefilter_Jsonclick = "" ;
      lblLblrepairdaysfilter_Jsonclick = "" ;
      lblLblgameidfilter_Jsonclick = "" ;
      lblLbltechnicianidfilter_Jsonclick = "" ;
      lblLblrepaircostfilter_Jsonclick = "" ;
      lblLbltechnicianalternateidfilter_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntoggle_Jsonclick = "" ;
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid1_Linesclass = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      AV5LinkSelection = "" ;
      A28RepairBeginDate = GXutil.nullDate() ;
      A34RepairCost = DecimalUtil.ZERO ;
      bttBtn_cancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV17Linkselection_GXI = "" ;
      scmdbuf = "" ;
      H00152_A35TechnicianAlternateId = new short[1] ;
      H00152_A34RepairCost = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00152_A30TechnicianId = new short[1] ;
      H00152_A17GameId = new short[1] ;
      H00152_A29RepairDays = new short[1] ;
      H00152_A28RepairBeginDate = new java.util.Date[] {GXutil.nullDate()} ;
      H00152_A27RepairId = new short[1] ;
      H00153_AGRID1_nRecordCount = new long[1] ;
      AV14ADVANCED_LABEL_TEMPLATE = "" ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sImgUrl = "" ;
      ROClassString = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.gx0080__default(),
         new Object[] {
             new Object[] {
            H00152_A35TechnicianAlternateId, H00152_A34RepairCost, H00152_A30TechnicianId, H00152_A17GameId, H00152_A29RepairDays, H00152_A28RepairBeginDate, H00152_A27RepairId
            }
            , new Object[] {
            H00153_AGRID1_nRecordCount
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GRID1_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGrid1_Backcolorstyle ;
   private byte subGrid1_Titlebackstyle ;
   private byte subGrid1_Allowselection ;
   private byte subGrid1_Allowhovering ;
   private byte subGrid1_Allowcollapsing ;
   private byte subGrid1_Collapsed ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGrid1_Backstyle ;
   private short AV6cRepairId ;
   private short AV8cRepairDays ;
   private short AV9cGameId ;
   private short AV10cTechnicianId ;
   private short AV12cTechnicianAlternateId ;
   private short AV13pRepairId ;
   private short wbEnd ;
   private short wbStart ;
   private short A27RepairId ;
   private short A29RepairDays ;
   private short A17GameId ;
   private short A30TechnicianId ;
   private short A35TechnicianAlternateId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_84 ;
   private int nGXsfl_84_idx=1 ;
   private int subGrid1_Rows ;
   private int edtavCrepairid_Enabled ;
   private int edtavCrepairid_Visible ;
   private int edtavCrepairbegindate_Enabled ;
   private int edtavCrepairdays_Enabled ;
   private int edtavCrepairdays_Visible ;
   private int edtavCgameid_Enabled ;
   private int edtavCgameid_Visible ;
   private int edtavCtechnicianid_Enabled ;
   private int edtavCtechnicianid_Visible ;
   private int edtavCrepaircost_Enabled ;
   private int edtavCrepaircost_Visible ;
   private int edtavCtechnicianalternateid_Enabled ;
   private int edtavCtechnicianalternateid_Visible ;
   private int subGrid1_Titlebackcolor ;
   private int subGrid1_Allbackcolor ;
   private int subGrid1_Selectedindex ;
   private int subGrid1_Selectioncolor ;
   private int subGrid1_Hoveringcolor ;
   private int subGrid1_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int idxLst ;
   private int subGrid1_Backcolor ;
   private long GRID1_nFirstRecordOnPage ;
   private long GRID1_nCurrentRecord ;
   private long GRID1_nRecordCount ;
   private java.math.BigDecimal AV11cRepairCost ;
   private java.math.BigDecimal A34RepairCost ;
   private String divAdvancedcontainer_Class ;
   private String bttBtntoggle_Class ;
   private String divRepairidfiltercontainer_Class ;
   private String divRepairbegindatefiltercontainer_Class ;
   private String divRepairdaysfiltercontainer_Class ;
   private String divGameidfiltercontainer_Class ;
   private String divTechnicianidfiltercontainer_Class ;
   private String divRepaircostfiltercontainer_Class ;
   private String divTechnicianalternateidfiltercontainer_Class ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_84_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMain_Internalname ;
   private String divAdvancedcontainer_Internalname ;
   private String divRepairidfiltercontainer_Internalname ;
   private String lblLblrepairidfilter_Internalname ;
   private String lblLblrepairidfilter_Jsonclick ;
   private String edtavCrepairid_Internalname ;
   private String TempTags ;
   private String edtavCrepairid_Jsonclick ;
   private String divRepairbegindatefiltercontainer_Internalname ;
   private String lblLblrepairbegindatefilter_Internalname ;
   private String lblLblrepairbegindatefilter_Jsonclick ;
   private String edtavCrepairbegindate_Internalname ;
   private String edtavCrepairbegindate_Jsonclick ;
   private String divRepairdaysfiltercontainer_Internalname ;
   private String lblLblrepairdaysfilter_Internalname ;
   private String lblLblrepairdaysfilter_Jsonclick ;
   private String edtavCrepairdays_Internalname ;
   private String edtavCrepairdays_Jsonclick ;
   private String divGameidfiltercontainer_Internalname ;
   private String lblLblgameidfilter_Internalname ;
   private String lblLblgameidfilter_Jsonclick ;
   private String edtavCgameid_Internalname ;
   private String edtavCgameid_Jsonclick ;
   private String divTechnicianidfiltercontainer_Internalname ;
   private String lblLbltechnicianidfilter_Internalname ;
   private String lblLbltechnicianidfilter_Jsonclick ;
   private String edtavCtechnicianid_Internalname ;
   private String edtavCtechnicianid_Jsonclick ;
   private String divRepaircostfiltercontainer_Internalname ;
   private String lblLblrepaircostfilter_Internalname ;
   private String lblLblrepaircostfilter_Jsonclick ;
   private String edtavCrepaircost_Internalname ;
   private String edtavCrepaircost_Jsonclick ;
   private String divTechnicianalternateidfiltercontainer_Internalname ;
   private String lblLbltechnicianalternateidfilter_Internalname ;
   private String lblLbltechnicianalternateidfilter_Jsonclick ;
   private String edtavCtechnicianalternateid_Internalname ;
   private String edtavCtechnicianalternateid_Jsonclick ;
   private String divGridtable_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntoggle_Internalname ;
   private String bttBtntoggle_Jsonclick ;
   private String sStyleString ;
   private String subGrid1_Internalname ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String subGrid1_Header ;
   private String edtavLinkselection_Link ;
   private String edtRepairBeginDate_Link ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavLinkselection_Internalname ;
   private String edtRepairId_Internalname ;
   private String edtRepairBeginDate_Internalname ;
   private String edtRepairDays_Internalname ;
   private String edtGameId_Internalname ;
   private String edtTechnicianId_Internalname ;
   private String edtRepairCost_Internalname ;
   private String edtTechnicianAlternateId_Internalname ;
   private String scmdbuf ;
   private String AV14ADVANCED_LABEL_TEMPLATE ;
   private String sGXsfl_84_fel_idx="0001" ;
   private String sImgUrl ;
   private String ROClassString ;
   private String edtRepairId_Jsonclick ;
   private String edtRepairBeginDate_Jsonclick ;
   private String edtRepairDays_Jsonclick ;
   private String edtGameId_Jsonclick ;
   private String edtTechnicianId_Jsonclick ;
   private String edtRepairCost_Jsonclick ;
   private String edtTechnicianAlternateId_Jsonclick ;
   private java.util.Date AV7cRepairBeginDate ;
   private java.util.Date A28RepairBeginDate ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_84_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV5LinkSelection_IsBlob ;
   private String AV17Linkselection_GXI ;
   private String AV5LinkSelection ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private IDataStoreProvider pr_default ;
   private short[] H00152_A35TechnicianAlternateId ;
   private java.math.BigDecimal[] H00152_A34RepairCost ;
   private short[] H00152_A30TechnicianId ;
   private short[] H00152_A17GameId ;
   private short[] H00152_A29RepairDays ;
   private java.util.Date[] H00152_A28RepairBeginDate ;
   private short[] H00152_A27RepairId ;
   private long[] H00153_AGRID1_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class gx0080__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00152( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV7cRepairBeginDate ,
                                          short AV8cRepairDays ,
                                          short AV9cGameId ,
                                          short AV10cTechnicianId ,
                                          java.math.BigDecimal AV11cRepairCost ,
                                          short AV12cTechnicianAlternateId ,
                                          java.util.Date A28RepairBeginDate ,
                                          short A29RepairDays ,
                                          short A17GameId ,
                                          short A30TechnicianId ,
                                          java.math.BigDecimal A34RepairCost ,
                                          short A35TechnicianAlternateId ,
                                          short AV6cRepairId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[9];
      Object[] GXv_Object2 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " `TechnicianAlternateId`, `RepairCost`, `TechnicianId`, `GameId`, `RepairDays`, `RepairBeginDate`, `RepairId`" ;
      sFromString = " FROM `Repair`" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(`RepairId` >= ?)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV7cRepairBeginDate)) )
      {
         addWhere(sWhereString, "(`RepairBeginDate` >= ?)");
      }
      else
      {
         GXv_int1[1] = (byte)(1) ;
      }
      if ( ! (0==AV8cRepairDays) )
      {
         addWhere(sWhereString, "(`RepairDays` >= ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      if ( ! (0==AV9cGameId) )
      {
         addWhere(sWhereString, "(`GameId` >= ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( ! (0==AV10cTechnicianId) )
      {
         addWhere(sWhereString, "(`TechnicianId` >= ?)");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11cRepairCost)==0) )
      {
         addWhere(sWhereString, "(`RepairCost` >= ?)");
      }
      else
      {
         GXv_int1[5] = (byte)(1) ;
      }
      if ( ! (0==AV12cTechnicianAlternateId) )
      {
         addWhere(sWhereString, "(`TechnicianAlternateId` >= ?)");
      }
      else
      {
         GXv_int1[6] = (byte)(1) ;
      }
      sOrderString += " ORDER BY `RepairId`" ;
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " LIMIT " + "?" + ", " + "?" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   protected Object[] conditional_H00153( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV7cRepairBeginDate ,
                                          short AV8cRepairDays ,
                                          short AV9cGameId ,
                                          short AV10cTechnicianId ,
                                          java.math.BigDecimal AV11cRepairCost ,
                                          short AV12cTechnicianAlternateId ,
                                          java.util.Date A28RepairBeginDate ,
                                          short A29RepairDays ,
                                          short A17GameId ,
                                          short A30TechnicianId ,
                                          java.math.BigDecimal A34RepairCost ,
                                          short A35TechnicianAlternateId ,
                                          short AV6cRepairId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[7];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM `Repair`" ;
      addWhere(sWhereString, "(`RepairId` >= ?)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV7cRepairBeginDate)) )
      {
         addWhere(sWhereString, "(`RepairBeginDate` >= ?)");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      if ( ! (0==AV8cRepairDays) )
      {
         addWhere(sWhereString, "(`RepairDays` >= ?)");
      }
      else
      {
         GXv_int3[2] = (byte)(1) ;
      }
      if ( ! (0==AV9cGameId) )
      {
         addWhere(sWhereString, "(`GameId` >= ?)");
      }
      else
      {
         GXv_int3[3] = (byte)(1) ;
      }
      if ( ! (0==AV10cTechnicianId) )
      {
         addWhere(sWhereString, "(`TechnicianId` >= ?)");
      }
      else
      {
         GXv_int3[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11cRepairCost)==0) )
      {
         addWhere(sWhereString, "(`RepairCost` >= ?)");
      }
      else
      {
         GXv_int3[5] = (byte)(1) ;
      }
      if ( ! (0==AV12cTechnicianAlternateId) )
      {
         addWhere(sWhereString, "(`TechnicianAlternateId` >= ?)");
      }
      else
      {
         GXv_int3[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_H00152(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , (java.math.BigDecimal)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (java.util.Date)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() );
            case 1 :
                  return conditional_H00153(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , (java.math.BigDecimal)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (java.util.Date)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00152", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00153", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[8]);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
      }
   }

}


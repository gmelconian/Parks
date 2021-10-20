package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class repairgeneral_impl extends GXWebComponent
{
   public repairgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public repairgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( repairgeneral_impl.class ));
   }

   public repairgeneral_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "RepairId") ;
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               A27RepairId = (short)(GXutil.lval( httpContext.GetPar( "RepairId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A27RepairId)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
               gxfirstwebparm = httpContext.GetFirstPar( "RepairId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "RepairId") ;
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
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa182( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
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
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.parks.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( "Repair General") ;
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
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?2021102014432032", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 75940), false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.parks.repairgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A27RepairId,4,0))}, new String[] {"RepairId"}) +"\">") ;
         com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:none\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.parks.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"RepairGeneral");
      forbiddenHiddens.add("GameId", localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9"));
      forbiddenHiddens.add("TechnicianId", localUtil.format( DecimalUtil.doubleToDec(A30TechnicianId), "ZZZ9"));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("repairgeneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA27RepairId", GXutil.ltrim( localUtil.ntoc( wcpOA27RepairId, (byte)(4), (byte)(0), ",", "")));
   }

   public void renderHtmlCloseForm182( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "RepairGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Repair General" ;
   }

   public void wb180( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.parks.repairgeneral");
         }
         com.parks.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ViewActionsCell", "Center", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group WWViewActions", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 8,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnEnter" ;
         StyleString = "" ;
         com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Modificar", bttBtnupdate_Jsonclick, 7, "Modificar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11181_client"+"'", TempTags, "", 2, "HLP_RepairGeneral.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 10,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnDelete" ;
         StyleString = "" ;
         com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Eliminar", bttBtndelete_Jsonclick, 7, "Eliminar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12181_client"+"'", TempTags, "", 2, "HLP_RepairGeneral.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divAttributestable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRepairId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtRepairId_Internalname, "Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairId_Internalname, GXutil.ltrim( localUtil.ntoc( A27RepairId, (byte)(4), (byte)(0), ",", "")), ((edtRepairId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A27RepairId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A27RepairId), "ZZZ9")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRepairId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtRepairBeginDate_Internalname, "Begin Date", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtRepairBeginDate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairBeginDate_Internalname, localUtil.format(A28RepairBeginDate, "99/99/99"), localUtil.format( A28RepairBeginDate, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairBeginDate_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRepairBeginDate_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RepairGeneral.htm");
         com.parks.GxWebStd.gx_bitmap( httpContext, edtRepairBeginDate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtRepairBeginDate_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtRepairDays_Internalname, "Days", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairDays_Internalname, GXutil.ltrim( localUtil.ntoc( A29RepairDays, (byte)(4), (byte)(0), ",", "")), ((edtRepairDays_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A29RepairDays), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A29RepairDays), "ZZZ9")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairDays_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRepairDays_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtRepairDateTo_Internalname, "Date To", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtRepairDateTo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairDateTo_Internalname, localUtil.format(A41RepairDateTo, "99/99/99"), localUtil.format( A41RepairDateTo, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairDateTo_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRepairDateTo_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RepairGeneral.htm");
         com.parks.GxWebStd.gx_bitmap( httpContext, edtRepairDateTo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtRepairDateTo_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtGameId_Internalname, "Game Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtGameId_Internalname, GXutil.ltrim( localUtil.ntoc( A17GameId, (byte)(4), (byte)(0), ",", "")), ((edtGameId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtGameId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtGameId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtGameName_Internalname, "Game Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtGameName_Internalname, GXutil.rtrim( A18GameName), GXutil.rtrim( localUtil.format( A18GameName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtGameName_Link, "", "", "", edtGameName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtGameName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianId_Internalname, "Technician Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianId_Internalname, GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ",", "")), ((edtTechnicianId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A30TechnicianId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A30TechnicianId), "ZZZ9")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtTechnicianId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianName_Internalname, "Technician Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianName_Internalname, GXutil.rtrim( A31TechnicianName), GXutil.rtrim( localUtil.format( A31TechnicianName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtTechnicianName_Link, "", "", "", edtTechnicianName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtTechnicianName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianLastName_Internalname, "Technician Last Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianLastName_Internalname, GXutil.rtrim( A32TechnicianLastName), GXutil.rtrim( localUtil.format( A32TechnicianLastName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianLastName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtTechnicianLastName_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "LastName", "left", true, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianAlternateId_Internalname, "Alternate Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianAlternateId_Internalname, GXutil.ltrim( localUtil.ntoc( A35TechnicianAlternateId, (byte)(4), (byte)(0), ",", "")), ((edtTechnicianAlternateId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A35TechnicianAlternateId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A35TechnicianAlternateId), "ZZZ9")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianAlternateId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtTechnicianAlternateId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianAlternateName_Internalname, "Alternate Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianAlternateName_Internalname, GXutil.rtrim( A36TechnicianAlternateName), GXutil.rtrim( localUtil.format( A36TechnicianAlternateName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianAlternateName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtTechnicianAlternateName_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianAlternateLastName_Internalname, "Last Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianAlternateLastName_Internalname, GXutil.rtrim( A37TechnicianAlternateLastName), GXutil.rtrim( localUtil.format( A37TechnicianAlternateLastName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTechnicianAlternateLastName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtTechnicianAlternateLastName_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "LastName", "left", true, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtTechnicianAlternatePhone_Internalname, "Alternate Phone", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         if ( httpContext.isSmartDevice( ) )
         {
            gxphoneLink = "tel:" + GXutil.rtrim( A38TechnicianAlternatePhone) ;
         }
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtTechnicianAlternatePhone_Internalname, GXutil.rtrim( A38TechnicianAlternatePhone), GXutil.rtrim( localUtil.format( A38TechnicianAlternatePhone, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", gxphoneLink, "", "", "", edtTechnicianAlternatePhone_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtTechnicianAlternatePhone_Enabled, 0, "tel", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Phone", "left", true, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtRepairCost_Internalname, "Cost", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairCost_Internalname, GXutil.ltrim( localUtil.ntoc( A34RepairCost, (byte)(8), (byte)(2), ",", "")), ((edtRepairCost_Enabled!=0) ? GXutil.ltrim( localUtil.format( A34RepairCost, "ZZZZ9.99")) : localUtil.format( A34RepairCost, "ZZZZ9.99")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairCost_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRepairCost_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Cost", "right", false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtRepairDiscountPercentage_Internalname, "Discount Percentage", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairDiscountPercentage_Internalname, GXutil.ltrim( localUtil.ntoc( A39RepairDiscountPercentage, (byte)(3), (byte)(0), ",", "")), ((edtRepairDiscountPercentage_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), "ZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), "ZZ9")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairDiscountPercentage_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRepairDiscountPercentage_Enabled, 0, "number", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Percentage", "right", false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtRepairFinalCost_Internalname, "Final Cost", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairFinalCost_Internalname, GXutil.ltrim( localUtil.ntoc( A40RepairFinalCost, (byte)(8), (byte)(2), ",", "")), ((edtRepairFinalCost_Enabled!=0) ? GXutil.ltrim( localUtil.format( A40RepairFinalCost, "ZZZZ9.99")) : localUtil.format( A40RepairFinalCost, "ZZZZ9.99")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairFinalCost_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRepairFinalCost_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Cost", "right", false, "", "HLP_RepairGeneral.htm");
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
         com.parks.GxWebStd.gx_label_element( httpContext, edtRepairProblems_Internalname, "Problems", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtRepairProblems_Internalname, GXutil.ltrim( localUtil.ntoc( A42RepairProblems, (byte)(1), (byte)(0), ",", "")), ((edtRepairProblems_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A42RepairProblems), "9")) : localUtil.format( DecimalUtil.doubleToDec(A42RepairProblems), "9")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRepairProblems_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRepairProblems_Enabled, 0, "number", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RepairGeneral.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start182( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_5-152925", (short)(0)) ;
            }
            Form.getMeta().addItem("description", "Repair General", (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup180( ) ;
         }
      }
   }

   public void ws182( )
   {
      start182( ) ;
      evt182( ) ;
   }

   public void evt182( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup180( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup180( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13182 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup180( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14182 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup180( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup180( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                           dynload_actions( ) ;
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
   }

   public void we182( )
   {
      if ( ! com.parks.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.parks.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm182( ) ;
         }
      }
   }

   public void pa182( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void send_integrity_hashes( )
   {
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
      rf182( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV13Pgmname = "RepairGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf182( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00183 */
         pr_default.execute(0, new Object[] {Short.valueOf(A27RepairId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A38TechnicianAlternatePhone = H00183_A38TechnicianAlternatePhone[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
            A37TechnicianAlternateLastName = H00183_A37TechnicianAlternateLastName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
            A36TechnicianAlternateName = H00183_A36TechnicianAlternateName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
            A35TechnicianAlternateId = H00183_A35TechnicianAlternateId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A35TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35TechnicianAlternateId), 4, 0));
            A32TechnicianLastName = H00183_A32TechnicianLastName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A32TechnicianLastName", A32TechnicianLastName);
            A31TechnicianName = H00183_A31TechnicianName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A31TechnicianName", A31TechnicianName);
            A30TechnicianId = H00183_A30TechnicianId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
            A18GameName = H00183_A18GameName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A18GameName", A18GameName);
            A17GameId = H00183_A17GameId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
            A42RepairProblems = H00183_A42RepairProblems[0] ;
            n42RepairProblems = H00183_n42RepairProblems[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
            A29RepairDays = H00183_A29RepairDays[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A29RepairDays", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29RepairDays), 4, 0));
            A28RepairBeginDate = H00183_A28RepairBeginDate[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A28RepairBeginDate", localUtil.format(A28RepairBeginDate, "99/99/99"));
            A39RepairDiscountPercentage = H00183_A39RepairDiscountPercentage[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A39RepairDiscountPercentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), 3, 0));
            A34RepairCost = H00183_A34RepairCost[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A34RepairCost", GXutil.ltrimstr( A34RepairCost, 8, 2));
            A38TechnicianAlternatePhone = H00183_A38TechnicianAlternatePhone[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
            A37TechnicianAlternateLastName = H00183_A37TechnicianAlternateLastName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
            A36TechnicianAlternateName = H00183_A36TechnicianAlternateName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
            A32TechnicianLastName = H00183_A32TechnicianLastName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A32TechnicianLastName", A32TechnicianLastName);
            A31TechnicianName = H00183_A31TechnicianName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A31TechnicianName", A31TechnicianName);
            A18GameName = H00183_A18GameName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A18GameName", A18GameName);
            A42RepairProblems = H00183_A42RepairProblems[0] ;
            n42RepairProblems = H00183_n42RepairProblems[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
            A40RepairFinalCost = A34RepairCost.multiply(DecimalUtil.doubleToDec((1-A39RepairDiscountPercentage/ (double) (100)))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40RepairFinalCost", GXutil.ltrimstr( A40RepairFinalCost, 8, 2));
            A41RepairDateTo = GXutil.dadd(A28RepairBeginDate,+((int)(A29RepairDays))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A41RepairDateTo", localUtil.format(A41RepairDateTo, "99/99/99"));
            /* Execute user event: Load */
            e14182 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb180( ) ;
      }
   }

   public void send_integrity_lvl_hashes182( )
   {
   }

   public void before_start_formulas( )
   {
      AV13Pgmname = "RepairGeneral" ;
      Gx_err = (short)(0) ;
      /* Using cursor H00185 */
      pr_default.execute(1, new Object[] {Short.valueOf(A27RepairId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A42RepairProblems = H00185_A42RepairProblems[0] ;
         n42RepairProblems = H00185_n42RepairProblems[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      else
      {
         A42RepairProblems = (byte)(0) ;
         n42RepairProblems = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
      }
      pr_default.close(1);
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup180( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13182 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA27RepairId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA27RepairId"), ",", ".")) ;
         /* Read variables values. */
         A28RepairBeginDate = localUtil.ctod( httpContext.cgiGet( edtRepairBeginDate_Internalname), 3) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A28RepairBeginDate", localUtil.format(A28RepairBeginDate, "99/99/99"));
         A29RepairDays = (short)(localUtil.ctol( httpContext.cgiGet( edtRepairDays_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A29RepairDays", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29RepairDays), 4, 0));
         A41RepairDateTo = localUtil.ctod( httpContext.cgiGet( edtRepairDateTo_Internalname), 3) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A41RepairDateTo", localUtil.format(A41RepairDateTo, "99/99/99"));
         A17GameId = (short)(localUtil.ctol( httpContext.cgiGet( edtGameId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
         A18GameName = httpContext.cgiGet( edtGameName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A18GameName", A18GameName);
         A30TechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( edtTechnicianId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
         A31TechnicianName = httpContext.cgiGet( edtTechnicianName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A31TechnicianName", A31TechnicianName);
         A32TechnicianLastName = httpContext.cgiGet( edtTechnicianLastName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A32TechnicianLastName", A32TechnicianLastName);
         A35TechnicianAlternateId = (short)(localUtil.ctol( httpContext.cgiGet( edtTechnicianAlternateId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A35TechnicianAlternateId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35TechnicianAlternateId), 4, 0));
         A36TechnicianAlternateName = httpContext.cgiGet( edtTechnicianAlternateName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A36TechnicianAlternateName", A36TechnicianAlternateName);
         A37TechnicianAlternateLastName = httpContext.cgiGet( edtTechnicianAlternateLastName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37TechnicianAlternateLastName", A37TechnicianAlternateLastName);
         A38TechnicianAlternatePhone = httpContext.cgiGet( edtTechnicianAlternatePhone_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A38TechnicianAlternatePhone", A38TechnicianAlternatePhone);
         A34RepairCost = localUtil.ctond( httpContext.cgiGet( edtRepairCost_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A34RepairCost", GXutil.ltrimstr( A34RepairCost, 8, 2));
         A39RepairDiscountPercentage = (short)(localUtil.ctol( httpContext.cgiGet( edtRepairDiscountPercentage_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A39RepairDiscountPercentage", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39RepairDiscountPercentage), 3, 0));
         A40RepairFinalCost = localUtil.ctond( httpContext.cgiGet( edtRepairFinalCost_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40RepairFinalCost", GXutil.ltrimstr( A40RepairFinalCost, 8, 2));
         A42RepairProblems = (byte)(localUtil.ctol( httpContext.cgiGet( edtRepairProblems_Internalname), ",", ".")) ;
         n42RepairProblems = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A42RepairProblems", GXutil.str( A42RepairProblems, 1, 0));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"RepairGeneral");
         A17GameId = (short)(localUtil.ctol( httpContext.cgiGet( edtGameId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A17GameId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A17GameId), 4, 0));
         forbiddenHiddens.add("GameId", localUtil.format( DecimalUtil.doubleToDec(A17GameId), "ZZZ9"));
         A30TechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( edtTechnicianId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A30TechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30TechnicianId), 4, 0));
         forbiddenHiddens.add("TechnicianId", localUtil.format( DecimalUtil.doubleToDec(A30TechnicianId), "ZZZ9"));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("repairgeneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
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
      e13182 ();
      if (returnInSub) return;
   }

   public void e13182( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.parks.isauthorized(remoteHandle, context).executeUdp( AV13Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.parks.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e14182( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtGameName_Link = formatLink("com.parks.viewgame", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A17GameId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"GameId","TabCode"})  ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtGameName_Internalname, "Link", edtGameName_Link, true);
      edtTechnicianName_Link = formatLink("com.parks.viewtechnician", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A30TechnicianId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"TechnicianId","TabCode"})  ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtTechnicianName_Internalname, "Link", edtTechnicianName_Link, true);
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV7TrnContext = (com.parks.SdtTransactionContext)new com.parks.SdtTransactionContext(remoteHandle, context);
      AV7TrnContext.setgxTv_SdtTransactionContext_Callerobject( AV13Pgmname );
      AV7TrnContext.setgxTv_SdtTransactionContext_Callerondelete( false );
      AV7TrnContext.setgxTv_SdtTransactionContext_Callerurl( AV10HTTPRequest.getScriptName()+"?"+AV10HTTPRequest.getQuerystring() );
      AV7TrnContext.setgxTv_SdtTransactionContext_Transactionname( "Repair" );
      AV8TrnContextAtt = (com.parks.SdtTransactionContext_Attribute)new com.parks.SdtTransactionContext_Attribute(remoteHandle, context);
      AV8TrnContextAtt.setgxTv_SdtTransactionContext_Attribute_Attributename( "RepairId" );
      AV8TrnContextAtt.setgxTv_SdtTransactionContext_Attribute_Attributevalue( GXutil.str( AV6RepairId, 4, 0) );
      AV7TrnContext.getgxTv_SdtTransactionContext_Attributes().add(AV8TrnContextAtt, 0);
      AV9Session.setValue("TrnContext", AV7TrnContext.toxml(false, true, "TransactionContext", "Parks"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A27RepairId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
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
      pa182( ) ;
      ws182( ) ;
      we182( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlA27RepairId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa182( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "repairgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa182( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A27RepairId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
      }
      wcpOA27RepairId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA27RepairId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( A27RepairId != wcpOA27RepairId ) ) )
      {
         setjustcreated();
      }
      wcpOA27RepairId = A27RepairId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA27RepairId = httpContext.cgiGet( sPrefix+"A27RepairId_CTRL") ;
      if ( GXutil.len( sCtrlA27RepairId) > 0 )
      {
         A27RepairId = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA27RepairId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A27RepairId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27RepairId), 4, 0));
      }
      else
      {
         A27RepairId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A27RepairId_PARM"), ",", ".")) ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa182( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws182( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws182( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A27RepairId_PARM", GXutil.ltrim( localUtil.ntoc( A27RepairId, (byte)(4), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA27RepairId)) > 0 )
      {
         com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A27RepairId_CTRL", GXutil.rtrim( sCtrlA27RepairId));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we182( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202110201443218", true, true);
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
      httpContext.AddJavascriptSource("repairgeneral.js", "?202110201443218", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      edtRepairId_Internalname = sPrefix+"REPAIRID" ;
      edtRepairBeginDate_Internalname = sPrefix+"REPAIRBEGINDATE" ;
      edtRepairDays_Internalname = sPrefix+"REPAIRDAYS" ;
      edtRepairDateTo_Internalname = sPrefix+"REPAIRDATETO" ;
      edtGameId_Internalname = sPrefix+"GAMEID" ;
      edtGameName_Internalname = sPrefix+"GAMENAME" ;
      edtTechnicianId_Internalname = sPrefix+"TECHNICIANID" ;
      edtTechnicianName_Internalname = sPrefix+"TECHNICIANNAME" ;
      edtTechnicianLastName_Internalname = sPrefix+"TECHNICIANLASTNAME" ;
      edtTechnicianAlternateId_Internalname = sPrefix+"TECHNICIANALTERNATEID" ;
      edtTechnicianAlternateName_Internalname = sPrefix+"TECHNICIANALTERNATENAME" ;
      edtTechnicianAlternateLastName_Internalname = sPrefix+"TECHNICIANALTERNATELASTNAME" ;
      edtTechnicianAlternatePhone_Internalname = sPrefix+"TECHNICIANALTERNATEPHONE" ;
      edtRepairCost_Internalname = sPrefix+"REPAIRCOST" ;
      edtRepairDiscountPercentage_Internalname = sPrefix+"REPAIRDISCOUNTPERCENTAGE" ;
      edtRepairFinalCost_Internalname = sPrefix+"REPAIRFINALCOST" ;
      edtRepairProblems_Internalname = sPrefix+"REPAIRPROBLEMS" ;
      divAttributestable_Internalname = sPrefix+"ATTRIBUTESTABLE" ;
      divMaintable_Internalname = sPrefix+"MAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("Carmine");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      edtRepairProblems_Jsonclick = "" ;
      edtRepairProblems_Enabled = 0 ;
      edtRepairFinalCost_Jsonclick = "" ;
      edtRepairFinalCost_Enabled = 0 ;
      edtRepairDiscountPercentage_Jsonclick = "" ;
      edtRepairDiscountPercentage_Enabled = 0 ;
      edtRepairCost_Jsonclick = "" ;
      edtRepairCost_Enabled = 0 ;
      edtTechnicianAlternatePhone_Jsonclick = "" ;
      edtTechnicianAlternatePhone_Enabled = 0 ;
      edtTechnicianAlternateLastName_Jsonclick = "" ;
      edtTechnicianAlternateLastName_Enabled = 0 ;
      edtTechnicianAlternateName_Jsonclick = "" ;
      edtTechnicianAlternateName_Enabled = 0 ;
      edtTechnicianAlternateId_Jsonclick = "" ;
      edtTechnicianAlternateId_Enabled = 0 ;
      edtTechnicianLastName_Jsonclick = "" ;
      edtTechnicianLastName_Enabled = 0 ;
      edtTechnicianName_Jsonclick = "" ;
      edtTechnicianName_Link = "" ;
      edtTechnicianName_Enabled = 0 ;
      edtTechnicianId_Jsonclick = "" ;
      edtTechnicianId_Enabled = 0 ;
      edtGameName_Jsonclick = "" ;
      edtGameName_Link = "" ;
      edtGameName_Enabled = 0 ;
      edtGameId_Jsonclick = "" ;
      edtGameId_Enabled = 0 ;
      edtRepairDateTo_Jsonclick = "" ;
      edtRepairDateTo_Enabled = 0 ;
      edtRepairDays_Jsonclick = "" ;
      edtRepairDays_Enabled = 0 ;
      edtRepairBeginDate_Jsonclick = "" ;
      edtRepairBeginDate_Enabled = 0 ;
      edtRepairId_Jsonclick = "" ;
      edtRepairId_Enabled = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A27RepairId',fld:'REPAIRID',pic:'ZZZ9'},{av:'A17GameId',fld:'GAMEID',pic:'ZZZ9'},{av:'A30TechnicianId',fld:'TECHNICIANID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11181',iparms:[{av:'A27RepairId',fld:'REPAIRID',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12181',iparms:[{av:'A27RepairId',fld:'REPAIRID',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_REPAIRID","{handler:'valid_Repairid',iparms:[]");
      setEventMetadata("VALID_REPAIRID",",oparms:[]}");
      setEventMetadata("VALID_REPAIRBEGINDATE","{handler:'valid_Repairbegindate',iparms:[]");
      setEventMetadata("VALID_REPAIRBEGINDATE",",oparms:[]}");
      setEventMetadata("VALID_REPAIRDAYS","{handler:'valid_Repairdays',iparms:[]");
      setEventMetadata("VALID_REPAIRDAYS",",oparms:[]}");
      setEventMetadata("VALID_GAMEID","{handler:'valid_Gameid',iparms:[]");
      setEventMetadata("VALID_GAMEID",",oparms:[]}");
      setEventMetadata("VALID_TECHNICIANID","{handler:'valid_Technicianid',iparms:[]");
      setEventMetadata("VALID_TECHNICIANID",",oparms:[]}");
      setEventMetadata("VALID_TECHNICIANALTERNATEID","{handler:'valid_Technicianalternateid',iparms:[]");
      setEventMetadata("VALID_TECHNICIANALTERNATEID",",oparms:[]}");
      setEventMetadata("VALID_REPAIRCOST","{handler:'valid_Repaircost',iparms:[]");
      setEventMetadata("VALID_REPAIRCOST",",oparms:[]}");
      setEventMetadata("VALID_REPAIRDISCOUNTPERCENTAGE","{handler:'valid_Repairdiscountpercentage',iparms:[]");
      setEventMetadata("VALID_REPAIRDISCOUNTPERCENTAGE",",oparms:[]}");
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
      sPrefix = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      GX_FocusControl = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      A28RepairBeginDate = GXutil.nullDate() ;
      A41RepairDateTo = GXutil.nullDate() ;
      A18GameName = "" ;
      A31TechnicianName = "" ;
      A32TechnicianLastName = "" ;
      A36TechnicianAlternateName = "" ;
      A37TechnicianAlternateLastName = "" ;
      gxphoneLink = "" ;
      A38TechnicianAlternatePhone = "" ;
      A34RepairCost = DecimalUtil.ZERO ;
      A40RepairFinalCost = DecimalUtil.ZERO ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV13Pgmname = "" ;
      scmdbuf = "" ;
      H00183_A27RepairId = new short[1] ;
      H00183_A38TechnicianAlternatePhone = new String[] {""} ;
      H00183_A37TechnicianAlternateLastName = new String[] {""} ;
      H00183_A36TechnicianAlternateName = new String[] {""} ;
      H00183_A35TechnicianAlternateId = new short[1] ;
      H00183_A32TechnicianLastName = new String[] {""} ;
      H00183_A31TechnicianName = new String[] {""} ;
      H00183_A30TechnicianId = new short[1] ;
      H00183_A18GameName = new String[] {""} ;
      H00183_A17GameId = new short[1] ;
      H00183_A42RepairProblems = new byte[1] ;
      H00183_n42RepairProblems = new boolean[] {false} ;
      H00183_A29RepairDays = new short[1] ;
      H00183_A28RepairBeginDate = new java.util.Date[] {GXutil.nullDate()} ;
      H00183_A39RepairDiscountPercentage = new short[1] ;
      H00183_A34RepairCost = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00185_A42RepairProblems = new byte[1] ;
      H00185_n42RepairProblems = new boolean[] {false} ;
      hsh = "" ;
      AV7TrnContext = new com.parks.SdtTransactionContext(remoteHandle, context);
      AV10HTTPRequest = httpContext.getHttpRequest();
      AV8TrnContextAtt = new com.parks.SdtTransactionContext_Attribute(remoteHandle, context);
      AV9Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA27RepairId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.repairgeneral__default(),
         new Object[] {
             new Object[] {
            H00183_A27RepairId, H00183_A38TechnicianAlternatePhone, H00183_A37TechnicianAlternateLastName, H00183_A36TechnicianAlternateName, H00183_A35TechnicianAlternateId, H00183_A32TechnicianLastName, H00183_A31TechnicianName, H00183_A30TechnicianId, H00183_A18GameName, H00183_A17GameId,
            H00183_A42RepairProblems, H00183_n42RepairProblems, H00183_A29RepairDays, H00183_A28RepairBeginDate, H00183_A39RepairDiscountPercentage, H00183_A34RepairCost
            }
            , new Object[] {
            H00185_A42RepairProblems, H00185_n42RepairProblems
            }
         }
      );
      AV13Pgmname = "RepairGeneral" ;
      /* GeneXus formulas. */
      AV13Pgmname = "RepairGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A42RepairProblems ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA27RepairId ;
   private short A27RepairId ;
   private short A17GameId ;
   private short A30TechnicianId ;
   private short wbEnd ;
   private short wbStart ;
   private short A29RepairDays ;
   private short A35TechnicianAlternateId ;
   private short A39RepairDiscountPercentage ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV6RepairId ;
   private int edtRepairId_Enabled ;
   private int edtRepairBeginDate_Enabled ;
   private int edtRepairDays_Enabled ;
   private int edtRepairDateTo_Enabled ;
   private int edtGameId_Enabled ;
   private int edtGameName_Enabled ;
   private int edtTechnicianId_Enabled ;
   private int edtTechnicianName_Enabled ;
   private int edtTechnicianLastName_Enabled ;
   private int edtTechnicianAlternateId_Enabled ;
   private int edtTechnicianAlternateName_Enabled ;
   private int edtTechnicianAlternateLastName_Enabled ;
   private int edtTechnicianAlternatePhone_Enabled ;
   private int edtRepairCost_Enabled ;
   private int edtRepairDiscountPercentage_Enabled ;
   private int edtRepairFinalCost_Enabled ;
   private int edtRepairProblems_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal A34RepairCost ;
   private java.math.BigDecimal A40RepairFinalCost ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divMaintable_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divAttributestable_Internalname ;
   private String edtRepairId_Internalname ;
   private String edtRepairId_Jsonclick ;
   private String edtRepairBeginDate_Internalname ;
   private String edtRepairBeginDate_Jsonclick ;
   private String edtRepairDays_Internalname ;
   private String edtRepairDays_Jsonclick ;
   private String edtRepairDateTo_Internalname ;
   private String edtRepairDateTo_Jsonclick ;
   private String edtGameId_Internalname ;
   private String edtGameId_Jsonclick ;
   private String edtGameName_Internalname ;
   private String A18GameName ;
   private String edtGameName_Link ;
   private String edtGameName_Jsonclick ;
   private String edtTechnicianId_Internalname ;
   private String edtTechnicianId_Jsonclick ;
   private String edtTechnicianName_Internalname ;
   private String A31TechnicianName ;
   private String edtTechnicianName_Link ;
   private String edtTechnicianName_Jsonclick ;
   private String edtTechnicianLastName_Internalname ;
   private String A32TechnicianLastName ;
   private String edtTechnicianLastName_Jsonclick ;
   private String edtTechnicianAlternateId_Internalname ;
   private String edtTechnicianAlternateId_Jsonclick ;
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
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV13Pgmname ;
   private String scmdbuf ;
   private String hsh ;
   private String sCtrlA27RepairId ;
   private java.util.Date A28RepairBeginDate ;
   private java.util.Date A41RepairDateTo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n42RepairProblems ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] H00183_A27RepairId ;
   private String[] H00183_A38TechnicianAlternatePhone ;
   private String[] H00183_A37TechnicianAlternateLastName ;
   private String[] H00183_A36TechnicianAlternateName ;
   private short[] H00183_A35TechnicianAlternateId ;
   private String[] H00183_A32TechnicianLastName ;
   private String[] H00183_A31TechnicianName ;
   private short[] H00183_A30TechnicianId ;
   private String[] H00183_A18GameName ;
   private short[] H00183_A17GameId ;
   private byte[] H00183_A42RepairProblems ;
   private boolean[] H00183_n42RepairProblems ;
   private short[] H00183_A29RepairDays ;
   private java.util.Date[] H00183_A28RepairBeginDate ;
   private short[] H00183_A39RepairDiscountPercentage ;
   private java.math.BigDecimal[] H00183_A34RepairCost ;
   private byte[] H00185_A42RepairProblems ;
   private boolean[] H00185_n42RepairProblems ;
   private com.genexus.webpanels.WebSession AV9Session ;
   private com.parks.SdtTransactionContext AV7TrnContext ;
   private com.parks.SdtTransactionContext_Attribute AV8TrnContextAtt ;
}

final  class repairgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00183", "SELECT T1.`RepairId`, T2.`TechnicianPhone` AS TechnicianAlternatePhone, T2.`TechnicianLastName` AS TechnicianAlternateLastName, T2.`TechnicianName` AS TechnicianAlternateName, T1.`TechnicianAlternateId` AS TechnicianAlternateId, T3.`TechnicianLastName`, T3.`TechnicianName`, T1.`TechnicianId`, T4.`GameName`, T1.`GameId`, COALESCE( T5.`RepairProblems`, 0) AS RepairProblems, T1.`RepairDays`, T1.`RepairBeginDate`, T1.`RepairDiscountPercentage`, T1.`RepairCost` FROM ((((`Repair` T1 INNER JOIN `Technician` T2 ON T2.`TechnicianId` = T1.`TechnicianAlternateId`) INNER JOIN `Technician` T3 ON T3.`TechnicianId` = T1.`TechnicianId`) INNER JOIN `Game` T4 ON T4.`GameId` = T1.`GameId`) LEFT JOIN (SELECT COUNT(*) AS RepairProblems, `RepairId` FROM `RepairKind` GROUP BY `RepairId` ) T5 ON T5.`RepairId` = T1.`RepairId`) WHERE T1.`RepairId` = ? ORDER BY T1.`RepairId` ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00185", "SELECT COALESCE( T1.`RepairProblems`, 0) AS RepairProblems FROM (SELECT COUNT(*) AS RepairProblems, `RepairId` FROM `RepairKind` GROUP BY `RepairId` ) T1 WHERE T1.`RepairId` = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 50);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 50);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 50);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(13);
               ((short[]) buf[14])[0] = rslt.getShort(14);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(15,2);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
      }
   }

}


package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class tabbedview_impl extends GXWebComponent
{
   public tabbedview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public tabbedview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tabbedview_impl.class ));
   }

   public tabbedview_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "Tabs") ;
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
               httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV18Tabs);
               AV15TabCode = httpContext.GetPar( "TabCode") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15TabCode", AV15TabCode);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV18Tabs,AV15TabCode});
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
               gxfirstwebparm = httpContext.GetFirstPar( "Tabs") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "Tabs") ;
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
         pa0G2( ) ;
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
      com.parks.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), false);
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
         httpContext.writeValue( "Tabbed View") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2021102014431376", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
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
         httpContext.writeText( " "+"class=\"Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"Form\" data-gx-class=\"Form\" novalidate action=\""+formatLink("com.parks.tabbedview", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15TabCode))}, new String[] {"Tabs","TabCode"}) +"\">") ;
         com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:none\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "Form", true);
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
         com.parks.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "Form" : Form.getThemeClass())+"-fx");
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
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV15TabCode", GXutil.rtrim( wcpOAV15TabCode));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFIRSTTAB", GXutil.ltrim( localUtil.ntoc( AV5FirstTab, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLASTTAB", GXutil.ltrim( localUtil.ntoc( AV11LastTab, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTABS", AV18Tabs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTABS", AV18Tabs);
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTABCODE", GXutil.rtrim( AV15TabCode));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vINDEX", GXutil.ltrim( localUtil.ntoc( AV8Index, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSELECTEDTAB", GXutil.ltrim( localUtil.ntoc( AV13SelectedTab, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTAB", AV14Tab);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTAB", AV14Tab);
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTABSMARKUP", GXutil.rtrim( AV19TabsMarkup));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTABTEMPLATE", GXutil.rtrim( AV20TabTemplate));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      com.parks.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vURLCHANGEDEVENT", AV23URLChangedEvent);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"HISTORYMANAGER_Hash", GXutil.rtrim( Historymanager_Hash));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"HISTORYMANAGER_Hash", GXutil.rtrim( Historymanager_Hash));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"HISTORYMANAGER_Hash", GXutil.rtrim( Historymanager_Hash));
   }

   public void renderHtmlCloseForm0G2( )
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
         if ( ! ( WebComp_Component == null ) )
         {
            WebComp_Component.componentjscripts();
         }
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
      return "TabbedView" ;
   }

   public String getPgmdesc( )
   {
      return "Tabbed View" ;
   }

   public void wb0G0( )
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
            com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.parks.tabbedview");
            httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
         }
         com.parks.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         wb_table1_2_0G2( true) ;
      }
      else
      {
         wb_table1_2_0G2( false) ;
      }
      return  ;
   }

   public void wb_table1_2_0G2e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucHistorymanager.render(context, "historymanager", Historymanager_Internalname, sPrefix+"HISTORYMANAGERContainer");
      }
      wbLoad = true ;
   }

   public void start0G2( )
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
            Form.getMeta().addItem("description", "Tabbed View", (short)(0)) ;
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
            strup0G0( ) ;
         }
      }
   }

   public void ws0G2( )
   {
      start0G2( ) ;
      evt0G2( ) ;
   }

   public void evt0G2( )
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
                              strup0G0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "HISTORYMANAGER.URLCHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0G0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e110G2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0G0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e120G2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0G0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e130G2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0G0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e140G2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup0G0( ) ;
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
                              strup0G0( ) ;
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 14 )
                     {
                        OldComponent = httpContext.cgiGet( sPrefix+"W0014") ;
                        if ( ( GXutil.len( OldComponent) == 0 ) || ( GXutil.strcmp(OldComponent, WebComp_Component_Component) != 0 ) )
                        {
                           WebComp_Component = WebUtils.getWebComponent(getClass(), "com.parks." + OldComponent + "_impl", remoteHandle, context);
                           WebComp_Component_Component = OldComponent ;
                        }
                        if ( GXutil.len( WebComp_Component_Component) != 0 )
                        {
                           WebComp_Component.componentprocess(sPrefix+"W0014", "", sEvt);
                        }
                        WebComp_Component_Component = OldComponent ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we0G2( )
   {
      if ( ! com.parks.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.parks.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0G2( ) ;
         }
      }
   }

   public void pa0G2( )
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
      rf0G2( ) ;
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

   public void rf0G2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e130G2 ();
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Component_Component) != 0 )
            {
               WebComp_Component.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e140G2 ();
         wb0G0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0G2( )
   {
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTABTEMPLATE", GXutil.rtrim( AV20TabTemplate));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0G0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e120G2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV15TabCode = httpContext.cgiGet( sPrefix+"wcpOAV15TabCode") ;
         Historymanager_Hash = httpContext.cgiGet( sPrefix+"HISTORYMANAGER_Hash") ;
         Historymanager_Hash = httpContext.cgiGet( sPrefix+"HISTORYMANAGER_Hash") ;
         /* Read variables values. */
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e120G2 ();
      if (returnInSub) return;
   }

   public void e120G2( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'INIT' */
      S112 ();
      if (returnInSub) return;
   }

   public void e110G2( )
   {
      /* Historymanager_Urlchanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'DRAW TABS' */
      S122 ();
      if (returnInSub) return;
      AV23URLChangedEvent = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23URLChangedEvent", AV23URLChangedEvent);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14Tab", AV14Tab);
   }

   public void e130G2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      if ( ! AV23URLChangedEvent )
      {
         /* Execute user subroutine: 'DRAW TABS' */
         S122 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14Tab", AV14Tab);
   }

   public void S112( )
   {
      /* 'INIT' Routine */
      returnInSub = false ;
      AV20TabTemplate = "<li class=\"%1\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TabTemplate", AV20TabTemplate);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      AV20TabTemplate += "<a id=\"%2Tab\" %3%7 class=\"%4\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TabTemplate", AV20TabTemplate);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      AV20TabTemplate += "<span class=\"%5\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TabTemplate", AV20TabTemplate);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      AV20TabTemplate += "<span class=\"TabBackground\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TabTemplate", AV20TabTemplate);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      AV20TabTemplate += "<span class=\"TabText\">%6</span>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TabTemplate", AV20TabTemplate);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      AV20TabTemplate += "</span>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TabTemplate", AV20TabTemplate);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      AV20TabTemplate += "</span>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TabTemplate", AV20TabTemplate);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      AV20TabTemplate += "</a>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TabTemplate", AV20TabTemplate);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
      AV20TabTemplate += "</li>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TabTemplate", AV20TabTemplate);
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTABTEMPLATE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV20TabTemplate, ""))));
   }

   public void S122( )
   {
      /* 'DRAW TABS' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'FINDTABINDEX' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SCROLLTABS' */
      S142 ();
      if (returnInSub) return;
      AV9IsFirstTab = true ;
      AV19TabsMarkup = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19TabsMarkup", AV19TabsMarkup);
      AV8Index = AV5FirstTab ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8Index", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Index), 4, 0));
      while ( AV8Index <= AV11LastTab )
      {
         AV14Tab = (com.parks.SdtTabOptions_TabOptionsItem)((com.parks.SdtTabOptions_TabOptionsItem)AV18Tabs.elementAt(-1+AV8Index));
         /* Execute user subroutine: 'LOADITEM' */
         S152 ();
         if (returnInSub) return;
         AV9IsFirstTab = false ;
         AV8Index = (short)(AV8Index+1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8Index", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Index), 4, 0));
      }
      lblTabs_Caption = GXutil.format( "<ul class=\"Tabs\">%1</ul>", AV19TabsMarkup, "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTabs_Internalname, "Caption", lblTabs_Caption, true);
   }

   public void S132( )
   {
      /* 'FINDTABINDEX' Routine */
      returnInSub = false ;
      AV6Found = false ;
      AV8Index = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8Index", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Index), 4, 0));
      while ( AV8Index <= AV18Tabs.size() )
      {
         if ( ( ( GXutil.strcmp(Historymanager_Hash, "") == 0 ) && ( ( GXutil.strcmp(((com.parks.SdtTabOptions_TabOptionsItem)AV18Tabs.elementAt(-1+AV8Index)).getgxTv_SdtTabOptions_TabOptionsItem_Code(), AV15TabCode) == 0 ) ) ) || ( ( GXutil.strcmp(((com.parks.SdtTabOptions_TabOptionsItem)AV18Tabs.elementAt(-1+AV8Index)).getgxTv_SdtTabOptions_TabOptionsItem_Code(), Historymanager_Hash) == 0 ) ) )
         {
            AV13SelectedTab = AV8Index ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13SelectedTab", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13SelectedTab), 4, 0));
            AV6Found = true ;
            if (true) break;
         }
         AV8Index = (short)(AV8Index+1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8Index", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Index), 4, 0));
      }
      if ( ! AV6Found && ( AV18Tabs.size() > 0 ) )
      {
         AV13SelectedTab = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13SelectedTab", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13SelectedTab), 4, 0));
      }
   }

   public void S142( )
   {
      /* 'SCROLLTABS' Routine */
      returnInSub = false ;
      AV5FirstTab = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5FirstTab", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5FirstTab), 4, 0));
      AV11LastTab = (short)(AV18Tabs.size()) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11LastTab", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LastTab), 4, 0));
      imgTabprevious_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, imgTabprevious_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgTabprevious_Visible), 5, 0), true);
      imgTabnext_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, imgTabnext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgTabnext_Visible), 5, 0), true);
   }

   public void S152( )
   {
      /* 'LOADITEM' Routine */
      returnInSub = false ;
      AV16TabLeftCls = "TabLeft" ;
      if ( AV8Index == AV5FirstTab )
      {
         AV16TabLeftCls = "TabFirst" ;
      }
      AV17TabRightCls = "TabRight" ;
      if ( AV8Index == AV11LastTab )
      {
         AV17TabRightCls = "TabLast" ;
      }
      if ( AV8Index == AV13SelectedTab )
      {
         AV19TabsMarkup += GXutil.format( AV20TabTemplate, "Tab TabSelected", AV14Tab.getgxTv_SdtTabOptions_TabOptionsItem_Code(), "", AV16TabLeftCls, AV17TabRightCls, AV14Tab.getgxTv_SdtTabOptions_TabOptionsItem_Description(), "", "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19TabsMarkup", AV19TabsMarkup);
         AV21WebComponentUrl = AV14Tab.getgxTv_SdtTabOptions_TabOptionsItem_Webcomponent() ;
         /* Object Property */
         gxDynCompUrl = AV21WebComponentUrl ;
         if ( ! httpContext.IsSameComponent( WebComp_Component_Component, gxDynCompUrl) )
         {
            WebComp_Component = WebUtils.getWebComponent(getClass(), gxDynCompUrl + "_impl", remoteHandle, context);
            WebComp_Component_Component = gxDynCompUrl ;
         }
         else
         {
            WebComp_Component.setparmsfromurl(gxDynCompUrl);
         }
         if ( GXutil.len( WebComp_Component_Component) != 0 )
         {
            WebComp_Component.setjustcreated();
            WebComp_Component.componentprepare(new Object[] {sPrefix+"W0014",""});
            WebComp_Component.componentbind(new Object[] {});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Component )
         {
            httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0014"+"");
            WebComp_Component.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      else
      {
         AV12OnClickTemplate = " onclick=\"return HistoryManager.AddHistoryPoint(" + "'%1'" + ", false, event)\"" ;
         AV19TabsMarkup += GXutil.format( AV20TabTemplate, "Tab", AV14Tab.getgxTv_SdtTabOptions_TabOptionsItem_Code(), GXutil.format( "href=\"%1\"", AV14Tab.getgxTv_SdtTabOptions_TabOptionsItem_Link(), "", "", "", "", "", "", "", ""), AV16TabLeftCls, AV17TabRightCls, AV14Tab.getgxTv_SdtTabOptions_TabOptionsItem_Description(), GXutil.format( AV12OnClickTemplate, AV14Tab.getgxTv_SdtTabOptions_TabOptionsItem_Code(), "", "", "", "", "", "", "", ""), "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19TabsMarkup", AV19TabsMarkup);
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e140G2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_2_0G2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.parks.GxWebStd.gx_table_start( httpContext, tblTable1_Internalname, tblTable1_Internalname, "", "ViewTable", 0, "", "", 0, 0, sStyleString, "none", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr style=\""+GXutil.CssPrettify( "vertical-align:bottom")+"\">") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "vertical-align:bottom;height:40px")+"\">") ;
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divTabcontainer_Internalname, 1, 0, "px", 0, "px", "TabContainer", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblTabs_Internalname, lblTabs_Caption, "", "", lblTabs_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", 0, "", 1, 1, 0, (short)(1), "HLP_TabbedView.htm");
         /* Static images/pictures */
         ClassString = "TabPagingPrevious" ;
         StyleString = "" ;
         sImgUrl = "(none)" ;
         com.parks.GxWebStd.gx_bitmap( httpContext, imgTabprevious_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgTabprevious_Visible, 1, "", "Previous Tab", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_TabbedView.htm");
         /* Static images/pictures */
         ClassString = "TabPagingNext" ;
         StyleString = "" ;
         sImgUrl = "(none)" ;
         com.parks.GxWebStd.gx_bitmap( httpContext, imgTabnext_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgTabnext_Visible, 1, "", "Next Tab", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_TabbedView.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "vertical-align:top;height:39px")+"\">") ;
         wb_table2_11_0G2( true) ;
      }
      else
      {
         wb_table2_11_0G2( false) ;
      }
      return  ;
   }

   public void wb_table2_11_0G2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_2_0G2e( true) ;
      }
      else
      {
         wb_table1_2_0G2e( false) ;
      }
   }

   public void wb_table2_11_0G2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.parks.GxWebStd.gx_table_start( httpContext, tblTable2_Internalname, tblTable2_Internalname, "", "TableBorder", 0, "", "", 0, 0, sStyleString, "none", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "vertical-align:top")+"\">") ;
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0014"+"", GXutil.rtrim( WebComp_Component_Component));
            httpContext.writeText( "<div") ;
            com.parks.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0014"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Component_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldComponent), GXutil.lower( WebComp_Component_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0014"+"");
               }
               WebComp_Component.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldComponent), GXutil.lower( WebComp_Component_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_11_0G2e( true) ;
      }
      else
      {
         wb_table2_11_0G2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV18Tabs = (GXBaseCollection<com.parks.SdtTabOptions_TabOptionsItem>)getParm(obj,0) ;
      AV15TabCode = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15TabCode", AV15TabCode);
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
      pa0G2( ) ;
      ws0G2( ) ;
      we0G2( ) ;
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
      sCtrlAV18Tabs = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV15TabCode = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa0G2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "tabbedview", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa0G2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV18Tabs = (GXBaseCollection<com.parks.SdtTabOptions_TabOptionsItem>)getParm(obj,2) ;
         AV15TabCode = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15TabCode", AV15TabCode);
      }
      wcpOAV15TabCode = httpContext.cgiGet( sPrefix+"wcpOAV15TabCode") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV15TabCode, wcpOAV15TabCode) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV15TabCode = AV15TabCode ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV18Tabs = httpContext.cgiGet( sPrefix+"AV18Tabs_CTRL") ;
      if ( GXutil.len( sCtrlAV18Tabs) > 0 )
      {
         AV18Tabs = new GXBaseCollection<com.parks.SdtTabOptions_TabOptionsItem>() ;
      }
      else
      {
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"AV18Tabs_PARM"), AV18Tabs);
      }
      sCtrlAV15TabCode = httpContext.cgiGet( sPrefix+"AV15TabCode_CTRL") ;
      if ( GXutil.len( sCtrlAV15TabCode) > 0 )
      {
         AV15TabCode = httpContext.cgiGet( sCtrlAV15TabCode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15TabCode", AV15TabCode);
      }
      else
      {
         AV15TabCode = httpContext.cgiGet( sPrefix+"AV15TabCode_PARM") ;
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
      pa0G2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws0G2( ) ;
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
      ws0G2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"AV18Tabs_PARM", AV18Tabs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"AV18Tabs_PARM", AV18Tabs);
      }
      if ( GXutil.len( GXutil.rtrim( sCtrlAV18Tabs)) > 0 )
      {
         com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV18Tabs_CTRL", GXutil.rtrim( sCtrlAV18Tabs));
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV15TabCode_PARM", GXutil.rtrim( AV15TabCode));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV15TabCode)) > 0 )
      {
         com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV15TabCode_CTRL", GXutil.rtrim( sCtrlAV15TabCode));
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
      we0G2( ) ;
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
      if ( ! ( WebComp_Component == null ) )
      {
         WebComp_Component.componentjscripts();
      }
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Component == null ) )
      {
         if ( GXutil.len( WebComp_Component_Component) != 0 )
         {
            WebComp_Component.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202110201443142", true, true);
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
      httpContext.AddJavascriptSource("tabbedview.js", "?202110201443142", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTabs_Internalname = sPrefix+"TABS" ;
      imgTabprevious_Internalname = sPrefix+"TABPREVIOUS" ;
      imgTabnext_Internalname = sPrefix+"TABNEXT" ;
      divTabcontainer_Internalname = sPrefix+"TABCONTAINER" ;
      tblTable2_Internalname = sPrefix+"TABLE2" ;
      tblTable1_Internalname = sPrefix+"TABLE1" ;
      Historymanager_Internalname = sPrefix+"HISTORYMANAGER" ;
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
      imgTabnext_Visible = 1 ;
      imgTabprevious_Visible = 1 ;
      lblTabs_Jsonclick = "" ;
      lblTabs_Backcolor = (int)(0xFFFFFF) ;
      lblTabs_Caption = "Tabs" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV23URLChangedEvent',fld:'vURLCHANGEDEVENT',pic:''},{av:'AV5FirstTab',fld:'vFIRSTTAB',pic:'ZZZ9'},{av:'AV11LastTab',fld:'vLASTTAB',pic:'ZZZ9'},{av:'AV18Tabs',fld:'vTABS',pic:''},{av:'AV15TabCode',fld:'vTABCODE',pic:''},{av:'Historymanager_Hash',ctrl:'HISTORYMANAGER',prop:'Hash'},{av:'AV8Index',fld:'vINDEX',pic:'ZZZ9'},{av:'AV13SelectedTab',fld:'vSELECTEDTAB',pic:'ZZZ9'},{av:'AV14Tab',fld:'vTAB',pic:''},{av:'AV19TabsMarkup',fld:'vTABSMARKUP',pic:''},{av:'AV20TabTemplate',fld:'vTABTEMPLATE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV19TabsMarkup',fld:'vTABSMARKUP',pic:''},{av:'AV8Index',fld:'vINDEX',pic:'ZZZ9'},{av:'AV14Tab',fld:'vTAB',pic:''},{av:'lblTabs_Caption',ctrl:'TABS',prop:'Caption'},{av:'AV13SelectedTab',fld:'vSELECTEDTAB',pic:'ZZZ9'},{av:'AV5FirstTab',fld:'vFIRSTTAB',pic:'ZZZ9'},{av:'AV11LastTab',fld:'vLASTTAB',pic:'ZZZ9'},{av:'imgTabprevious_Visible',ctrl:'TABPREVIOUS',prop:'Visible'},{av:'imgTabnext_Visible',ctrl:'TABNEXT',prop:'Visible'},{ctrl:'COMPONENT'}]}");
      setEventMetadata("HISTORYMANAGER.URLCHANGED","{handler:'e110G2',iparms:[{av:'AV5FirstTab',fld:'vFIRSTTAB',pic:'ZZZ9'},{av:'AV11LastTab',fld:'vLASTTAB',pic:'ZZZ9'},{av:'AV18Tabs',fld:'vTABS',pic:''},{av:'AV15TabCode',fld:'vTABCODE',pic:''},{av:'Historymanager_Hash',ctrl:'HISTORYMANAGER',prop:'Hash'},{av:'AV8Index',fld:'vINDEX',pic:'ZZZ9'},{av:'AV13SelectedTab',fld:'vSELECTEDTAB',pic:'ZZZ9'},{av:'AV14Tab',fld:'vTAB',pic:''},{av:'AV19TabsMarkup',fld:'vTABSMARKUP',pic:''},{av:'AV20TabTemplate',fld:'vTABTEMPLATE',pic:'',hsh:true}]");
      setEventMetadata("HISTORYMANAGER.URLCHANGED",",oparms:[{av:'AV23URLChangedEvent',fld:'vURLCHANGEDEVENT',pic:''},{av:'AV19TabsMarkup',fld:'vTABSMARKUP',pic:''},{av:'AV8Index',fld:'vINDEX',pic:'ZZZ9'},{av:'AV14Tab',fld:'vTAB',pic:''},{av:'lblTabs_Caption',ctrl:'TABS',prop:'Caption'},{av:'AV13SelectedTab',fld:'vSELECTEDTAB',pic:'ZZZ9'},{av:'AV5FirstTab',fld:'vFIRSTTAB',pic:'ZZZ9'},{av:'AV11LastTab',fld:'vLASTTAB',pic:'ZZZ9'},{av:'imgTabprevious_Visible',ctrl:'TABPREVIOUS',prop:'Visible'},{av:'imgTabnext_Visible',ctrl:'TABNEXT',prop:'Visible'},{ctrl:'COMPONENT'}]}");
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
      wcpOAV15TabCode = "" ;
      Historymanager_Hash = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV18Tabs = new GXBaseCollection<com.parks.SdtTabOptions_TabOptionsItem>(com.parks.SdtTabOptions_TabOptionsItem.class, "TabOptionsItem", "Parks", remoteHandle);
      AV15TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV20TabTemplate = "" ;
      GXKey = "" ;
      AV14Tab = new com.parks.SdtTabOptions_TabOptionsItem(remoteHandle, context);
      AV19TabsMarkup = "" ;
      GX_FocusControl = "" ;
      ucHistorymanager = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldComponent = "" ;
      WebComp_Component_Component = "" ;
      gxDynCompUrl = "" ;
      AV16TabLeftCls = "" ;
      AV17TabRightCls = "" ;
      AV21WebComponentUrl = "" ;
      AV12OnClickTemplate = "" ;
      sStyleString = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV18Tabs = "" ;
      sCtrlAV15TabCode = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Component = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short AV5FirstTab ;
   private short AV11LastTab ;
   private short AV8Index ;
   private short AV13SelectedTab ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int imgTabprevious_Visible ;
   private int imgTabnext_Visible ;
   private int idxLst ;
   private int lblTabs_Backcolor ;
   private String wcpOAV15TabCode ;
   private String Historymanager_Hash ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV15TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV20TabTemplate ;
   private String GXKey ;
   private String AV19TabsMarkup ;
   private String GX_FocusControl ;
   private String Historymanager_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldComponent ;
   private String WebComp_Component_Component ;
   private String gxDynCompUrl ;
   private String lblTabs_Caption ;
   private String lblTabs_Internalname ;
   private String imgTabprevious_Internalname ;
   private String imgTabnext_Internalname ;
   private String AV16TabLeftCls ;
   private String AV17TabRightCls ;
   private String AV12OnClickTemplate ;
   private String sStyleString ;
   private String tblTable1_Internalname ;
   private String divTabcontainer_Internalname ;
   private String lblTabs_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String tblTable2_Internalname ;
   private String sCtrlAV18Tabs ;
   private String sCtrlAV15TabCode ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV23URLChangedEvent ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV9IsFirstTab ;
   private boolean AV6Found ;
   private boolean bDynCreated_Component ;
   private String AV21WebComponentUrl ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Component ;
   private com.genexus.webpanels.GXUserControl ucHistorymanager ;
   private GXBaseCollection<com.parks.SdtTabOptions_TabOptionsItem> AV18Tabs ;
   private com.parks.SdtTabOptions_TabOptionsItem AV14Tab ;
}


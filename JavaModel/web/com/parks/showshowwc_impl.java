package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class showshowwc_impl extends GXWebComponent
{
   public showshowwc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public showshowwc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( showshowwc_impl.class ));
   }

   public showshowwc_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "ShowId") ;
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
               AV6ShowId = (short)(GXutil.lval( httpContext.GetPar( "ShowId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6ShowId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6ShowId), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(AV6ShowId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "ShowId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "ShowId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
            {
               nRC_GXsfl_20 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_20"))) ;
               nGXsfl_20_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_20_idx"))) ;
               sGXsfl_20_idx = httpContext.GetPar( "sGXsfl_20_idx") ;
               sPrefix = httpContext.GetPar( "sPrefix") ;
               AV12Update = httpContext.GetPar( "Update") ;
               AV13Delete = httpContext.GetPar( "Delete") ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxnrgrid_newrow( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
            {
               subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
               AV6ShowId = (short)(GXutil.lval( httpContext.GetPar( "ShowId"))) ;
               AV12Update = httpContext.GetPar( "Update") ;
               AV13Delete = httpContext.GetPar( "Delete") ;
               sPrefix = httpContext.GetPar( "sPrefix") ;
               init_default_properties( ) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxgrgrid_refresh( subGrid_Rows, AV6ShowId, AV12Update, AV13Delete, sPrefix) ;
               com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
         pa1I2( ) ;
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
         httpContext.writeValue( "Show Show WC") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2021102014431577", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.parks.showshowwc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV6ShowId,4,0))}, new String[] {"ShowId"}) +"\">") ;
            com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
            com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
            com.parks.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
            httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:none\" disabled>") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
         }
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
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_20", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_20, (byte)(8), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6ShowId", GXutil.ltrim( localUtil.ntoc( wcpOAV6ShowId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSHOWID", GXutil.ltrim( localUtil.ntoc( AV6ShowId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm1I2( )
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
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "</form>") ;
         }
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
      return "ShowShowWC" ;
   }

   public String getPgmdesc( )
   {
      return "Show Show WC" ;
   }

   public void wb1I0( )
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
            com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.parks.showshowwc");
         }
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "GridTabMainTable", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divTabletop_Internalname, 1, 0, "px", 0, "px", "TableTopSearch", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-7 col-sm-2 col-sm-offset-1 ViewGridActionsCell", "Right", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group WWViewActions", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 11,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "BtnAdd" ;
         StyleString = "" ;
         com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Agregar", bttBtninsert_Jsonclick, 5, "Agregar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ShowShowWC.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divGridcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 ViewGridCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, divGridtable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.parks.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"20\">") ;
            sStyleString = "" ;
            com.parks.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "ViewGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGrid_Backcolorstyle == 0 )
            {
               subGrid_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
            else
            {
               subGrid_Titlebackstyle = (byte)(1) ;
               if ( subGrid_Backcolorstyle == 1 )
               {
                  subGrid_Titlebackcolor = subGrid_Allbackcolor ;
                  if ( GXutil.len( subGrid_Class) > 0 )
                  {
                     subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGrid_Class) > 0 )
                  {
                     subGrid_Linesclass = subGrid_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Park Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"DescriptionAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Park Name") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Web Site") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Park Address") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ImageAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Park Photo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Country Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Country Name") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "City Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "City Name") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"TextActionAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"TextActionAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridContainer.AddObjectProperty("GridName", "Grid");
         }
         else
         {
            if ( isAjaxCallMode( ) )
            {
               GridContainer = new com.genexus.webpanels.GXWebGrid(context);
            }
            else
            {
               GridContainer.Clear();
            }
            GridContainer.SetWrapped(nGXWrapped);
            GridContainer.AddObjectProperty("GridName", "Grid");
            GridContainer.AddObjectProperty("Header", subGrid_Header);
            GridContainer.AddObjectProperty("Class", "ViewGrid");
            GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("CmpContext", sPrefix);
            GridContainer.AddObjectProperty("InMasterPage", "false");
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A7AmusementParkId, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A8AmusementParkName));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtAmusementParkName_Link));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A9AmusementParkWebSite));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A10AmusementParkAddress);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", httpContext.convertURL( A11AmusementParkPhoto));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A12CountryId, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A13CountryName));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtCountryName_Link));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A25CityName));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV12Update));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV13Delete));
            GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
            GridContainer.AddColumnProperties(GridColumn);
            GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 20 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_20 = (int)(nGXsfl_20_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
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
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtShowId_Internalname, "Show Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtShowId_Internalname, GXutil.ltrim( localUtil.ntoc( A14ShowId, (byte)(4), (byte)(0), ",", "")), ((edtShowId_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A14ShowId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(A14ShowId), "ZZZ9")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtShowId_Jsonclick, 0, "Attribute", "", "", "", "", edtShowId_Visible, edtShowId_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_ShowShowWC.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 20 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start1I2( )
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
            Form.getMeta().addItem("description", "Show Show WC", (short)(0)) ;
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
            strup1I0( ) ;
         }
      }
   }

   public void ws1I2( )
   {
      start1I2( ) ;
      evt1I2( ) ;
   }

   public void evt1I2( )
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
                              strup1I0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup1I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoInsert' */
                                 e111I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup1I0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup1I0( ) ;
                           }
                           sEvt = httpContext.cgiGet( sPrefix+"GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup1I0( ) ;
                           }
                           nGXsfl_20_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_202( ) ;
                           A7AmusementParkId = (short)(localUtil.ctol( httpContext.cgiGet( edtAmusementParkId_Internalname), ",", ".")) ;
                           A8AmusementParkName = httpContext.cgiGet( edtAmusementParkName_Internalname) ;
                           A9AmusementParkWebSite = httpContext.cgiGet( edtAmusementParkWebSite_Internalname) ;
                           A10AmusementParkAddress = httpContext.cgiGet( edtAmusementParkAddress_Internalname) ;
                           A11AmusementParkPhoto = httpContext.cgiGet( edtAmusementParkPhoto_Internalname) ;
                           httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), !bGXsfl_20_Refreshing);
                           httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
                           A12CountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ",", ".")) ;
                           A13CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
                           A24CityId = (short)(localUtil.ctol( httpContext.cgiGet( edtCityId_Internalname), ",", ".")) ;
                           A25CityName = httpContext.cgiGet( edtCityName_Internalname) ;
                           AV12Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV12Update);
                           AV13Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV13Delete);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Start */
                                       e121I2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       e131I2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
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
                                    strup1I0( ) ;
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

   public void we1I2( )
   {
      if ( ! com.parks.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.parks.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm1I2( ) ;
         }
      }
   }

   public void pa1I2( )
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

   public void gxnrgrid_newrow( )
   {
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_202( ) ;
      while ( nGXsfl_20_idx <= nRC_GXsfl_20 )
      {
         sendrow_202( ) ;
         nGXsfl_20_idx = ((subGrid_Islastpage==1)&&(nGXsfl_20_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_20_idx+1) ;
         sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_202( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 short AV6ShowId ,
                                 String AV12Update ,
                                 String AV13Delete ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID_nCurrentRecord = 0 ;
      rf1I2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_AMUSEMENTPARKID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AMUSEMENTPARKID", GXutil.ltrim( localUtil.ntoc( A7AmusementParkId, (byte)(4), (byte)(0), ".", "")));
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
      rf1I2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "ShowShowWC" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_20_Refreshing);
   }

   public void rf1I2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(20) ;
      nGXsfl_20_idx = 1 ;
      sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_202( ) ;
      bGXsfl_20_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "ViewGrid");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_202( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         /* Using cursor H001I2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV6ShowId), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_20_idx = 1 ;
         sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_202( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A14ShowId = H001I2_A14ShowId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A14ShowId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14ShowId), 4, 0));
            A25CityName = H001I2_A25CityName[0] ;
            A24CityId = H001I2_A24CityId[0] ;
            A13CountryName = H001I2_A13CountryName[0] ;
            A12CountryId = H001I2_A12CountryId[0] ;
            A11AmusementParkPhoto = H001I2_A11AmusementParkPhoto[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), !bGXsfl_20_Refreshing);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
            A40000AmusementParkPhoto_GXI = H001I2_A40000AmusementParkPhoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), !bGXsfl_20_Refreshing);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
            A10AmusementParkAddress = H001I2_A10AmusementParkAddress[0] ;
            A9AmusementParkWebSite = H001I2_A9AmusementParkWebSite[0] ;
            A8AmusementParkName = H001I2_A8AmusementParkName[0] ;
            A7AmusementParkId = H001I2_A7AmusementParkId[0] ;
            A24CityId = H001I2_A24CityId[0] ;
            A12CountryId = H001I2_A12CountryId[0] ;
            A11AmusementParkPhoto = H001I2_A11AmusementParkPhoto[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), !bGXsfl_20_Refreshing);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
            A40000AmusementParkPhoto_GXI = H001I2_A40000AmusementParkPhoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AmusementParkPhoto))), !bGXsfl_20_Refreshing);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtAmusementParkPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AmusementParkPhoto), true);
            A10AmusementParkAddress = H001I2_A10AmusementParkAddress[0] ;
            A9AmusementParkWebSite = H001I2_A9AmusementParkWebSite[0] ;
            A8AmusementParkName = H001I2_A8AmusementParkName[0] ;
            A13CountryName = H001I2_A13CountryName[0] ;
            A25CityName = H001I2_A25CityName[0] ;
            e131I2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(20) ;
         wb1I0( ) ;
      }
      bGXsfl_20_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1I2( )
   {
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_AMUSEMENTPARKID"+"_"+sGXsfl_20_idx, getSecureSignedToken( sPrefix+sGXsfl_20_idx, localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9")));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      /* Using cursor H001I3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV6ShowId)});
      GRID_nRecordCount = H001I3_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV6ShowId, AV12Update, AV13Delete, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV6ShowId, AV12Update, AV13Delete, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV6ShowId, AV12Update, AV13Delete, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV6ShowId, AV12Update, AV13Delete, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV6ShowId, AV12Update, AV13Delete, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "ShowShowWC" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1I0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e121I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_20 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_20"), ",", ".")) ;
         wcpOAV6ShowId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV6ShowId"), ",", ".")) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), ",", ".") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), ",", ".")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), ",", ".")) ;
         com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         A14ShowId = (short)(localUtil.ctol( httpContext.cgiGet( edtShowId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A14ShowId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A14ShowId), 4, 0));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e121I2 ();
      if (returnInSub) return;
   }

   public void e121I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.parks.isauthorized(remoteHandle, context).executeUdp( AV17Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.parks.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      subGrid_Rows = 10 ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      AV12Update = "Modificar" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV12Update);
      AV13Delete = "Eliminar" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV13Delete);
      edtShowId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtShowId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtShowId_Visible), 5, 0), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   private void e131I2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      edtavUpdate_Link = formatLink("com.parks.amusementpark", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A7AmusementParkId,4,0))}, new String[] {"Mode","AmusementParkId"})  ;
      edtavDelete_Link = formatLink("com.parks.amusementpark", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A7AmusementParkId,4,0))}, new String[] {"Mode","AmusementParkId"})  ;
      edtAmusementParkName_Link = formatLink("com.parks.viewamusementpark", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A7AmusementParkId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"AmusementParkId","TabCode"})  ;
      edtCountryName_Link = formatLink("com.parks.viewcountry", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A12CountryId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CountryId","TabCode"})  ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(20) ;
      }
      sendrow_202( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_20_Refreshing )
      {
         httpContext.doAjaxLoad(20, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e111I2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.parks.amusementpark", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","AmusementParkId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (com.parks.SdtTransactionContext)new com.parks.SdtTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtTransactionContext_Callerobject( AV17Pgmname );
      AV10TrnContext.setgxTv_SdtTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtTransactionContext_Transactionname( "AmusementPark" );
      AV11TrnContextAtt = (com.parks.SdtTransactionContext_Attribute)new com.parks.SdtTransactionContext_Attribute(remoteHandle, context);
      AV11TrnContextAtt.setgxTv_SdtTransactionContext_Attribute_Attributename( "ShowId" );
      AV11TrnContextAtt.setgxTv_SdtTransactionContext_Attribute_Attributevalue( GXutil.str( AV6ShowId, 4, 0) );
      AV10TrnContext.getgxTv_SdtTransactionContext_Attributes().add(AV11TrnContextAtt, 0);
      AV7Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "TransactionContext", "Parks"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV6ShowId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6ShowId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6ShowId), 4, 0));
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
      pa1I2( ) ;
      ws1I2( ) ;
      we1I2( ) ;
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
      sCtrlAV6ShowId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa1I2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "showshowwc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa1I2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV6ShowId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6ShowId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6ShowId), 4, 0));
      }
      wcpOAV6ShowId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV6ShowId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( AV6ShowId != wcpOAV6ShowId ) ) )
      {
         setjustcreated();
      }
      wcpOAV6ShowId = AV6ShowId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV6ShowId = httpContext.cgiGet( sPrefix+"AV6ShowId_CTRL") ;
      if ( GXutil.len( sCtrlAV6ShowId) > 0 )
      {
         AV6ShowId = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV6ShowId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6ShowId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6ShowId), 4, 0));
      }
      else
      {
         AV6ShowId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV6ShowId_PARM"), ",", ".")) ;
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
      pa1I2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws1I2( ) ;
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
      ws1I2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6ShowId_PARM", GXutil.ltrim( localUtil.ntoc( AV6ShowId, (byte)(4), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV6ShowId)) > 0 )
      {
         com.parks.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6ShowId_CTRL", GXutil.rtrim( sCtrlAV6ShowId));
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
      we1I2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2021102014431634", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("showshowwc.js", "?2021102014431634", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_202( )
   {
      edtAmusementParkId_Internalname = sPrefix+"AMUSEMENTPARKID_"+sGXsfl_20_idx ;
      edtAmusementParkName_Internalname = sPrefix+"AMUSEMENTPARKNAME_"+sGXsfl_20_idx ;
      edtAmusementParkWebSite_Internalname = sPrefix+"AMUSEMENTPARKWEBSITE_"+sGXsfl_20_idx ;
      edtAmusementParkAddress_Internalname = sPrefix+"AMUSEMENTPARKADDRESS_"+sGXsfl_20_idx ;
      edtAmusementParkPhoto_Internalname = sPrefix+"AMUSEMENTPARKPHOTO_"+sGXsfl_20_idx ;
      edtCountryId_Internalname = sPrefix+"COUNTRYID_"+sGXsfl_20_idx ;
      edtCountryName_Internalname = sPrefix+"COUNTRYNAME_"+sGXsfl_20_idx ;
      edtCityId_Internalname = sPrefix+"CITYID_"+sGXsfl_20_idx ;
      edtCityName_Internalname = sPrefix+"CITYNAME_"+sGXsfl_20_idx ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_20_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_20_idx ;
   }

   public void subsflControlProps_fel_202( )
   {
      edtAmusementParkId_Internalname = sPrefix+"AMUSEMENTPARKID_"+sGXsfl_20_fel_idx ;
      edtAmusementParkName_Internalname = sPrefix+"AMUSEMENTPARKNAME_"+sGXsfl_20_fel_idx ;
      edtAmusementParkWebSite_Internalname = sPrefix+"AMUSEMENTPARKWEBSITE_"+sGXsfl_20_fel_idx ;
      edtAmusementParkAddress_Internalname = sPrefix+"AMUSEMENTPARKADDRESS_"+sGXsfl_20_fel_idx ;
      edtAmusementParkPhoto_Internalname = sPrefix+"AMUSEMENTPARKPHOTO_"+sGXsfl_20_fel_idx ;
      edtCountryId_Internalname = sPrefix+"COUNTRYID_"+sGXsfl_20_fel_idx ;
      edtCountryName_Internalname = sPrefix+"COUNTRYNAME_"+sGXsfl_20_fel_idx ;
      edtCityId_Internalname = sPrefix+"CITYID_"+sGXsfl_20_fel_idx ;
      edtCityName_Internalname = sPrefix+"CITYNAME_"+sGXsfl_20_fel_idx ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_20_fel_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_20_fel_idx ;
   }

   public void sendrow_202( )
   {
      subsflControlProps_202( ) ;
      wb1I0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_20_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_20_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"ViewGrid"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_20_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAmusementParkId_Internalname,GXutil.ltrim( localUtil.ntoc( A7AmusementParkId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtAmusementParkId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "DescriptionAttribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAmusementParkName_Internalname,GXutil.rtrim( A8AmusementParkName),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtAmusementParkName_Link,"","","",edtAmusementParkName_Jsonclick,Integer.valueOf(0),"DescriptionAttribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAmusementParkWebSite_Internalname,GXutil.rtrim( A9AmusementParkWebSite),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtAmusementParkWebSite_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAmusementParkAddress_Internalname,A10AmusementParkAddress,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","http://maps.google.com/maps?q="+PrivateUtilities.encodeURL( A10AmusementParkAddress),"_blank","","",edtAmusementParkAddress_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1024),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Address","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "ImageAttribute" ;
         StyleString = "" ;
         A11AmusementParkPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A11AmusementParkPhoto)==0)&&(GXutil.strcmp("", A40000AmusementParkPhoto_GXI)==0))||!(GXutil.strcmp("", A11AmusementParkPhoto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : httpContext.getResourceRelative(A11AmusementParkPhoto)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtAmusementParkPhoto_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn WWOptionalColumn","","","","","","",Integer.valueOf(1),Boolean.valueOf(A11AmusementParkPhoto_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryId_Internalname,GXutil.ltrim( localUtil.ntoc( A12CountryId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A12CountryId), "ZZZ9"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCountryId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryName_Internalname,GXutil.rtrim( A13CountryName),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtCountryName_Link,"","","",edtCountryName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCityId_Internalname,GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A24CityId), "ZZZ9"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCityName_Internalname,GXutil.rtrim( A25CityName),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCityName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "TextActionAttribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV12Update),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","","",edtavUpdate_Jsonclick,Integer.valueOf(0),"TextActionAttribute","",ROClassString,"WWTextActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "TextActionAttribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV13Delete),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","","",edtavDelete_Jsonclick,Integer.valueOf(0),"TextActionAttribute","",ROClassString,"WWTextActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes1I2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_20_idx = ((subGrid_Islastpage==1)&&(nGXsfl_20_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_20_idx+1) ;
         sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_202( ) ;
      }
      /* End function sendrow_202 */
   }

   public void init_default_properties( )
   {
      bttBtninsert_Internalname = sPrefix+"BTNINSERT" ;
      divTabletop_Internalname = sPrefix+"TABLETOP" ;
      edtAmusementParkId_Internalname = sPrefix+"AMUSEMENTPARKID" ;
      edtAmusementParkName_Internalname = sPrefix+"AMUSEMENTPARKNAME" ;
      edtAmusementParkWebSite_Internalname = sPrefix+"AMUSEMENTPARKWEBSITE" ;
      edtAmusementParkAddress_Internalname = sPrefix+"AMUSEMENTPARKADDRESS" ;
      edtAmusementParkPhoto_Internalname = sPrefix+"AMUSEMENTPARKPHOTO" ;
      edtCountryId_Internalname = sPrefix+"COUNTRYID" ;
      edtCountryName_Internalname = sPrefix+"COUNTRYNAME" ;
      edtCityId_Internalname = sPrefix+"CITYID" ;
      edtCityName_Internalname = sPrefix+"CITYNAME" ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE" ;
      edtavDelete_Internalname = sPrefix+"vDELETE" ;
      divGridtable_Internalname = sPrefix+"GRIDTABLE" ;
      divGridcell_Internalname = sPrefix+"GRIDCELL" ;
      edtShowId_Internalname = sPrefix+"SHOWID" ;
      divMaintable_Internalname = sPrefix+"MAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGrid_Internalname = sPrefix+"GRID" ;
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
      edtavDelete_Jsonclick = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtCityName_Jsonclick = "" ;
      edtCityId_Jsonclick = "" ;
      edtCountryName_Jsonclick = "" ;
      edtCountryId_Jsonclick = "" ;
      edtAmusementParkAddress_Jsonclick = "" ;
      edtAmusementParkWebSite_Jsonclick = "" ;
      edtAmusementParkName_Jsonclick = "" ;
      edtAmusementParkId_Jsonclick = "" ;
      edtShowId_Jsonclick = "" ;
      edtShowId_Enabled = 0 ;
      edtShowId_Visible = 1 ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      edtavDelete_Link = "" ;
      edtavUpdate_Link = "" ;
      edtCountryName_Link = "" ;
      edtAmusementParkName_Link = "" ;
      subGrid_Header = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Class = "ViewGrid" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV6ShowId',fld:'vSHOWID',pic:'ZZZ9'},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''},{av:'sPrefix'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID.LOAD","{handler:'e131I2',iparms:[{av:'A7AmusementParkId',fld:'AMUSEMENTPARKID',pic:'ZZZ9',hsh:true},{av:'A12CountryId',fld:'COUNTRYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtAmusementParkName_Link',ctrl:'AMUSEMENTPARKNAME',prop:'Link'},{av:'edtCountryName_Link',ctrl:'COUNTRYNAME',prop:'Link'}]}");
      setEventMetadata("'DOINSERT'","{handler:'e111I2',iparms:[{av:'A7AmusementParkId',fld:'AMUSEMENTPARKID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV6ShowId',fld:'vSHOWID',pic:'ZZZ9'},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''},{av:'sPrefix'}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV6ShowId',fld:'vSHOWID',pic:'ZZZ9'},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''},{av:'sPrefix'}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV6ShowId',fld:'vSHOWID',pic:'ZZZ9'},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''},{av:'sPrefix'}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV6ShowId',fld:'vSHOWID',pic:'ZZZ9'},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''},{av:'sPrefix'}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALID_AMUSEMENTPARKID","{handler:'valid_Amusementparkid',iparms:[]");
      setEventMetadata("VALID_AMUSEMENTPARKID",",oparms:[]}");
      setEventMetadata("VALID_COUNTRYID","{handler:'valid_Countryid',iparms:[]");
      setEventMetadata("VALID_COUNTRYID",",oparms:[]}");
      setEventMetadata("VALID_CITYID","{handler:'valid_Cityid',iparms:[]");
      setEventMetadata("VALID_CITYID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Delete',iparms:[]");
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
      sPrefix = "" ;
      AV12Update = "" ;
      AV13Delete = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtninsert_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      A8AmusementParkName = "" ;
      A9AmusementParkWebSite = "" ;
      A10AmusementParkAddress = "" ;
      A11AmusementParkPhoto = "" ;
      A13CountryName = "" ;
      A25CityName = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A40000AmusementParkPhoto_GXI = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      H001I2_A14ShowId = new short[1] ;
      H001I2_A25CityName = new String[] {""} ;
      H001I2_A24CityId = new short[1] ;
      H001I2_A13CountryName = new String[] {""} ;
      H001I2_A12CountryId = new short[1] ;
      H001I2_A11AmusementParkPhoto = new String[] {""} ;
      H001I2_A40000AmusementParkPhoto_GXI = new String[] {""} ;
      H001I2_A10AmusementParkAddress = new String[] {""} ;
      H001I2_A9AmusementParkWebSite = new String[] {""} ;
      H001I2_A8AmusementParkName = new String[] {""} ;
      H001I2_A7AmusementParkId = new short[1] ;
      H001I3_AGRID_nRecordCount = new long[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV10TrnContext = new com.parks.SdtTransactionContext(remoteHandle, context);
      AV8HTTPRequest = httpContext.getHttpRequest();
      AV11TrnContextAtt = new com.parks.SdtTransactionContext_Attribute(remoteHandle, context);
      AV7Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV6ShowId = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.showshowwc__default(),
         new Object[] {
             new Object[] {
            H001I2_A14ShowId, H001I2_A25CityName, H001I2_A24CityId, H001I2_A13CountryName, H001I2_A12CountryId, H001I2_A11AmusementParkPhoto, H001I2_A40000AmusementParkPhoto_GXI, H001I2_A10AmusementParkAddress, H001I2_A9AmusementParkWebSite, H001I2_A8AmusementParkName,
            H001I2_A7AmusementParkId
            }
            , new Object[] {
            H001I3_AGRID_nRecordCount
            }
         }
      );
      AV17Pgmname = "ShowShowWC" ;
      /* GeneXus formulas. */
      AV17Pgmname = "ShowShowWC" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nGXWrapped ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGrid_Backstyle ;
   private short wcpOAV6ShowId ;
   private short AV6ShowId ;
   private short wbEnd ;
   private short wbStart ;
   private short A7AmusementParkId ;
   private short A12CountryId ;
   private short A24CityId ;
   private short A14ShowId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_20 ;
   private int nGXsfl_20_idx=1 ;
   private int subGrid_Rows ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int edtShowId_Enabled ;
   private int edtShowId_Visible ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_20_idx="0001" ;
   private String AV12Update ;
   private String AV13Delete ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divMaintable_Internalname ;
   private String divTabletop_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtninsert_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String divGridcell_Internalname ;
   private String divGridtable_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String subGrid_Header ;
   private String A8AmusementParkName ;
   private String edtAmusementParkName_Link ;
   private String A9AmusementParkWebSite ;
   private String A13CountryName ;
   private String edtCountryName_Link ;
   private String A25CityName ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtShowId_Internalname ;
   private String edtShowId_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtAmusementParkId_Internalname ;
   private String edtAmusementParkName_Internalname ;
   private String edtAmusementParkWebSite_Internalname ;
   private String edtAmusementParkAddress_Internalname ;
   private String edtAmusementParkPhoto_Internalname ;
   private String edtCountryId_Internalname ;
   private String edtCountryName_Internalname ;
   private String edtCityId_Internalname ;
   private String edtCityName_Internalname ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String sCtrlAV6ShowId ;
   private String sGXsfl_20_fel_idx="0001" ;
   private String ROClassString ;
   private String edtAmusementParkId_Jsonclick ;
   private String edtAmusementParkName_Jsonclick ;
   private String edtAmusementParkWebSite_Jsonclick ;
   private String edtAmusementParkAddress_Jsonclick ;
   private String sImgUrl ;
   private String edtCountryId_Jsonclick ;
   private String edtCountryName_Jsonclick ;
   private String edtCityId_Jsonclick ;
   private String edtCityName_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_20_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean A11AmusementParkPhoto_IsBlob ;
   private String A10AmusementParkAddress ;
   private String A40000AmusementParkPhoto_GXI ;
   private String A11AmusementParkPhoto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private IDataStoreProvider pr_default ;
   private short[] H001I2_A14ShowId ;
   private String[] H001I2_A25CityName ;
   private short[] H001I2_A24CityId ;
   private String[] H001I2_A13CountryName ;
   private short[] H001I2_A12CountryId ;
   private String[] H001I2_A11AmusementParkPhoto ;
   private String[] H001I2_A40000AmusementParkPhoto_GXI ;
   private String[] H001I2_A10AmusementParkAddress ;
   private String[] H001I2_A9AmusementParkWebSite ;
   private String[] H001I2_A8AmusementParkName ;
   private short[] H001I2_A7AmusementParkId ;
   private long[] H001I3_AGRID_nRecordCount ;
   private com.genexus.webpanels.WebSession AV7Session ;
   private com.parks.SdtTransactionContext AV10TrnContext ;
   private com.parks.SdtTransactionContext_Attribute AV11TrnContextAtt ;
}

final  class showshowwc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001I2", "SELECT T1.`ShowId`, T4.`CityName`, T2.`CityId`, T3.`CountryName`, T2.`CountryId`, T2.`AmusementParkPhoto`, T2.`AmusementParkPhoto_GXI`, T2.`AmusementParkAddress`, T2.`AmusementParkWebSite`, T2.`AmusementParkName`, T1.`AmusementParkId` FROM (((`AmusementParkShow` T1 INNER JOIN `AmusementPark` T2 ON T2.`AmusementParkId` = T1.`AmusementParkId`) INNER JOIN `Country` T3 ON T3.`CountryId` = T2.`CountryId`) INNER JOIN `CountryCity` T4 ON T4.`CountryId` = T2.`CountryId` AND T4.`CityId` = T2.`CityId`) WHERE T1.`ShowId` = ? ORDER BY T1.`ShowId`  LIMIT ?, ?",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001I3", "SELECT COUNT(*) FROM (((`AmusementParkShow` T1 INNER JOIN `AmusementPark` T2 ON T2.`AmusementParkId` = T1.`AmusementParkId`) INNER JOIN `Country` T3 ON T3.`CountryId` = T2.`CountryId`) INNER JOIN `CountryCity` T4 ON T4.`CountryId` = T2.`CountryId` AND T4.`CityId` = T2.`CityId`) WHERE T1.`ShowId` = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 50);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getMultimediaFile(6, rslt.getVarchar(7));
               ((String[]) buf[6])[0] = rslt.getMultimediaUri(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 60);
               ((String[]) buf[9])[0] = rslt.getString(10, 50);
               ((short[]) buf[10])[0] = rslt.getShort(11);
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
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}


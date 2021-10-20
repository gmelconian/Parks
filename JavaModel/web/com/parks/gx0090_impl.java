package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gx0090_impl extends GXDataArea
{
   public gx0090_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gx0090_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gx0090_impl.class ));
   }

   public gx0090_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "pTechnicianId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "pTechnicianId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "pTechnicianId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid1") == 0 )
         {
            nRC_GXsfl_74 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_74"))) ;
            nGXsfl_74_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_74_idx"))) ;
            sGXsfl_74_idx = httpContext.GetPar( "sGXsfl_74_idx") ;
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
            AV6cTechnicianId = (short)(GXutil.lval( httpContext.GetPar( "cTechnicianId"))) ;
            AV7cTechnicianName = httpContext.GetPar( "cTechnicianName") ;
            AV8cTechnicianLastName = httpContext.GetPar( "cTechnicianLastName") ;
            AV9cTechnicianPhone = httpContext.GetPar( "cTechnicianPhone") ;
            AV10cCountryId = (short)(GXutil.lval( httpContext.GetPar( "cCountryId"))) ;
            AV11cCityId = (short)(GXutil.lval( httpContext.GetPar( "cCityId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid1_refresh( subGrid1_Rows, AV6cTechnicianId, AV7cTechnicianName, AV8cTechnicianLastName, AV9cTechnicianPhone, AV10cCountryId, AV11cCityId) ;
            com.parks.GxWebStd.gx_hidden_field( httpContext, "ADVANCEDCONTAINER_Class", GXutil.rtrim( divAdvancedcontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "BTNTOGGLE_Class", GXutil.rtrim( bttBtntoggle_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANIDFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianidfiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANNAMEFILTERCONTAINER_Class", GXutil.rtrim( divTechniciannamefiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANLASTNAMEFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianlastnamefiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANPHONEFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianphonefiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "COUNTRYIDFILTERCONTAINER_Class", GXutil.rtrim( divCountryidfiltercontainer_Class));
            com.parks.GxWebStd.gx_hidden_field( httpContext, "CITYIDFILTERCONTAINER_Class", GXutil.rtrim( divCityidfiltercontainer_Class));
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
            AV12pTechnicianId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12pTechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12pTechnicianId), 4, 0));
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
      pa142( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start142( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20211071155114", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.parks.gx0090", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV12pTechnicianId,4,0))}, new String[] {"pTechnicianId"}) +"\">") ;
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
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCTECHNICIANID", GXutil.ltrim( localUtil.ntoc( AV6cTechnicianId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCTECHNICIANNAME", GXutil.rtrim( AV7cTechnicianName));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCTECHNICIANLASTNAME", GXutil.rtrim( AV8cTechnicianLastName));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCTECHNICIANPHONE", GXutil.rtrim( AV9cTechnicianPhone));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCCOUNTRYID", GXutil.ltrim( localUtil.ntoc( AV10cCountryId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GXH_vCCITYID", GXutil.ltrim( localUtil.ntoc( AV11cCityId, (byte)(4), (byte)(0), ",", "")));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.parks.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_74", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_74, (byte)(8), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "vPTECHNICIANID", GXutil.ltrim( localUtil.ntoc( AV12pTechnicianId, (byte)(4), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "ADVANCEDCONTAINER_Class", GXutil.rtrim( divAdvancedcontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "BTNTOGGLE_Class", GXutil.rtrim( bttBtntoggle_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANIDFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianidfiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANNAMEFILTERCONTAINER_Class", GXutil.rtrim( divTechniciannamefiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANLASTNAMEFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianlastnamefiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANPHONEFILTERCONTAINER_Class", GXutil.rtrim( divTechnicianphonefiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "COUNTRYIDFILTERCONTAINER_Class", GXutil.rtrim( divCountryidfiltercontainer_Class));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "CITYIDFILTERCONTAINER_Class", GXutil.rtrim( divCityidfiltercontainer_Class));
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
         we142( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt142( ) ;
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
      return formatLink("com.parks.gx0090", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV12pTechnicianId,4,0))}, new String[] {"pTechnicianId"})  ;
   }

   public String getPgmname( )
   {
      return "Gx0090" ;
   }

   public String getPgmdesc( )
   {
      return "Selection List Technician" ;
   }

   public void wb140( )
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
         com.parks.GxWebStd.gx_div_start( httpContext, divTechnicianidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divTechnicianidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLbltechnicianidfilter_Internalname, "Technician Id", "", "", lblLbltechnicianidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e11141_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0090.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'" + sGXsfl_74_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCtechnicianid_Internalname, GXutil.ltrim( localUtil.ntoc( AV6cTechnicianId, (byte)(4), (byte)(0), ",", "")), ((edtavCtechnicianid_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV6cTechnicianId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(AV6cTechnicianId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,16);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCtechnicianid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCtechnicianid_Visible, edtavCtechnicianid_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0090.htm");
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
         com.parks.GxWebStd.gx_div_start( httpContext, divTechniciannamefiltercontainer_Internalname, 1, 0, "px", 0, "px", divTechniciannamefiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLbltechniciannamefilter_Internalname, "Technician Name", "", "", lblLbltechniciannamefilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e12141_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0090.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCtechnicianname_Internalname, "Technician Name", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'" + sGXsfl_74_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCtechnicianname_Internalname, GXutil.rtrim( AV7cTechnicianName), GXutil.rtrim( localUtil.format( AV7cTechnicianName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCtechnicianname_Jsonclick, 0, "Attribute", "", "", "", "", edtavCtechnicianname_Visible, edtavCtechnicianname_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Gx0090.htm");
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
         com.parks.GxWebStd.gx_div_start( httpContext, divTechnicianlastnamefiltercontainer_Internalname, 1, 0, "px", 0, "px", divTechnicianlastnamefiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLbltechnicianlastnamefilter_Internalname, "Technician Last Name", "", "", lblLbltechnicianlastnamefilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e13141_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0090.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCtechnicianlastname_Internalname, "Technician Last Name", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'" + sGXsfl_74_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCtechnicianlastname_Internalname, GXutil.rtrim( AV8cTechnicianLastName), GXutil.rtrim( localUtil.format( AV8cTechnicianLastName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,36);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCtechnicianlastname_Jsonclick, 0, "Attribute", "", "", "", "", edtavCtechnicianlastname_Visible, edtavCtechnicianlastname_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Gx0090.htm");
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
         com.parks.GxWebStd.gx_div_start( httpContext, divTechnicianphonefiltercontainer_Internalname, 1, 0, "px", 0, "px", divTechnicianphonefiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLbltechnicianphonefilter_Internalname, "Technician Phone", "", "", lblLbltechnicianphonefilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e14141_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0090.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCtechnicianphone_Internalname, "Technician Phone", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'" + sGXsfl_74_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCtechnicianphone_Internalname, GXutil.rtrim( AV9cTechnicianPhone), GXutil.rtrim( localUtil.format( AV9cTechnicianPhone, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,46);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCtechnicianphone_Jsonclick, 0, "Attribute", "", "", "", "", edtavCtechnicianphone_Visible, edtavCtechnicianphone_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_Gx0090.htm");
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
         com.parks.GxWebStd.gx_div_start( httpContext, divCountryidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divCountryidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLblcountryidfilter_Internalname, "Country Id", "", "", lblLblcountryidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e15141_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0090.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCcountryid_Internalname, "Country Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'" + sGXsfl_74_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCcountryid_Internalname, GXutil.ltrim( localUtil.ntoc( AV10cCountryId, (byte)(4), (byte)(0), ",", "")), ((edtavCcountryid_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV10cCountryId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(AV10cCountryId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCcountryid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCcountryid_Visible, edtavCcountryid_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0090.htm");
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
         com.parks.GxWebStd.gx_div_start( httpContext, divCityidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divCityidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.parks.GxWebStd.gx_label_ctrl( httpContext, lblLblcityidfilter_Internalname, "City Id", "", "", lblLblcityidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e16141_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0090.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.parks.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.parks.GxWebStd.gx_label_element( httpContext, edtavCcityid_Internalname, "City Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'" + sGXsfl_74_idx + "',0)\"" ;
         com.parks.GxWebStd.gx_single_line_edit( httpContext, edtavCcityid_Internalname, GXutil.ltrim( localUtil.ntoc( AV11cCityId, (byte)(4), (byte)(0), ",", "")), ((edtavCcityid_Enabled!=0) ? GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV11cCityId), "ZZZ9")) : localUtil.format( DecimalUtil.doubleToDec(AV11cCityId), "ZZZ9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCcityid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCcityid_Visible, edtavCcityid_Enabled, 0, "number", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0090.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
         ClassString = bttBtntoggle_Class ;
         StyleString = "" ;
         com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtntoggle_Internalname, "gx.evt.setGridEvt("+GXutil.str( 74, 2, 0)+","+"null"+");", "|||", bttBtntoggle_Jsonclick, 7, "|||", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e17141_client"+"'", TempTags, "", 2, "HLP_Gx0090.htm");
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
            httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"74\">") ;
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
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"DescriptionAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Name") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Last Name") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Phone") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Country Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "City Id") ;
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
            Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.rtrim( A31TechnicianName));
            Grid1Column.AddObjectProperty("Link", GXutil.rtrim( edtTechnicianName_Link));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.rtrim( A32TechnicianLastName));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.rtrim( A33TechnicianPhone));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A12CountryId, (byte)(4), (byte)(0), ".", "")));
            Grid1Container.AddColumnProperties(Grid1Column);
            Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ".", "")));
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
      if ( wbEnd == 74 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_74 = (int)(nGXsfl_74_idx-1) ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
         ClassString = "BtnCancel" ;
         StyleString = "" ;
         com.parks.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 74, 2, 0)+","+"null"+");", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Gx0090.htm");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.parks.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 74 )
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

   public void start142( )
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
         Form.getMeta().addItem("description", "Selection List Technician", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup140( ) ;
   }

   public void ws142( )
   {
      start142( ) ;
      evt142( ) ;
   }

   public void evt142( )
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
                           nGXsfl_74_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_74_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_74_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_742( ) ;
                           AV5LinkSelection = httpContext.cgiGet( edtavLinkselection_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavLinkselection_Internalname, "Bitmap", ((GXutil.strcmp("", AV5LinkSelection)==0) ? AV16Linkselection_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV5LinkSelection))), !bGXsfl_74_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavLinkselection_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV5LinkSelection), true);
                           A30TechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( edtTechnicianId_Internalname), ",", ".")) ;
                           A31TechnicianName = httpContext.cgiGet( edtTechnicianName_Internalname) ;
                           A32TechnicianLastName = httpContext.cgiGet( edtTechnicianLastName_Internalname) ;
                           A33TechnicianPhone = httpContext.cgiGet( edtTechnicianPhone_Internalname) ;
                           A12CountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ",", ".")) ;
                           A24CityId = (short)(localUtil.ctol( httpContext.cgiGet( edtCityId_Internalname), ",", ".")) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18142 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e19142 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Ctechnicianid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCTECHNICIANID"), ",", ".") != AV6cTechnicianId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ctechnicianname Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCTECHNICIANNAME"), AV7cTechnicianName) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ctechnicianlastname Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCTECHNICIANLASTNAME"), AV8cTechnicianLastName) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ctechnicianphone Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCTECHNICIANPHONE"), AV9cTechnicianPhone) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ccountryid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCOUNTRYID"), ",", ".") != AV10cCountryId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ccityid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCITYID"), ",", ".") != AV11cCityId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    if ( ! Rfr0gs )
                                    {
                                       /* Execute user event: Enter */
                                       e20142 ();
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

   public void we142( )
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

   public void pa142( )
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
      subsflControlProps_742( ) ;
      while ( nGXsfl_74_idx <= nRC_GXsfl_74 )
      {
         sendrow_742( ) ;
         nGXsfl_74_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_74_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_74_idx+1) ;
         sGXsfl_74_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_74_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_742( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( int subGrid1_Rows ,
                                  short AV6cTechnicianId ,
                                  String AV7cTechnicianName ,
                                  String AV8cTechnicianLastName ,
                                  String AV9cTechnicianPhone ,
                                  short AV10cCountryId ,
                                  short AV11cCityId )
   {
      initialize_formulas( ) ;
      com.parks.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID1_nCurrentRecord = 0 ;
      rf142( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid1_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_TECHNICIANID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A30TechnicianId), "ZZZ9")));
      com.parks.GxWebStd.gx_hidden_field( httpContext, "TECHNICIANID", GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ".", "")));
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
      rf142( ) ;
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

   public void rf142( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(74) ;
      nGXsfl_74_idx = 1 ;
      sGXsfl_74_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_74_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_742( ) ;
      bGXsfl_74_Refreshing = true ;
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
         subsflControlProps_742( ) ;
         GXPagingFrom2 = (int)(GRID1_nFirstRecordOnPage) ;
         GXPagingTo2 = (int)(subgrid1_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV7cTechnicianName ,
                                              AV8cTechnicianLastName ,
                                              AV9cTechnicianPhone ,
                                              Short.valueOf(AV10cCountryId) ,
                                              Short.valueOf(AV11cCityId) ,
                                              A31TechnicianName ,
                                              A32TechnicianLastName ,
                                              A33TechnicianPhone ,
                                              Short.valueOf(A12CountryId) ,
                                              Short.valueOf(A24CityId) ,
                                              Short.valueOf(AV6cTechnicianId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.SHORT
                                              }
         });
         lV7cTechnicianName = GXutil.padr( GXutil.rtrim( AV7cTechnicianName), 50, "%") ;
         lV8cTechnicianLastName = GXutil.padr( GXutil.rtrim( AV8cTechnicianLastName), 20, "%") ;
         lV9cTechnicianPhone = GXutil.padr( GXutil.rtrim( AV9cTechnicianPhone), 20, "%") ;
         /* Using cursor H00142 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV6cTechnicianId), lV7cTechnicianName, lV8cTechnicianLastName, lV9cTechnicianPhone, Short.valueOf(AV10cCountryId), Short.valueOf(AV11cCityId), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_74_idx = 1 ;
         sGXsfl_74_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_74_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_742( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( GRID1_nCurrentRecord < subgrid1_fnc_recordsperpage( ) ) ) )
         {
            A24CityId = H00142_A24CityId[0] ;
            A12CountryId = H00142_A12CountryId[0] ;
            A33TechnicianPhone = H00142_A33TechnicianPhone[0] ;
            A32TechnicianLastName = H00142_A32TechnicianLastName[0] ;
            A31TechnicianName = H00142_A31TechnicianName[0] ;
            A30TechnicianId = H00142_A30TechnicianId[0] ;
            /* Execute user event: Load */
            e19142 ();
            pr_default.readNext(0);
         }
         GRID1_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.parks.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(74) ;
         wb140( ) ;
      }
      bGXsfl_74_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes142( )
   {
      com.parks.GxWebStd.gx_hidden_field( httpContext, "gxhash_TECHNICIANID"+"_"+sGXsfl_74_idx, getSecureSignedToken( sGXsfl_74_idx, localUtil.format( DecimalUtil.doubleToDec(A30TechnicianId), "ZZZ9")));
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
                                           AV7cTechnicianName ,
                                           AV8cTechnicianLastName ,
                                           AV9cTechnicianPhone ,
                                           Short.valueOf(AV10cCountryId) ,
                                           Short.valueOf(AV11cCityId) ,
                                           A31TechnicianName ,
                                           A32TechnicianLastName ,
                                           A33TechnicianPhone ,
                                           Short.valueOf(A12CountryId) ,
                                           Short.valueOf(A24CityId) ,
                                           Short.valueOf(AV6cTechnicianId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT
                                           }
      });
      lV7cTechnicianName = GXutil.padr( GXutil.rtrim( AV7cTechnicianName), 50, "%") ;
      lV8cTechnicianLastName = GXutil.padr( GXutil.rtrim( AV8cTechnicianLastName), 20, "%") ;
      lV9cTechnicianPhone = GXutil.padr( GXutil.rtrim( AV9cTechnicianPhone), 20, "%") ;
      /* Using cursor H00143 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV6cTechnicianId), lV7cTechnicianName, lV8cTechnicianLastName, lV9cTechnicianPhone, Short.valueOf(AV10cCountryId), Short.valueOf(AV11cCityId)});
      GRID1_nRecordCount = H00143_AGRID1_nRecordCount[0] ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV6cTechnicianId, AV7cTechnicianName, AV8cTechnicianLastName, AV9cTechnicianPhone, AV10cCountryId, AV11cCityId) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV6cTechnicianId, AV7cTechnicianName, AV8cTechnicianLastName, AV9cTechnicianPhone, AV10cCountryId, AV11cCityId) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV6cTechnicianId, AV7cTechnicianName, AV8cTechnicianLastName, AV9cTechnicianPhone, AV10cCountryId, AV11cCityId) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV6cTechnicianId, AV7cTechnicianName, AV8cTechnicianLastName, AV9cTechnicianPhone, AV10cCountryId, AV11cCityId) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV6cTechnicianId, AV7cTechnicianName, AV8cTechnicianLastName, AV9cTechnicianPhone, AV10cCountryId, AV11cCityId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup140( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18142 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_74 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_74"), ",", ".")) ;
         GRID1_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID1_nFirstRecordOnPage"), ",", ".") ;
         GRID1_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID1_nEOF"), ",", ".")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCtechnicianid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCtechnicianid_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCTECHNICIANID");
            GX_FocusControl = edtavCtechnicianid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV6cTechnicianId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6cTechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6cTechnicianId), 4, 0));
         }
         else
         {
            AV6cTechnicianId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCtechnicianid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6cTechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6cTechnicianId), 4, 0));
         }
         AV7cTechnicianName = httpContext.cgiGet( edtavCtechnicianname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7cTechnicianName", AV7cTechnicianName);
         AV8cTechnicianLastName = httpContext.cgiGet( edtavCtechnicianlastname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8cTechnicianLastName", AV8cTechnicianLastName);
         AV9cTechnicianPhone = httpContext.cgiGet( edtavCtechnicianphone_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9cTechnicianPhone", AV9cTechnicianPhone);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCcountryid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCcountryid_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCCOUNTRYID");
            GX_FocusControl = edtavCcountryid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV10cCountryId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10cCountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10cCountryId), 4, 0));
         }
         else
         {
            AV10cCountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCcountryid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10cCountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10cCountryId), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCcityid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCcityid_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCCITYID");
            GX_FocusControl = edtavCcityid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11cCityId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11cCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11cCityId), 4, 0));
         }
         else
         {
            AV11cCityId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCcityid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11cCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11cCityId), 4, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCTECHNICIANID"), ",", ".") != AV6cTechnicianId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCTECHNICIANNAME"), AV7cTechnicianName) != 0 )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCTECHNICIANLASTNAME"), AV8cTechnicianLastName) != 0 )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCTECHNICIANPHONE"), AV9cTechnicianPhone) != 0 )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCOUNTRYID"), ",", ".") != AV10cCountryId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCITYID"), ",", ".") != AV11cCityId )
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
      e18142 ();
      if (returnInSub) return;
   }

   public void e18142( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setCaption( GXutil.format( "Lista de Selección %1", "Technician", "", "", "", "", "", "", "", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      AV13ADVANCED_LABEL_TEMPLATE = "%1 <strong>%2</strong>" ;
   }

   private void e19142( )
   {
      /* Load Routine */
      returnInSub = false ;
      AV5LinkSelection = context.getHttpContext().getImagePath( "3914535b-0c03-44c5-9538-906a99cdd2bc", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavLinkselection_Internalname, AV5LinkSelection);
      AV16Linkselection_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "3914535b-0c03-44c5-9538-906a99cdd2bc", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      sendrow_742( ) ;
      GRID1_nCurrentRecord = (long)(GRID1_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_74_Refreshing )
      {
         httpContext.doAjaxLoad(74, Grid1Row);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e20142 ();
      if (returnInSub) return;
   }

   public void e20142( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV12pTechnicianId = A30TechnicianId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12pTechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12pTechnicianId), 4, 0));
      httpContext.setWebReturnParms(new Object[] {Short.valueOf(AV12pTechnicianId)});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV12pTechnicianId"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV12pTechnicianId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12pTechnicianId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12pTechnicianId), 4, 0));
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
      pa142( ) ;
      ws142( ) ;
      we142( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202110711551179", true, true);
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
      httpContext.AddJavascriptSource("gx0090.js", "?202110711551179", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_742( )
   {
      edtavLinkselection_Internalname = "vLINKSELECTION_"+sGXsfl_74_idx ;
      edtTechnicianId_Internalname = "TECHNICIANID_"+sGXsfl_74_idx ;
      edtTechnicianName_Internalname = "TECHNICIANNAME_"+sGXsfl_74_idx ;
      edtTechnicianLastName_Internalname = "TECHNICIANLASTNAME_"+sGXsfl_74_idx ;
      edtTechnicianPhone_Internalname = "TECHNICIANPHONE_"+sGXsfl_74_idx ;
      edtCountryId_Internalname = "COUNTRYID_"+sGXsfl_74_idx ;
      edtCityId_Internalname = "CITYID_"+sGXsfl_74_idx ;
   }

   public void subsflControlProps_fel_742( )
   {
      edtavLinkselection_Internalname = "vLINKSELECTION_"+sGXsfl_74_fel_idx ;
      edtTechnicianId_Internalname = "TECHNICIANID_"+sGXsfl_74_fel_idx ;
      edtTechnicianName_Internalname = "TECHNICIANNAME_"+sGXsfl_74_fel_idx ;
      edtTechnicianLastName_Internalname = "TECHNICIANLASTNAME_"+sGXsfl_74_fel_idx ;
      edtTechnicianPhone_Internalname = "TECHNICIANPHONE_"+sGXsfl_74_fel_idx ;
      edtCountryId_Internalname = "COUNTRYID_"+sGXsfl_74_fel_idx ;
      edtCityId_Internalname = "CITYID_"+sGXsfl_74_fel_idx ;
   }

   public void sendrow_742( )
   {
      subsflControlProps_742( ) ;
      wb140( ) ;
      if ( ( 10 * 1 == 0 ) || ( nGXsfl_74_idx <= subgrid1_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_74_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_74_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         edtavLinkselection_Link = "javascript:gx.popup.gxReturn(["+"'"+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ",", "")))+"'"+"]);" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLinkselection_Internalname, "Link", edtavLinkselection_Link, !bGXsfl_74_Refreshing);
         ClassString = "SelectionAttribute" ;
         StyleString = "" ;
         AV5LinkSelection_IsBlob = (boolean)(((GXutil.strcmp("", AV5LinkSelection)==0)&&(GXutil.strcmp("", AV16Linkselection_GXI)==0))||!(GXutil.strcmp("", AV5LinkSelection)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV5LinkSelection)==0) ? AV16Linkselection_GXI : httpContext.getResourceRelative(AV5LinkSelection)) ;
         Grid1Row.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavLinkselection_Internalname,sImgUrl,edtavLinkselection_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWActionColumn","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV5LinkSelection_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTechnicianId_Internalname,GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A30TechnicianId), "ZZZ9"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTechnicianId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(74),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "DescriptionAttribute" ;
         edtTechnicianName_Link = "javascript:gx.popup.gxReturn(["+"'"+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A30TechnicianId, (byte)(4), (byte)(0), ",", "")))+"'"+"]);" ;
         httpContext.ajax_rsp_assign_prop("", false, edtTechnicianName_Internalname, "Link", edtTechnicianName_Link, !bGXsfl_74_Refreshing);
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTechnicianName_Internalname,GXutil.rtrim( A31TechnicianName),"","","'"+""+"'"+",false,"+"'"+""+"'",edtTechnicianName_Link,"","","",edtTechnicianName_Jsonclick,Integer.valueOf(0),"DescriptionAttribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(74),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTechnicianLastName_Internalname,GXutil.rtrim( A32TechnicianLastName),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTechnicianLastName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(74),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"LastName","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         if ( httpContext.isSmartDevice( ) )
         {
            gxphoneLink = "tel:" + GXutil.rtrim( A33TechnicianPhone) ;
         }
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTechnicianPhone_Internalname,GXutil.rtrim( A33TechnicianPhone),"","","'"+""+"'"+",false,"+"'"+""+"'",gxphoneLink,"","","",edtTechnicianPhone_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"tel","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(74),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Phone","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryId_Internalname,GXutil.ltrim( localUtil.ntoc( A12CountryId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A12CountryId), "ZZZ9"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(74),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCityId_Internalname,GXutil.ltrim( localUtil.ntoc( A24CityId, (byte)(4), (byte)(0), ",", "")),localUtil.format( DecimalUtil.doubleToDec(A24CityId), "ZZZ9"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"number","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(74),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes142( ) ;
         Grid1Container.AddRow(Grid1Row);
         nGXsfl_74_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_74_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_74_idx+1) ;
         sGXsfl_74_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_74_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_742( ) ;
      }
      /* End function sendrow_742 */
   }

   public void init_default_properties( )
   {
      lblLbltechnicianidfilter_Internalname = "LBLTECHNICIANIDFILTER" ;
      edtavCtechnicianid_Internalname = "vCTECHNICIANID" ;
      divTechnicianidfiltercontainer_Internalname = "TECHNICIANIDFILTERCONTAINER" ;
      lblLbltechniciannamefilter_Internalname = "LBLTECHNICIANNAMEFILTER" ;
      edtavCtechnicianname_Internalname = "vCTECHNICIANNAME" ;
      divTechniciannamefiltercontainer_Internalname = "TECHNICIANNAMEFILTERCONTAINER" ;
      lblLbltechnicianlastnamefilter_Internalname = "LBLTECHNICIANLASTNAMEFILTER" ;
      edtavCtechnicianlastname_Internalname = "vCTECHNICIANLASTNAME" ;
      divTechnicianlastnamefiltercontainer_Internalname = "TECHNICIANLASTNAMEFILTERCONTAINER" ;
      lblLbltechnicianphonefilter_Internalname = "LBLTECHNICIANPHONEFILTER" ;
      edtavCtechnicianphone_Internalname = "vCTECHNICIANPHONE" ;
      divTechnicianphonefiltercontainer_Internalname = "TECHNICIANPHONEFILTERCONTAINER" ;
      lblLblcountryidfilter_Internalname = "LBLCOUNTRYIDFILTER" ;
      edtavCcountryid_Internalname = "vCCOUNTRYID" ;
      divCountryidfiltercontainer_Internalname = "COUNTRYIDFILTERCONTAINER" ;
      lblLblcityidfilter_Internalname = "LBLCITYIDFILTER" ;
      edtavCcityid_Internalname = "vCCITYID" ;
      divCityidfiltercontainer_Internalname = "CITYIDFILTERCONTAINER" ;
      divAdvancedcontainer_Internalname = "ADVANCEDCONTAINER" ;
      bttBtntoggle_Internalname = "BTNTOGGLE" ;
      edtavLinkselection_Internalname = "vLINKSELECTION" ;
      edtTechnicianId_Internalname = "TECHNICIANID" ;
      edtTechnicianName_Internalname = "TECHNICIANNAME" ;
      edtTechnicianLastName_Internalname = "TECHNICIANLASTNAME" ;
      edtTechnicianPhone_Internalname = "TECHNICIANPHONE" ;
      edtCountryId_Internalname = "COUNTRYID" ;
      edtCityId_Internalname = "CITYID" ;
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
      edtCityId_Jsonclick = "" ;
      edtCountryId_Jsonclick = "" ;
      edtTechnicianPhone_Jsonclick = "" ;
      edtTechnicianLastName_Jsonclick = "" ;
      edtTechnicianName_Jsonclick = "" ;
      edtTechnicianId_Jsonclick = "" ;
      subGrid1_Allowcollapsing = (byte)(0) ;
      subGrid1_Allowselection = (byte)(0) ;
      edtTechnicianName_Link = "" ;
      edtavLinkselection_Link = "" ;
      subGrid1_Header = "" ;
      subGrid1_Class = "PromptGrid" ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      edtavCcityid_Jsonclick = "" ;
      edtavCcityid_Enabled = 1 ;
      edtavCcityid_Visible = 1 ;
      edtavCcountryid_Jsonclick = "" ;
      edtavCcountryid_Enabled = 1 ;
      edtavCcountryid_Visible = 1 ;
      edtavCtechnicianphone_Jsonclick = "" ;
      edtavCtechnicianphone_Enabled = 1 ;
      edtavCtechnicianphone_Visible = 1 ;
      edtavCtechnicianlastname_Jsonclick = "" ;
      edtavCtechnicianlastname_Enabled = 1 ;
      edtavCtechnicianlastname_Visible = 1 ;
      edtavCtechnicianname_Jsonclick = "" ;
      edtavCtechnicianname_Enabled = 1 ;
      edtavCtechnicianname_Visible = 1 ;
      edtavCtechnicianid_Jsonclick = "" ;
      edtavCtechnicianid_Enabled = 1 ;
      edtavCtechnicianid_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Selection List Technician" );
      divCityidfiltercontainer_Class = "AdvancedContainerItem" ;
      divCountryidfiltercontainer_Class = "AdvancedContainerItem" ;
      divTechnicianphonefiltercontainer_Class = "AdvancedContainerItem" ;
      divTechnicianlastnamefiltercontainer_Class = "AdvancedContainerItem" ;
      divTechniciannamefiltercontainer_Class = "AdvancedContainerItem" ;
      divTechnicianidfiltercontainer_Class = "AdvancedContainerItem" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV7cTechnicianName',fld:'vCTECHNICIANNAME',pic:''},{av:'AV8cTechnicianLastName',fld:'vCTECHNICIANLASTNAME',pic:''},{av:'AV9cTechnicianPhone',fld:'vCTECHNICIANPHONE',pic:''},{av:'AV10cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV11cCityId',fld:'vCCITYID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'TOGGLE'","{handler:'e17141',iparms:[{av:'divAdvancedcontainer_Class',ctrl:'ADVANCEDCONTAINER',prop:'Class'},{ctrl:'BTNTOGGLE',prop:'Class'}]");
      setEventMetadata("'TOGGLE'",",oparms:[{av:'divAdvancedcontainer_Class',ctrl:'ADVANCEDCONTAINER',prop:'Class'},{ctrl:'BTNTOGGLE',prop:'Class'}]}");
      setEventMetadata("LBLTECHNICIANIDFILTER.CLICK","{handler:'e11141',iparms:[{av:'divTechnicianidfiltercontainer_Class',ctrl:'TECHNICIANIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLTECHNICIANIDFILTER.CLICK",",oparms:[{av:'divTechnicianidfiltercontainer_Class',ctrl:'TECHNICIANIDFILTERCONTAINER',prop:'Class'},{av:'edtavCtechnicianid_Visible',ctrl:'vCTECHNICIANID',prop:'Visible'}]}");
      setEventMetadata("LBLTECHNICIANNAMEFILTER.CLICK","{handler:'e12141',iparms:[{av:'divTechniciannamefiltercontainer_Class',ctrl:'TECHNICIANNAMEFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLTECHNICIANNAMEFILTER.CLICK",",oparms:[{av:'divTechniciannamefiltercontainer_Class',ctrl:'TECHNICIANNAMEFILTERCONTAINER',prop:'Class'},{av:'edtavCtechnicianname_Visible',ctrl:'vCTECHNICIANNAME',prop:'Visible'}]}");
      setEventMetadata("LBLTECHNICIANLASTNAMEFILTER.CLICK","{handler:'e13141',iparms:[{av:'divTechnicianlastnamefiltercontainer_Class',ctrl:'TECHNICIANLASTNAMEFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLTECHNICIANLASTNAMEFILTER.CLICK",",oparms:[{av:'divTechnicianlastnamefiltercontainer_Class',ctrl:'TECHNICIANLASTNAMEFILTERCONTAINER',prop:'Class'},{av:'edtavCtechnicianlastname_Visible',ctrl:'vCTECHNICIANLASTNAME',prop:'Visible'}]}");
      setEventMetadata("LBLTECHNICIANPHONEFILTER.CLICK","{handler:'e14141',iparms:[{av:'divTechnicianphonefiltercontainer_Class',ctrl:'TECHNICIANPHONEFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLTECHNICIANPHONEFILTER.CLICK",",oparms:[{av:'divTechnicianphonefiltercontainer_Class',ctrl:'TECHNICIANPHONEFILTERCONTAINER',prop:'Class'},{av:'edtavCtechnicianphone_Visible',ctrl:'vCTECHNICIANPHONE',prop:'Visible'}]}");
      setEventMetadata("LBLCOUNTRYIDFILTER.CLICK","{handler:'e15141',iparms:[{av:'divCountryidfiltercontainer_Class',ctrl:'COUNTRYIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLCOUNTRYIDFILTER.CLICK",",oparms:[{av:'divCountryidfiltercontainer_Class',ctrl:'COUNTRYIDFILTERCONTAINER',prop:'Class'},{av:'edtavCcountryid_Visible',ctrl:'vCCOUNTRYID',prop:'Visible'}]}");
      setEventMetadata("LBLCITYIDFILTER.CLICK","{handler:'e16141',iparms:[{av:'divCityidfiltercontainer_Class',ctrl:'CITYIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLCITYIDFILTER.CLICK",",oparms:[{av:'divCityidfiltercontainer_Class',ctrl:'CITYIDFILTERCONTAINER',prop:'Class'},{av:'edtavCcityid_Visible',ctrl:'vCCITYID',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e20142',iparms:[{av:'A30TechnicianId',fld:'TECHNICIANID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV12pTechnicianId',fld:'vPTECHNICIANID',pic:'ZZZ9'}]}");
      setEventMetadata("GRID1_FIRSTPAGE","{handler:'subgrid1_firstpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV7cTechnicianName',fld:'vCTECHNICIANNAME',pic:''},{av:'AV8cTechnicianLastName',fld:'vCTECHNICIANLASTNAME',pic:''},{av:'AV9cTechnicianPhone',fld:'vCTECHNICIANPHONE',pic:''},{av:'AV10cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV11cCityId',fld:'vCCITYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID1_PREVPAGE","{handler:'subgrid1_previouspage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV7cTechnicianName',fld:'vCTECHNICIANNAME',pic:''},{av:'AV8cTechnicianLastName',fld:'vCTECHNICIANLASTNAME',pic:''},{av:'AV9cTechnicianPhone',fld:'vCTECHNICIANPHONE',pic:''},{av:'AV10cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV11cCityId',fld:'vCCITYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID1_NEXTPAGE","{handler:'subgrid1_nextpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV7cTechnicianName',fld:'vCTECHNICIANNAME',pic:''},{av:'AV8cTechnicianLastName',fld:'vCTECHNICIANLASTNAME',pic:''},{av:'AV9cTechnicianPhone',fld:'vCTECHNICIANPHONE',pic:''},{av:'AV10cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV11cCityId',fld:'vCCITYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID1_LASTPAGE","{handler:'subgrid1_lastpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cTechnicianId',fld:'vCTECHNICIANID',pic:'ZZZ9'},{av:'AV7cTechnicianName',fld:'vCTECHNICIANNAME',pic:''},{av:'AV8cTechnicianLastName',fld:'vCTECHNICIANLASTNAME',pic:''},{av:'AV9cTechnicianPhone',fld:'vCTECHNICIANPHONE',pic:''},{av:'AV10cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV11cCityId',fld:'vCCITYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_LASTPAGE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Cityid',iparms:[]");
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
      AV7cTechnicianName = "" ;
      AV8cTechnicianLastName = "" ;
      AV9cTechnicianPhone = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblLbltechnicianidfilter_Jsonclick = "" ;
      TempTags = "" ;
      lblLbltechniciannamefilter_Jsonclick = "" ;
      lblLbltechnicianlastnamefilter_Jsonclick = "" ;
      lblLbltechnicianphonefilter_Jsonclick = "" ;
      lblLblcountryidfilter_Jsonclick = "" ;
      lblLblcityidfilter_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntoggle_Jsonclick = "" ;
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid1_Linesclass = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      AV5LinkSelection = "" ;
      A31TechnicianName = "" ;
      A32TechnicianLastName = "" ;
      A33TechnicianPhone = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV16Linkselection_GXI = "" ;
      scmdbuf = "" ;
      lV7cTechnicianName = "" ;
      lV8cTechnicianLastName = "" ;
      lV9cTechnicianPhone = "" ;
      H00142_A24CityId = new short[1] ;
      H00142_A12CountryId = new short[1] ;
      H00142_A33TechnicianPhone = new String[] {""} ;
      H00142_A32TechnicianLastName = new String[] {""} ;
      H00142_A31TechnicianName = new String[] {""} ;
      H00142_A30TechnicianId = new short[1] ;
      H00143_AGRID1_nRecordCount = new long[1] ;
      AV13ADVANCED_LABEL_TEMPLATE = "" ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sImgUrl = "" ;
      ROClassString = "" ;
      gxphoneLink = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.gx0090__default(),
         new Object[] {
             new Object[] {
            H00142_A24CityId, H00142_A12CountryId, H00142_A33TechnicianPhone, H00142_A32TechnicianLastName, H00142_A31TechnicianName, H00142_A30TechnicianId
            }
            , new Object[] {
            H00143_AGRID1_nRecordCount
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
   private short AV6cTechnicianId ;
   private short AV10cCountryId ;
   private short AV11cCityId ;
   private short AV12pTechnicianId ;
   private short wbEnd ;
   private short wbStart ;
   private short A30TechnicianId ;
   private short A12CountryId ;
   private short A24CityId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_74 ;
   private int nGXsfl_74_idx=1 ;
   private int subGrid1_Rows ;
   private int edtavCtechnicianid_Enabled ;
   private int edtavCtechnicianid_Visible ;
   private int edtavCtechnicianname_Visible ;
   private int edtavCtechnicianname_Enabled ;
   private int edtavCtechnicianlastname_Visible ;
   private int edtavCtechnicianlastname_Enabled ;
   private int edtavCtechnicianphone_Visible ;
   private int edtavCtechnicianphone_Enabled ;
   private int edtavCcountryid_Enabled ;
   private int edtavCcountryid_Visible ;
   private int edtavCcityid_Enabled ;
   private int edtavCcityid_Visible ;
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
   private String divAdvancedcontainer_Class ;
   private String bttBtntoggle_Class ;
   private String divTechnicianidfiltercontainer_Class ;
   private String divTechniciannamefiltercontainer_Class ;
   private String divTechnicianlastnamefiltercontainer_Class ;
   private String divTechnicianphonefiltercontainer_Class ;
   private String divCountryidfiltercontainer_Class ;
   private String divCityidfiltercontainer_Class ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_74_idx="0001" ;
   private String AV7cTechnicianName ;
   private String AV8cTechnicianLastName ;
   private String AV9cTechnicianPhone ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMain_Internalname ;
   private String divAdvancedcontainer_Internalname ;
   private String divTechnicianidfiltercontainer_Internalname ;
   private String lblLbltechnicianidfilter_Internalname ;
   private String lblLbltechnicianidfilter_Jsonclick ;
   private String edtavCtechnicianid_Internalname ;
   private String TempTags ;
   private String edtavCtechnicianid_Jsonclick ;
   private String divTechniciannamefiltercontainer_Internalname ;
   private String lblLbltechniciannamefilter_Internalname ;
   private String lblLbltechniciannamefilter_Jsonclick ;
   private String edtavCtechnicianname_Internalname ;
   private String edtavCtechnicianname_Jsonclick ;
   private String divTechnicianlastnamefiltercontainer_Internalname ;
   private String lblLbltechnicianlastnamefilter_Internalname ;
   private String lblLbltechnicianlastnamefilter_Jsonclick ;
   private String edtavCtechnicianlastname_Internalname ;
   private String edtavCtechnicianlastname_Jsonclick ;
   private String divTechnicianphonefiltercontainer_Internalname ;
   private String lblLbltechnicianphonefilter_Internalname ;
   private String lblLbltechnicianphonefilter_Jsonclick ;
   private String edtavCtechnicianphone_Internalname ;
   private String edtavCtechnicianphone_Jsonclick ;
   private String divCountryidfiltercontainer_Internalname ;
   private String lblLblcountryidfilter_Internalname ;
   private String lblLblcountryidfilter_Jsonclick ;
   private String edtavCcountryid_Internalname ;
   private String edtavCcountryid_Jsonclick ;
   private String divCityidfiltercontainer_Internalname ;
   private String lblLblcityidfilter_Internalname ;
   private String lblLblcityidfilter_Jsonclick ;
   private String edtavCcityid_Internalname ;
   private String edtavCcityid_Jsonclick ;
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
   private String A31TechnicianName ;
   private String edtTechnicianName_Link ;
   private String A32TechnicianLastName ;
   private String A33TechnicianPhone ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavLinkselection_Internalname ;
   private String edtTechnicianId_Internalname ;
   private String edtTechnicianName_Internalname ;
   private String edtTechnicianLastName_Internalname ;
   private String edtTechnicianPhone_Internalname ;
   private String edtCountryId_Internalname ;
   private String edtCityId_Internalname ;
   private String scmdbuf ;
   private String lV7cTechnicianName ;
   private String lV8cTechnicianLastName ;
   private String lV9cTechnicianPhone ;
   private String AV13ADVANCED_LABEL_TEMPLATE ;
   private String sGXsfl_74_fel_idx="0001" ;
   private String sImgUrl ;
   private String ROClassString ;
   private String edtTechnicianId_Jsonclick ;
   private String edtTechnicianName_Jsonclick ;
   private String edtTechnicianLastName_Jsonclick ;
   private String gxphoneLink ;
   private String edtTechnicianPhone_Jsonclick ;
   private String edtCountryId_Jsonclick ;
   private String edtCityId_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_74_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV5LinkSelection_IsBlob ;
   private String AV16Linkselection_GXI ;
   private String AV5LinkSelection ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private IDataStoreProvider pr_default ;
   private short[] H00142_A24CityId ;
   private short[] H00142_A12CountryId ;
   private String[] H00142_A33TechnicianPhone ;
   private String[] H00142_A32TechnicianLastName ;
   private String[] H00142_A31TechnicianName ;
   private short[] H00142_A30TechnicianId ;
   private long[] H00143_AGRID1_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class gx0090__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00142( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV7cTechnicianName ,
                                          String AV8cTechnicianLastName ,
                                          String AV9cTechnicianPhone ,
                                          short AV10cCountryId ,
                                          short AV11cCityId ,
                                          String A31TechnicianName ,
                                          String A32TechnicianLastName ,
                                          String A33TechnicianPhone ,
                                          short A12CountryId ,
                                          short A24CityId ,
                                          short AV6cTechnicianId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[8];
      Object[] GXv_Object2 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " `CityId`, `CountryId`, `TechnicianPhone`, `TechnicianLastName`, `TechnicianName`, `TechnicianId`" ;
      sFromString = " FROM `Technician`" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(`TechnicianId` >= ?)");
      if ( ! (GXutil.strcmp("", AV7cTechnicianName)==0) )
      {
         addWhere(sWhereString, "(`TechnicianName` like ?)");
      }
      else
      {
         GXv_int1[1] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV8cTechnicianLastName)==0) )
      {
         addWhere(sWhereString, "(`TechnicianLastName` like ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV9cTechnicianPhone)==0) )
      {
         addWhere(sWhereString, "(`TechnicianPhone` like ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( ! (0==AV10cCountryId) )
      {
         addWhere(sWhereString, "(`CountryId` >= ?)");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      if ( ! (0==AV11cCityId) )
      {
         addWhere(sWhereString, "(`CityId` >= ?)");
      }
      else
      {
         GXv_int1[5] = (byte)(1) ;
      }
      sOrderString += " ORDER BY `TechnicianId`" ;
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " LIMIT " + "?" + ", " + "?" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   protected Object[] conditional_H00143( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV7cTechnicianName ,
                                          String AV8cTechnicianLastName ,
                                          String AV9cTechnicianPhone ,
                                          short AV10cCountryId ,
                                          short AV11cCityId ,
                                          String A31TechnicianName ,
                                          String A32TechnicianLastName ,
                                          String A33TechnicianPhone ,
                                          short A12CountryId ,
                                          short A24CityId ,
                                          short AV6cTechnicianId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[6];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM `Technician`" ;
      addWhere(sWhereString, "(`TechnicianId` >= ?)");
      if ( ! (GXutil.strcmp("", AV7cTechnicianName)==0) )
      {
         addWhere(sWhereString, "(`TechnicianName` like ?)");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV8cTechnicianLastName)==0) )
      {
         addWhere(sWhereString, "(`TechnicianLastName` like ?)");
      }
      else
      {
         GXv_int3[2] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV9cTechnicianPhone)==0) )
      {
         addWhere(sWhereString, "(`TechnicianPhone` like ?)");
      }
      else
      {
         GXv_int3[3] = (byte)(1) ;
      }
      if ( ! (0==AV10cCountryId) )
      {
         addWhere(sWhereString, "(`CountryId` >= ?)");
      }
      else
      {
         GXv_int3[4] = (byte)(1) ;
      }
      if ( ! (0==AV11cCityId) )
      {
         addWhere(sWhereString, "(`CityId` >= ?)");
      }
      else
      {
         GXv_int3[5] = (byte)(1) ;
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
                  return conditional_H00142(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() );
            case 1 :
                  return conditional_H00143(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00142", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00143", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 50);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 50);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 50);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
      }
   }

}


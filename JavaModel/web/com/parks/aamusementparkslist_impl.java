package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class aamusementparkslist_impl extends GXWebReport
{
   public aamusementparkslist_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "CountryId") ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( ! entryPointCalled )
      {
         AV8CountryId = (short)(GXutil.lval( gxfirstwebparm)) ;
      }
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      httpContext.setDefaultTheme("Carmine");
      M_top = 0 ;
      M_bot = 6 ;
      P_lines = (int)(66-M_bot) ;
      getPrinter().GxClearAttris() ;
      add_metrics( ) ;
      lineHeight = 15 ;
      PrtOffset = 0 ;
      gxXPage = 100 ;
      gxYPage = 100 ;
      getPrinter().GxSetDocName("") ;
      try
      {
         Gx_out = "FIL" ;
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 256, 16834, 11909, 0, 1, 1, 0, 1, 1) )
         {
            cleanup();
            return;
         }
         getPrinter().setModal(true) ;
         P_lines = (int)(gxYPage-(lineHeight*6)) ;
         Gx_line = (int)(P_lines+1) ;
         getPrinter().setPageLines(P_lines);
         getPrinter().setLineHeight(lineHeight);
         getPrinter().setM_top(M_top);
         getPrinter().setM_bot(M_bot);
         h0E0( false, 135) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 14, true, false, false, false, 0, 0, 0, 139, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Amousement Parks List", 308, Gx_line+50, 541, Gx_line+75, 0, 0, 0, 0) ;
         getPrinter().GxDrawBitMap(context.getHttpContext().getImagePath( "8e061d48-7dfb-48c1-96cd-ebe6b1262b3d", "", context.getHttpContext().getTheme( )), 58, Gx_line+17, 233, Gx_line+117) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+135) ;
         h0E0( false, 90) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 10, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 67, Gx_line+33, 125, Gx_line+50, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Name", 242, Gx_line+33, 284, Gx_line+50, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Photo", 708, Gx_line+33, 766, Gx_line+50, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(33, Gx_line+67, 808, Gx_line+67, 1, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Country", 508, Gx_line+33, 547, Gx_line+47, 0+256, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+90) ;
         /* Using cursor P000E2 */
         pr_default.execute(0);
         while ( (pr_default.getStatus(0) != 101) )
         {
            A12CountryId = P000E2_A12CountryId[0] ;
            A13CountryName = P000E2_A13CountryName[0] ;
            A40000AmusementParkPhoto_GXI = P000E2_A40000AmusementParkPhoto_GXI[0] ;
            A11AmusementParkPhoto = P000E2_A11AmusementParkPhoto[0] ;
            A8AmusementParkName = P000E2_A8AmusementParkName[0] ;
            A7AmusementParkId = P000E2_A7AmusementParkId[0] ;
            A13CountryName = P000E2_A13CountryName[0] ;
            h0E0( false, 100) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9")), 58, Gx_line+33, 84, Gx_line+48, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A8AmusementParkName, "")), 233, Gx_line+33, 358, Gx_line+48, 0, 0, 0, 0) ;
            sImgUrl = ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : A11AmusementParkPhoto) ;
            getPrinter().GxDrawBitMap(sImgUrl, 692, Gx_line+17, 809, Gx_line+84) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A13CountryName, "")), 500, Gx_line+33, 608, Gx_line+48, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+100) ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         /* Using cursor P000E3 */
         pr_default.execute(1);
         while ( (pr_default.getStatus(1) != 101) )
         {
            A12CountryId = P000E3_A12CountryId[0] ;
            A40000AmusementParkPhoto_GXI = P000E3_A40000AmusementParkPhoto_GXI[0] ;
            A13CountryName = P000E3_A13CountryName[0] ;
            A11AmusementParkPhoto = P000E3_A11AmusementParkPhoto[0] ;
            A8AmusementParkName = P000E3_A8AmusementParkName[0] ;
            A7AmusementParkId = P000E3_A7AmusementParkId[0] ;
            A10AmusementParkAddress = P000E3_A10AmusementParkAddress[0] ;
            A13CountryName = P000E3_A13CountryName[0] ;
            h0E0( false, 100) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9")), 58, Gx_line+33, 84, Gx_line+48, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A8AmusementParkName, "")), 233, Gx_line+33, 358, Gx_line+48, 0, 0, 0, 0) ;
            sImgUrl = ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : A11AmusementParkPhoto) ;
            getPrinter().GxDrawBitMap(sImgUrl, 692, Gx_line+17, 809, Gx_line+84) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A13CountryName, "")), 500, Gx_line+33, 608, Gx_line+48, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+100) ;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Using cursor P000E4 */
         pr_default.execute(2);
         while ( (pr_default.getStatus(2) != 101) )
         {
            A12CountryId = P000E4_A12CountryId[0] ;
            A19CategoryId = P000E4_A19CategoryId[0] ;
            n19CategoryId = P000E4_n19CategoryId[0] ;
            A40000AmusementParkPhoto_GXI = P000E4_A40000AmusementParkPhoto_GXI[0] ;
            A11AmusementParkPhoto = P000E4_A11AmusementParkPhoto[0] ;
            A8AmusementParkName = P000E4_A8AmusementParkName[0] ;
            A7AmusementParkId = P000E4_A7AmusementParkId[0] ;
            A20CategoryName = P000E4_A20CategoryName[0] ;
            A13CountryName = P000E4_A13CountryName[0] ;
            A17GameId = P000E4_A17GameId[0] ;
            A20CategoryName = P000E4_A20CategoryName[0] ;
            A12CountryId = P000E4_A12CountryId[0] ;
            A40000AmusementParkPhoto_GXI = P000E4_A40000AmusementParkPhoto_GXI[0] ;
            A11AmusementParkPhoto = P000E4_A11AmusementParkPhoto[0] ;
            A8AmusementParkName = P000E4_A8AmusementParkName[0] ;
            A13CountryName = P000E4_A13CountryName[0] ;
            h0E0( false, 100) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A7AmusementParkId), "ZZZ9")), 58, Gx_line+33, 84, Gx_line+48, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A8AmusementParkName, "")), 233, Gx_line+33, 358, Gx_line+48, 0, 0, 0, 0) ;
            sImgUrl = ((GXutil.strcmp("", A11AmusementParkPhoto)==0) ? A40000AmusementParkPhoto_GXI : A11AmusementParkPhoto) ;
            getPrinter().GxDrawBitMap(sImgUrl, 692, Gx_line+17, 809, Gx_line+84) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A13CountryName, "")), 500, Gx_line+33, 608, Gx_line+48, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+100) ;
            pr_default.readNext(2);
         }
         pr_default.close(2);
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h0E0( true, 0) ;
         /* Close printer file */
         getPrinter().GxEndDocument() ;
         endPrinter();
      }
      catch ( ProcessInterruptedException e )
      {
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void h0E0( boolean bFoot ,
                     int Inc )
   {
      /* Skip the required number of lines */
      while ( ( ToSkip > 0 ) || ( Gx_line + Inc > P_lines ) )
      {
         if ( Gx_line + Inc >= P_lines )
         {
            if ( Gx_page > 0 )
            {
               /* Print footers */
               Gx_line = P_lines ;
               getPrinter().GxEndPage() ;
               if ( bFoot )
               {
                  return  ;
               }
            }
            ToSkip = 0 ;
            Gx_line = 0 ;
            Gx_page = (int)(Gx_page+1) ;
            /* Skip Margin Top Lines */
            Gx_line = (int)(Gx_line+(M_top*lineHeight)) ;
            /* Print headers */
            getPrinter().GxStartPage() ;
            getPrinter().setPage(Gx_page);
            if (true) break;
         }
         else
         {
            PrtOffset = 0 ;
            Gx_line = (int)(Gx_line+1) ;
         }
         ToSkip = (int)(ToSkip-1) ;
      }
      getPrinter().setPage(Gx_page);
   }

   public void add_metrics( )
   {
      add_metrics0( ) ;
      add_metrics1( ) ;
   }

   public void add_metrics0( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", true, false, 57, 15, 72, 163,  new int[] {47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 19, 29, 34, 34, 55, 45, 15, 21, 21, 24, 36, 17, 21, 17, 17, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 21, 21, 36, 36, 36, 38, 60, 43, 45, 45, 45, 41, 38, 48, 45, 17, 34, 45, 38, 53, 45, 48, 41, 48, 45, 41, 38, 45, 41, 57, 41, 41, 38, 21, 17, 21, 36, 34, 21, 34, 38, 34, 38, 34, 21, 38, 38, 17, 17, 34, 17, 55, 38, 38, 38, 38, 24, 34, 21, 38, 33, 49, 34, 34, 31, 24, 17, 24, 36, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 21, 34, 34, 34, 34, 17, 34, 21, 46, 23, 34, 36, 21, 46, 34, 25, 34, 21, 21, 21, 36, 34, 21, 20, 21, 23, 34, 52, 52, 52, 38, 45, 45, 45, 45, 45, 45, 62, 45, 41, 41, 41, 41, 17, 17, 17, 17, 45, 45, 48, 48, 48, 48, 48, 36, 48, 45, 45, 45, 45, 41, 41, 38, 34, 34, 34, 34, 34, 34, 55, 34, 34, 34, 34, 34, 17, 17, 17, 17, 38, 38, 38, 38, 38, 38, 38, 34, 38, 38, 38, 38, 38, 34, 38, 34}) ;
   }

   public void add_metrics1( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", false, false, 58, 14, 72, 171,  new int[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 23, 36, 36, 57, 43, 12, 21, 21, 25, 37, 18, 21, 18, 18, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 18, 18, 37, 37, 37, 36, 65, 43, 43, 46, 46, 43, 39, 50, 46, 18, 32, 43, 36, 53, 46, 50, 43, 50, 46, 43, 40, 46, 43, 64, 41, 42, 39, 18, 18, 18, 27, 36, 21, 36, 36, 32, 36, 36, 18, 36, 36, 14, 15, 33, 14, 55, 36, 36, 36, 36, 21, 32, 18, 36, 33, 47, 31, 31, 31, 21, 17, 21, 37, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 36, 36, 36, 36, 17, 36, 21, 47, 24, 36, 37, 21, 47, 35, 26, 35, 21, 21, 21, 37, 34, 21, 21, 21, 23, 36, 53, 53, 53, 39, 43, 43, 43, 43, 43, 43, 64, 46, 43, 43, 43, 43, 18, 18, 18, 18, 46, 46, 50, 50, 50, 50, 50, 37, 50, 46, 46, 46, 46, 43, 43, 39, 36, 36, 36, 36, 36, 36, 57, 32, 36, 36, 36, 36, 18, 18, 18, 18, 36, 36, 36, 36, 36, 36, 36, 35, 39, 36, 36, 36, 36, 32, 36, 32}) ;
   }

   protected int getOutputType( )
   {
      return OUTPUT_PDF;
   }

   protected java.io.OutputStream getOutputStream( )
   {
      return httpContext.getOutputStream();
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
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      scmdbuf = "" ;
      P000E2_A12CountryId = new short[1] ;
      P000E2_A13CountryName = new String[] {""} ;
      P000E2_A40000AmusementParkPhoto_GXI = new String[] {""} ;
      P000E2_A11AmusementParkPhoto = new String[] {""} ;
      P000E2_A8AmusementParkName = new String[] {""} ;
      P000E2_A7AmusementParkId = new short[1] ;
      A13CountryName = "" ;
      A40000AmusementParkPhoto_GXI = "" ;
      A11AmusementParkPhoto = "" ;
      A8AmusementParkName = "" ;
      sImgUrl = "" ;
      P000E3_A12CountryId = new short[1] ;
      P000E3_A40000AmusementParkPhoto_GXI = new String[] {""} ;
      P000E3_A13CountryName = new String[] {""} ;
      P000E3_A11AmusementParkPhoto = new String[] {""} ;
      P000E3_A8AmusementParkName = new String[] {""} ;
      P000E3_A7AmusementParkId = new short[1] ;
      P000E3_A10AmusementParkAddress = new String[] {""} ;
      A10AmusementParkAddress = "" ;
      P000E4_A12CountryId = new short[1] ;
      P000E4_A19CategoryId = new short[1] ;
      P000E4_n19CategoryId = new boolean[] {false} ;
      P000E4_A40000AmusementParkPhoto_GXI = new String[] {""} ;
      P000E4_A11AmusementParkPhoto = new String[] {""} ;
      P000E4_A8AmusementParkName = new String[] {""} ;
      P000E4_A7AmusementParkId = new short[1] ;
      P000E4_A20CategoryName = new String[] {""} ;
      P000E4_A13CountryName = new String[] {""} ;
      P000E4_A17GameId = new short[1] ;
      A20CategoryName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.aamusementparkslist__default(),
         new Object[] {
             new Object[] {
            P000E2_A12CountryId, P000E2_A13CountryName, P000E2_A40000AmusementParkPhoto_GXI, P000E2_A11AmusementParkPhoto, P000E2_A8AmusementParkName, P000E2_A7AmusementParkId
            }
            , new Object[] {
            P000E3_A12CountryId, P000E3_A40000AmusementParkPhoto_GXI, P000E3_A13CountryName, P000E3_A11AmusementParkPhoto, P000E3_A8AmusementParkName, P000E3_A7AmusementParkId, P000E3_A10AmusementParkAddress
            }
            , new Object[] {
            P000E4_A12CountryId, P000E4_A19CategoryId, P000E4_n19CategoryId, P000E4_A40000AmusementParkPhoto_GXI, P000E4_A11AmusementParkPhoto, P000E4_A8AmusementParkName, P000E4_A7AmusementParkId, P000E4_A20CategoryName, P000E4_A13CountryName, P000E4_A17GameId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV8CountryId ;
   private short A12CountryId ;
   private short A7AmusementParkId ;
   private short A19CategoryId ;
   private short A17GameId ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private String A13CountryName ;
   private String A8AmusementParkName ;
   private String sImgUrl ;
   private String A20CategoryName ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n19CategoryId ;
   private String A40000AmusementParkPhoto_GXI ;
   private String A10AmusementParkAddress ;
   private String A11AmusementParkPhoto ;
   private IDataStoreProvider pr_default ;
   private short[] P000E2_A12CountryId ;
   private String[] P000E2_A13CountryName ;
   private String[] P000E2_A40000AmusementParkPhoto_GXI ;
   private String[] P000E2_A11AmusementParkPhoto ;
   private String[] P000E2_A8AmusementParkName ;
   private short[] P000E2_A7AmusementParkId ;
   private short[] P000E3_A12CountryId ;
   private String[] P000E3_A40000AmusementParkPhoto_GXI ;
   private String[] P000E3_A13CountryName ;
   private String[] P000E3_A11AmusementParkPhoto ;
   private String[] P000E3_A8AmusementParkName ;
   private short[] P000E3_A7AmusementParkId ;
   private String[] P000E3_A10AmusementParkAddress ;
   private short[] P000E4_A12CountryId ;
   private short[] P000E4_A19CategoryId ;
   private boolean[] P000E4_n19CategoryId ;
   private String[] P000E4_A40000AmusementParkPhoto_GXI ;
   private String[] P000E4_A11AmusementParkPhoto ;
   private String[] P000E4_A8AmusementParkName ;
   private short[] P000E4_A7AmusementParkId ;
   private String[] P000E4_A20CategoryName ;
   private String[] P000E4_A13CountryName ;
   private short[] P000E4_A17GameId ;
}

final  class aamusementparkslist__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000E2", "SELECT T1.`CountryId`, T2.`CountryName`, T1.`AmusementParkPhoto_GXI`, T1.`AmusementParkPhoto`, T1.`AmusementParkName`, T1.`AmusementParkId` FROM (`AmusementPark` T1 INNER JOIN `Country` T2 ON T2.`CountryId` = T1.`CountryId`) WHERE T2.`CountryName` = 'Uruguay' ORDER BY T2.`CountryName` ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000E3", "SELECT T1.`CountryId`, T1.`AmusementParkPhoto_GXI`, T2.`CountryName`, T1.`AmusementParkPhoto`, T1.`AmusementParkName`, T1.`AmusementParkId`, T1.`AmusementParkAddress` FROM (`AmusementPark` T1 INNER JOIN `Country` T2 ON T2.`CountryId` = T1.`CountryId`) ORDER BY T1.`AmusementParkAddress` ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000E4", "SELECT T3.`CountryId`, T1.`CategoryId`, T3.`AmusementParkPhoto_GXI`, T3.`AmusementParkPhoto`, T3.`AmusementParkName`, T1.`AmusementParkId`, T2.`CategoryName`, T4.`CountryName`, T1.`GameId` FROM (((`Game` T1 LEFT JOIN `Category` T2 ON T2.`CategoryId` = T1.`CategoryId`) INNER JOIN `AmusementPark` T3 ON T3.`AmusementParkId` = T1.`AmusementParkId`) INNER JOIN `Country` T4 ON T4.`CountryId` = T3.`CountryId`) ORDER BY T4.`CountryName`, T2.`CategoryName` ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(3));
               ((String[]) buf[4])[0] = rslt.getString(5, 50);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 50);
               ((String[]) buf[3])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(2));
               ((String[]) buf[4])[0] = rslt.getString(5, 50);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(3));
               ((String[]) buf[5])[0] = rslt.getString(5, 50);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 50);
               ((String[]) buf[8])[0] = rslt.getString(8, 50);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}


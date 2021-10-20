package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ashowsbydate_impl extends GXWebReport
{
   public ashowsbydate_impl( com.genexus.internet.HttpContext context )
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
      gxfirstwebparm = httpContext.GetFirstPar( "SelectedParkID") ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( ! entryPointCalled )
      {
         AV8SelectedParkID = (short)(GXutil.lval( gxfirstwebparm)) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV9SelectedDateFrom = localUtil.parseDateParm( httpContext.GetPar( "SelectedDateFrom")) ;
         }
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
         h0X0( false, 133) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 14, true, false, false, false, 0, 0, 0, 139, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Shows per Park", 308, Gx_line+33, 625, Gx_line+58, 0, 0, 0, 0) ;
         getPrinter().GxDrawBitMap(context.getHttpContext().getImagePath( "8d7fbf81-67b2-4a5b-8bbd-43ffbef28115", "", context.getHttpContext().getTheme( )), 50, Gx_line+20, 200, Gx_line+120) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Selected Park Id", 308, Gx_line+83, 391, Gx_line+97, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText("Shows From", 308, Gx_line+100, 369, Gx_line+114, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV8SelectedParkID), "ZZZ9")), 433, Gx_line+83, 459, Gx_line+98, 2+256, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( AV9SelectedDateFrom, "99/99/99"), 433, Gx_line+100, 482, Gx_line+115, 2+256, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+133) ;
         h0X0( false, 127) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 10, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Image", 275, Gx_line+67, 333, Gx_line+84, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Date", 508, Gx_line+67, 583, Gx_line+84, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Schedule", 717, Gx_line+67, 775, Gx_line+84, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(58, Gx_line+100, 808, Gx_line+100, 1, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Show Name", 75, Gx_line+67, 136, Gx_line+81, 0+256, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+127) ;
         /* Using cursor P000X2 */
         pr_default.execute(0, new Object[] {AV9SelectedDateFrom});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A50ShowDate = P000X2_A50ShowDate[0] ;
            A40000ShowImage_GXI = P000X2_A40000ShowImage_GXI[0] ;
            A51ShowSchedule = P000X2_A51ShowSchedule[0] ;
            A16ShowImage = P000X2_A16ShowImage[0] ;
            A15ShowName = P000X2_A15ShowName[0] ;
            A14ShowId = P000X2_A14ShowId[0] ;
            h0X0( false, 100) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A15ShowName, "")), 67, Gx_line+33, 150, Gx_line+48, 0, 0, 0, 0) ;
            sImgUrl = ((GXutil.strcmp("", A16ShowImage)==0) ? A40000ShowImage_GXI : A16ShowImage) ;
            getPrinter().GxDrawBitMap(sImgUrl, 283, Gx_line+33, 315, Gx_line+48) ;
            getPrinter().GxDrawText(localUtil.format( A50ShowDate, "99/99/99"), 517, Gx_line+33, 566, Gx_line+48, 2+256, 0, 0, 0) ;
            getPrinter().GxDrawText(localUtil.format( A51ShowSchedule, "99/99/99 99:99"), 717, Gx_line+33, 797, Gx_line+48, 2+256, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+100) ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h0X0( true, 0) ;
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

   public void h0X0( boolean bFoot ,
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
      AV9SelectedDateFrom = GXutil.nullDate() ;
      scmdbuf = "" ;
      P000X2_A50ShowDate = new java.util.Date[] {GXutil.nullDate()} ;
      P000X2_A40000ShowImage_GXI = new String[] {""} ;
      P000X2_A51ShowSchedule = new java.util.Date[] {GXutil.nullDate()} ;
      P000X2_A16ShowImage = new String[] {""} ;
      P000X2_A15ShowName = new String[] {""} ;
      P000X2_A14ShowId = new short[1] ;
      A50ShowDate = GXutil.nullDate() ;
      A40000ShowImage_GXI = "" ;
      A51ShowSchedule = GXutil.resetTime( GXutil.nullDate() );
      A16ShowImage = "" ;
      A15ShowName = "" ;
      sImgUrl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.ashowsbydate__default(),
         new Object[] {
             new Object[] {
            P000X2_A50ShowDate, P000X2_A40000ShowImage_GXI, P000X2_A51ShowSchedule, P000X2_A16ShowImage, P000X2_A15ShowName, P000X2_A14ShowId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV8SelectedParkID ;
   private short A14ShowId ;
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
   private String A15ShowName ;
   private String sImgUrl ;
   private java.util.Date A51ShowSchedule ;
   private java.util.Date AV9SelectedDateFrom ;
   private java.util.Date A50ShowDate ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private String A40000ShowImage_GXI ;
   private String A16ShowImage ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P000X2_A50ShowDate ;
   private String[] P000X2_A40000ShowImage_GXI ;
   private java.util.Date[] P000X2_A51ShowSchedule ;
   private String[] P000X2_A16ShowImage ;
   private String[] P000X2_A15ShowName ;
   private short[] P000X2_A14ShowId ;
}

final  class ashowsbydate__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000X2", "SELECT `ShowDate`, `ShowImage_GXI`, `ShowSchedule`, `ShowImage`, `ShowName`, `ShowId` FROM `Show` WHERE `ShowDate` > ? ORDER BY `ShowId` ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(2));
               ((String[]) buf[4])[0] = rslt.getString(5, 50);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               stmt.setDate(1, (java.util.Date)parms[0]);
               return;
      }
   }

}


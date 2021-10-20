package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class agamesbycategory_impl extends GXWebReport
{
   public agamesbycategory_impl( com.genexus.internet.HttpContext context )
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
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
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
         h0F0( false, 133) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 14, true, false, false, false, 0, 0, 0, 139, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Categories and their games", 308, Gx_line+50, 625, Gx_line+75, 0, 0, 0, 0) ;
         getPrinter().GxDrawBitMap(context.getHttpContext().getImagePath( "8d7fbf81-67b2-4a5b-8bbd-43ffbef28115", "", context.getHttpContext().getTheme( )), 50, Gx_line+20, 200, Gx_line+120) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+133) ;
         /* Using cursor P000F2 */
         pr_default.execute(0);
         while ( (pr_default.getStatus(0) != 101) )
         {
            A19CategoryId = P000F2_A19CategoryId[0] ;
            n19CategoryId = P000F2_n19CategoryId[0] ;
            A20CategoryName = P000F2_A20CategoryName[0] ;
            h0F0( false, 127) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 10, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Name", 275, Gx_line+67, 333, Gx_line+84, 0, 0, 0, 0) ;
            getPrinter().GxDrawText("Park Name", 508, Gx_line+67, 583, Gx_line+84, 0, 0, 0, 0) ;
            getPrinter().GxDrawText("Photo", 717, Gx_line+67, 775, Gx_line+84, 0, 0, 0, 0) ;
            getPrinter().GxDrawLine(250, Gx_line+100, 808, Gx_line+100, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Games:", 158, Gx_line+50, 208, Gx_line+67, 0, 0, 0, 0) ;
            getPrinter().GxDrawText("Category: ", 50, Gx_line+17, 108, Gx_line+31, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A20CategoryName, "")), 117, Gx_line+17, 234, Gx_line+32, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+127) ;
            /* Using cursor P000F3 */
            pr_default.execute(1, new Object[] {Boolean.valueOf(n19CategoryId), Short.valueOf(A19CategoryId)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A7AmusementParkId = P000F3_A7AmusementParkId[0] ;
               A40000GamePhoto_GXI = P000F3_A40000GamePhoto_GXI[0] ;
               A21GamePhoto = P000F3_A21GamePhoto[0] ;
               A8AmusementParkName = P000F3_A8AmusementParkName[0] ;
               A18GameName = P000F3_A18GameName[0] ;
               A17GameId = P000F3_A17GameId[0] ;
               A8AmusementParkName = P000F3_A8AmusementParkName[0] ;
               h0F0( false, 100) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A18GameName, "")), 275, Gx_line+33, 358, Gx_line+48, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A8AmusementParkName, "")), 483, Gx_line+33, 608, Gx_line+48, 0, 0, 0, 0) ;
               sImgUrl = ((GXutil.strcmp("", A21GamePhoto)==0) ? A40000GamePhoto_GXI : A21GamePhoto) ;
               getPrinter().GxDrawBitMap(sImgUrl, 692, Gx_line+17, 809, Gx_line+84) ;
               Gx_OldLine = Gx_line ;
               Gx_line = (int)(Gx_line+100) ;
               pr_default.readNext(1);
            }
            pr_default.close(1);
            pr_default.readNext(0);
         }
         pr_default.close(0);
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h0F0( true, 0) ;
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

   public void h0F0( boolean bFoot ,
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
      P000F2_A19CategoryId = new short[1] ;
      P000F2_n19CategoryId = new boolean[] {false} ;
      P000F2_A20CategoryName = new String[] {""} ;
      A20CategoryName = "" ;
      P000F3_A7AmusementParkId = new short[1] ;
      P000F3_A19CategoryId = new short[1] ;
      P000F3_n19CategoryId = new boolean[] {false} ;
      P000F3_A40000GamePhoto_GXI = new String[] {""} ;
      P000F3_A21GamePhoto = new String[] {""} ;
      P000F3_A8AmusementParkName = new String[] {""} ;
      P000F3_A18GameName = new String[] {""} ;
      P000F3_A17GameId = new short[1] ;
      A40000GamePhoto_GXI = "" ;
      A21GamePhoto = "" ;
      A8AmusementParkName = "" ;
      A18GameName = "" ;
      sImgUrl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.agamesbycategory__default(),
         new Object[] {
             new Object[] {
            P000F2_A19CategoryId, P000F2_A20CategoryName
            }
            , new Object[] {
            P000F3_A7AmusementParkId, P000F3_A19CategoryId, P000F3_n19CategoryId, P000F3_A40000GamePhoto_GXI, P000F3_A21GamePhoto, P000F3_A8AmusementParkName, P000F3_A18GameName, P000F3_A17GameId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short A19CategoryId ;
   private short A7AmusementParkId ;
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
   private String A20CategoryName ;
   private String A8AmusementParkName ;
   private String A18GameName ;
   private String sImgUrl ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n19CategoryId ;
   private String A40000GamePhoto_GXI ;
   private String A21GamePhoto ;
   private IDataStoreProvider pr_default ;
   private short[] P000F2_A19CategoryId ;
   private boolean[] P000F2_n19CategoryId ;
   private String[] P000F2_A20CategoryName ;
   private short[] P000F3_A7AmusementParkId ;
   private short[] P000F3_A19CategoryId ;
   private boolean[] P000F3_n19CategoryId ;
   private String[] P000F3_A40000GamePhoto_GXI ;
   private String[] P000F3_A21GamePhoto ;
   private String[] P000F3_A8AmusementParkName ;
   private String[] P000F3_A18GameName ;
   private short[] P000F3_A17GameId ;
}

final  class agamesbycategory__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000F2", "SELECT `CategoryId`, `CategoryName` FROM `Category` ORDER BY `CategoryId` ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000F3", "SELECT T1.`AmusementParkId`, T1.`CategoryId`, T1.`GamePhoto_GXI`, T1.`GamePhoto`, T2.`AmusementParkName`, T1.`GameName`, T1.`GameId` FROM (`Game` T1 INNER JOIN `AmusementPark` T2 ON T2.`AmusementParkId` = T1.`AmusementParkId`) WHERE T1.`CategoryId` = ? ORDER BY T1.`CategoryId` ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(3));
               ((String[]) buf[5])[0] = rslt.getString(5, 50);
               ((String[]) buf[6])[0] = rslt.getString(6, 50);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
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


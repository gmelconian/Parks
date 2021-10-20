package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gxrtctls extends GXProcedure
{
   public gxrtctls( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gxrtctls.class ), "" );
   }

   public gxrtctls( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( )
   {
      gxrtctls.this.aP0 = new byte[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( byte[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( byte[] aP0 )
   {
      gxrtctls.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV2Status = (byte)(0) ;
      System.out.println( "=== Starting run time controls" );
      System.out.println( "Searching Country for duplicate values on new unique index on CountryName" );
      /* Using cursor LTCTLS2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkR012 = false ;
         A13CountryName = LTCTLS2_A13CountryName[0] ;
         A12CountryId = LTCTLS2_A12CountryId[0] ;
         AV3Count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(LTCTLS2_A13CountryName[0], A13CountryName) == 0 ) )
         {
            brkR012 = false ;
            A12CountryId = LTCTLS2_A12CountryId[0] ;
            if ( AV3Count != 0 )
            {
               AV2Status = (byte)(1) ;
               System.out.println( "Fail: Duplicates found. The first non unique value found follows." );
               System.out.println( "CountryName: "+GXutil.rtrim( A13CountryName) );
               System.out.println( "Recovery: See recovery information for reorganization message rgz0020." );
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            AV3Count = (int)(AV3Count+1) ;
            brkR012 = true ;
            pr_default.readNext(0);
         }
         if ( AV2Status != 0 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkR012 )
         {
            brkR012 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      if ( AV2Status == 0 )
      {
         System.out.println( "Success: No duplicates found for CountryName" );
      }
      System.out.println( "====================" );
      System.out.println( "=== End of run time controls" );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = gxrtctls.this.AV2Status;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      LTCTLS2_A13CountryName = new String[] {""} ;
      LTCTLS2_A12CountryId = new short[1] ;
      A13CountryName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.parks.gxrtctls__default(),
         new Object[] {
             new Object[] {
            LTCTLS2_A13CountryName, LTCTLS2_A12CountryId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV2Status ;
   private short A12CountryId ;
   private short Gx_err ;
   private int AV3Count ;
   private String scmdbuf ;
   private String A13CountryName ;
   private boolean brkR012 ;
   private byte[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] LTCTLS2_A13CountryName ;
   private short[] LTCTLS2_A12CountryId ;
}

final  class gxrtctls__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("LTCTLS2", "SELECT `CountryName`, `CountryId` FROM `Country` ORDER BY `CountryName` ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 50);
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
      }
   }

}


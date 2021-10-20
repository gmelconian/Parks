package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class stringconcatenationunittestdata extends GXProcedure
{
   public stringconcatenationunittestdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( stringconcatenationunittestdata.class ), "" );
   }

   public stringconcatenationunittestdata( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT> executeUdp( )
   {
      stringconcatenationunittestdata.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT>[] aP0 )
   {
      stringconcatenationunittestdata.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1stringconcatenationunittestsdt = (com.parks.SdtStringConcatenationUnitTestSDT)new com.parks.SdtStringConcatenationUnitTestSDT(remoteHandle, context);
      Gxm2rootcol.add(Gxm1stringconcatenationunittestsdt, 0);
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid( "1" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String1( "C9WD8V1BYR" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String2( " HG0F8EWY" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation( "C9WD8V1BYR HG0F8EWY" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation( "" );
      Gxm1stringconcatenationunittestsdt = (com.parks.SdtStringConcatenationUnitTestSDT)new com.parks.SdtStringConcatenationUnitTestSDT(remoteHandle, context);
      Gxm2rootcol.add(Gxm1stringconcatenationunittestsdt, 0);
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid( "2" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String1( "1U8OF18Z8U38E1HGFLU5" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String2( "VZMRC HGTM 4H1GYRG6U" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation( "1U8OF18Z8U38E1HGFLU5VZMRC HGTM 4H1GYRG6U" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation( "" );
      Gxm1stringconcatenationunittestsdt = (com.parks.SdtStringConcatenationUnitTestSDT)new com.parks.SdtStringConcatenationUnitTestSDT(remoteHandle, context);
      Gxm2rootcol.add(Gxm1stringconcatenationunittestsdt, 0);
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid( "3" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String1( "" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String2( "" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation( "" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation( "" );
      Gxm1stringconcatenationunittestsdt = (com.parks.SdtStringConcatenationUnitTestSDT)new com.parks.SdtStringConcatenationUnitTestSDT(remoteHandle, context);
      Gxm2rootcol.add(Gxm1stringconcatenationunittestsdt, 0);
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid( "4" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String1( "BZJZ C Z WUJVMJVQRLA" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String2( "AVGAHERHCOXPJUZLPVZV" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation( "BZJZ C Z WUJVMJVQRLAAVGAHERHCOXPJUZLPVZV" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation( "" );
      Gxm1stringconcatenationunittestsdt = (com.parks.SdtStringConcatenationUnitTestSDT)new com.parks.SdtStringConcatenationUnitTestSDT(remoteHandle, context);
      Gxm2rootcol.add(Gxm1stringconcatenationunittestsdt, 0);
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid( "5" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String1( "1U8OF18Z8U38E1HGFLU5" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_String2( "" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation( "1U8OF18Z8U38E1HGFLU5" );
      Gxm1stringconcatenationunittestsdt.setgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation( "" );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = stringconcatenationunittestdata.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT>(com.parks.SdtStringConcatenationUnitTestSDT.class, "StringConcatenationUnitTestSDT", "Parks", remoteHandle);
      Gxm1stringconcatenationunittestsdt = new com.parks.SdtStringConcatenationUnitTestSDT(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT>[] aP0 ;
   private GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT> Gxm2rootcol ;
   private com.parks.SdtStringConcatenationUnitTestSDT Gxm1stringconcatenationunittestsdt ;
}


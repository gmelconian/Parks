package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class stringconcatenationunittest extends GXProcedure
{
   public stringconcatenationunittest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( stringconcatenationunittest.class ), "" );
   }

   public stringconcatenationunittest( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12GXV2 = 1 ;
      GXt_objcol_SdtStringConcatenationUnitTestSDT1 = AV11GXV1 ;
      GXv_objcol_SdtStringConcatenationUnitTestSDT2[0] = GXt_objcol_SdtStringConcatenationUnitTestSDT1 ;
      new com.parks.stringconcatenationunittestdata(remoteHandle, context).execute( GXv_objcol_SdtStringConcatenationUnitTestSDT2) ;
      GXt_objcol_SdtStringConcatenationUnitTestSDT1 = GXv_objcol_SdtStringConcatenationUnitTestSDT2[0] ;
      AV11GXV1 = GXt_objcol_SdtStringConcatenationUnitTestSDT1 ;
      while ( AV12GXV2 <= AV11GXV1.size() )
      {
         AV8TestCaseData = (com.parks.SdtStringConcatenationUnitTestSDT)((com.parks.SdtStringConcatenationUnitTestSDT)AV11GXV1.elementAt(-1+AV12GXV2));
         GXt_char3 = "" ;
         GXv_char4[0] = GXt_char3 ;
         new com.parks.stringconcatenation(remoteHandle, context).execute( AV8TestCaseData.getgxTv_SdtStringConcatenationUnitTestSDT_String1(), AV8TestCaseData.getgxTv_SdtStringConcatenationUnitTestSDT_String2(), GXv_char4) ;
         stringconcatenationunittest.this.GXt_char3 = GXv_char4[0] ;
         AV8TestCaseData.setgxTv_SdtStringConcatenationUnitTestSDT_Concatenation( GXt_char3 );
         new gxtest.gxtest.assertstringequals(remoteHandle, context).execute( AV8TestCaseData.getgxTv_SdtStringConcatenationUnitTestSDT_Expectedconcatenation(), AV8TestCaseData.getgxTv_SdtStringConcatenationUnitTestSDT_Concatenation(), GXutil.format( "%1.Expectedconcatenation: %2", AV8TestCaseData.getgxTv_SdtStringConcatenationUnitTestSDT_Testcaseid(), AV8TestCaseData.getgxTv_SdtStringConcatenationUnitTestSDT_Msgconcatenation(), "", "", "", "", "", "", "")) ;
         AV12GXV2 = (int)(AV12GXV2+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11GXV1 = new GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT>(com.parks.SdtStringConcatenationUnitTestSDT.class, "StringConcatenationUnitTestSDT", "Parks", remoteHandle);
      GXt_objcol_SdtStringConcatenationUnitTestSDT1 = new GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT>(com.parks.SdtStringConcatenationUnitTestSDT.class, "StringConcatenationUnitTestSDT", "Parks", remoteHandle);
      GXv_objcol_SdtStringConcatenationUnitTestSDT2 = new GXBaseCollection[1] ;
      AV8TestCaseData = new com.parks.SdtStringConcatenationUnitTestSDT(remoteHandle, context);
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV12GXV2 ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT> AV11GXV1 ;
   private GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT> GXt_objcol_SdtStringConcatenationUnitTestSDT1 ;
   private GXBaseCollection<com.parks.SdtStringConcatenationUnitTestSDT> GXv_objcol_SdtStringConcatenationUnitTestSDT2[] ;
   private com.parks.SdtStringConcatenationUnitTestSDT AV8TestCaseData ;
}


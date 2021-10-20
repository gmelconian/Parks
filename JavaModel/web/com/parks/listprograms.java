package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class listprograms extends GXProcedure
{
   public listprograms( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( listprograms.class ), "" );
   }

   public listprograms( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.parks.SdtProgramNames_ProgramName> executeUdp( )
   {
      listprograms.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.parks.SdtProgramNames_ProgramName>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.parks.SdtProgramNames_ProgramName>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.parks.SdtProgramNames_ProgramName>[] aP0 )
   {
      listprograms.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9ProgramNames = new GXBaseCollection<com.parks.SdtProgramNames_ProgramName>(com.parks.SdtProgramNames_ProgramName.class, "ProgramName", "Parks", remoteHandle) ;
      AV11name = "WWAmusementPark" ;
      AV12description = "Amusement Parks" ;
      AV13link = formatLink("com.parks.wwamusementpark", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11name = "WWCategory" ;
      AV12description = "Categories" ;
      AV13link = formatLink("com.parks.wwcategory", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11name = "WWCountry" ;
      AV12description = "Countries" ;
      AV13link = formatLink("com.parks.wwcountry", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11name = "WWEmployee" ;
      AV12description = "Employees" ;
      AV13link = formatLink("com.parks.wwemployee", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11name = "WWGame" ;
      AV12description = "Games" ;
      AV13link = formatLink("com.parks.wwgame", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11name = "WWRepair" ;
      AV12description = "Repairs" ;
      AV13link = formatLink("com.parks.wwrepair", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11name = "WWShow" ;
      AV12description = "Shows" ;
      AV13link = formatLink("com.parks.wwshow", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11name = "WWTechnician" ;
      AV12description = "Technicians" ;
      AV13link = formatLink("com.parks.wwtechnician", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ADDPROGRAM' Routine */
      returnInSub = false ;
      AV8IsAuthorized = true ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.parks.isauthorized(remoteHandle, context).execute( AV11name, GXv_boolean2) ;
      listprograms.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         AV10ProgramName = (com.parks.SdtProgramNames_ProgramName)new com.parks.SdtProgramNames_ProgramName(remoteHandle, context);
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Name( AV11name );
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Description( AV12description );
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Link( AV13link );
         AV9ProgramNames.add(AV10ProgramName, 0);
      }
   }

   protected void cleanup( )
   {
      this.aP0[0] = listprograms.this.AV9ProgramNames;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ProgramNames = new GXBaseCollection<com.parks.SdtProgramNames_ProgramName>(com.parks.SdtProgramNames_ProgramName.class, "ProgramName", "Parks", remoteHandle);
      AV11name = "" ;
      AV12description = "" ;
      AV13link = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV10ProgramName = new com.parks.SdtProgramNames_ProgramName(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV11name ;
   private String AV12description ;
   private String AV13link ;
   private GXBaseCollection<com.parks.SdtProgramNames_ProgramName>[] aP0 ;
   private GXBaseCollection<com.parks.SdtProgramNames_ProgramName> AV9ProgramNames ;
   private com.parks.SdtProgramNames_ProgramName AV10ProgramName ;
}


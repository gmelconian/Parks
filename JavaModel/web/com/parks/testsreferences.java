package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class testsreferences extends GXProcedure
{
   public testsreferences( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( testsreferences.class ), "" );
   }

   public testsreferences( int remoteHandle ,
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
      returnInSub = true;
      cleanup();
      if (true) return;
      new com.parks.webuitest1(remoteHandle, context).execute( AV8Driver) ;
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
      AV8Driver = new gxtest.gxtest.SdtWebdriver(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean returnInSub ;
   private gxtest.gxtest.SdtWebdriver AV8Driver ;
}


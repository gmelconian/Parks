package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamesbycategoryunittest extends GXProcedure
{
   public gamesbycategoryunittest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamesbycategoryunittest.class ), "" );
   }

   public gamesbycategoryunittest( int remoteHandle ,
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
      httpContext.wjLoc = formatLink("com.parks.agamesbycategory", new String[] {}, new String[] {})  ;
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
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
}


package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamesbycategory2 extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.parks.GXcfg.class);
      gamesbycategory2 pgm = new gamesbycategory2 (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {

      execute();
   }

   public gamesbycategory2( )
   {
      super( -1 , new ModelContext( gamesbycategory2.class ), "" );
      Application.init(com.parks.GXcfg.class);
   }

   public gamesbycategory2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamesbycategory2.class ), "" );
   }

   public gamesbycategory2( int remoteHandle ,
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
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      Application.cleanup(context, this, remoteHandle);
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


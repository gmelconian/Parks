package com.parks ;
import com.parks.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class testsrunner_cline extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.parks.GXcfg.class);
      testsrunner_cline pgm = new testsrunner_cline (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      String aP0 = "";

      try
      {
         aP0 = (String) args[0];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public testsrunner_cline( )
   {
      super( -1 , new ModelContext( testsrunner_cline.class ), "" );
      Application.init(com.parks.GXcfg.class);
   }

   public testsrunner_cline( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( testsrunner_cline.class ), "" );
   }

   public testsrunner_cline( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String aP0 )
   {
      testsrunner_cline.this.AV2ExecutionDataFilePath = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new com.parks.testsrunner(remoteHandle, context).execute( aP0 );
      cleanup();
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
   private String AV2ExecutionDataFilePath ;
}


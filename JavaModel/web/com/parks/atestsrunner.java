package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class atestsrunner extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.parks.GXcfg.class);
      atestsrunner pgm = new atestsrunner (-1);
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

   public atestsrunner( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( atestsrunner.class ), "" );
   }

   public atestsrunner( int remoteHandle ,
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
      atestsrunner.this.AV18ExecutionDataFilePath = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Execute user subroutine: 'LOAD EXECUTION DATA' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV8Cache = com.genexus.util.CacheAPI.getCache( "TESTCACHE");
      /* Execute user subroutine: 'RUN TESTS' */
      S121 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'SAVE RESULTS' */
      S231 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOAD EXECUTION DATA' Routine */
      returnInSub = false ;
      AV20File.setSource( AV18ExecutionDataFilePath );
      AV20File.openRead("");
      if ( ! AV17ExecutionData.fromJSonString(AV20File.readAllText(""), null) )
      {
         System.out.println( "Error loading ExecutionData from "+AV18ExecutionDataFilePath );
         AV20File.close();
         returnInSub = true;
         if (true) return;
      }
      AV20File.close();
   }

   public void S121( )
   {
      /* 'RUN TESTS' Routine */
      returnInSub = false ;
      AV19ExecutionResult.setgxTv_SdtExecutionResult_Start( GXutil.now( ) );
      AV22IsOnSuiteSkipMode = false ;
      AV35GXV1 = 1 ;
      while ( AV35GXV1 <= AV17ExecutionData.getgxTv_SdtExecutionData_Suites().size() )
      {
         AV9CurrentSuite = (gxtest.gxtest.SdtSuite)((gxtest.gxtest.SdtSuite)AV17ExecutionData.getgxTv_SdtExecutionData_Suites().elementAt(-1+AV35GXV1));
         if ( AV22IsOnSuiteSkipMode )
         {
            AV10CurrentSuiteResult = (gxtest.gxtest.SdtSuiteResult)new gxtest.gxtest.SdtSuiteResult(remoteHandle, context);
            AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Name( AV9CurrentSuite.getgxTv_SdtSuite_Name() );
            AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Result( "SKIPPED" );
            System.out.println( "=> Suite "+AV9CurrentSuite.getgxTv_SdtSuite_Name()+" skipped" );
            System.out.println( "---------------------------------------" );
            AV36GXV2 = 1 ;
            while ( AV36GXV2 <= AV9CurrentSuite.getgxTv_SdtSuite_Tests().size() )
            {
               AV11CurrentTest = (gxtest.gxtest.SdtTest)((gxtest.gxtest.SdtTest)AV9CurrentSuite.getgxTv_SdtSuite_Tests().elementAt(-1+AV36GXV2));
               AV23Iterator = (short)(1) ;
               while ( AV23Iterator <= AV11CurrentTest.getgxTv_SdtTest_Iterations() )
               {
                  /* Execute user subroutine: 'SKIP TEST' */
                  S131 ();
                  if (returnInSub) return;
                  AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Testresults().add(AV12CurrentTestResult, 0);
                  AV23Iterator = (short)(AV23Iterator+1) ;
               }
               AV36GXV2 = (int)(AV36GXV2+1) ;
            }
            System.out.println( "---------------------------------------" );
         }
         else
         {
            /* Execute user subroutine: 'RUN SUITE' */
            S141 ();
            if (returnInSub) return;
            AV25SuiteRetries = (short)(0) ;
            while ( ( AV25SuiteRetries < AV9CurrentSuite.getgxTv_SdtSuite_Retriesonerror() ) && ( ( GXutil.strcmp(AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Result(), "EXCEPTION") == 0 ) || ( GXutil.strcmp(AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Result(), "ERROR") == 0 ) ) )
            {
               AV25SuiteRetries = (short)(AV25SuiteRetries+1) ;
               System.out.println( GXutil.format( "Retrying suite %1. Attempt %2 of %3", AV9CurrentSuite.getgxTv_SdtSuite_Name(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25SuiteRetries), 4, 0), GXutil.ltrimstr( AV9CurrentSuite.getgxTv_SdtSuite_Retriesonerror(), 4, 0), "", "", "", "", "", "") );
               /* Execute user subroutine: 'RUN SUITE' */
               S141 ();
               if (returnInSub) return;
               AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Retriesmade( AV25SuiteRetries );
            }
         }
         AV19ExecutionResult.getgxTv_SdtExecutionResult_Suiteresults().add(AV10CurrentSuiteResult, 0);
         if ( ! AV22IsOnSuiteSkipMode && ! AV9CurrentSuite.getgxTv_SdtSuite_Continueonerror() && ( ( GXutil.strcmp(AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Result(), "ERROR") == 0 ) || ( GXutil.strcmp(AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Result(), "EXCEPTION") == 0 ) ) )
         {
            /* Execute user subroutine: 'ENABLE SUITE SKIP MODE' */
            S151 ();
            if (returnInSub) return;
         }
         AV35GXV1 = (int)(AV35GXV1+1) ;
      }
      AV37GXV3 = 1 ;
      while ( AV37GXV3 <= AV17ExecutionData.getgxTv_SdtExecutionData_Tests().size() )
      {
         AV11CurrentTest = (gxtest.gxtest.SdtTest)((gxtest.gxtest.SdtTest)AV17ExecutionData.getgxTv_SdtExecutionData_Tests().elementAt(-1+AV37GXV3));
         if ( GXutil.strcmp(AV11CurrentTest.getgxTv_SdtTest_Testtype(), "Unit") == 0 )
         {
            /* Execute user subroutine: 'RUN UNIT TEST' */
            S161 ();
            if (returnInSub) return;
            AV19ExecutionResult.getgxTv_SdtExecutionResult_Testresults().add(AV12CurrentTestResult, 0);
         }
         else
         {
            if ( GXutil.strcmp(AV11CurrentTest.getgxTv_SdtTest_Testtype(), "Web") == 0 )
            {
               /* Execute user subroutine: 'RUN WEB TEST' */
               S171 ();
               if (returnInSub) return;
               AV19ExecutionResult.getgxTv_SdtExecutionResult_Testresults().add(AV12CurrentTestResult, 0);
            }
         }
         AV37GXV3 = (int)(AV37GXV3+1) ;
      }
      AV19ExecutionResult.setgxTv_SdtExecutionResult_End( GXutil.now( ) );
   }

   public void S141( )
   {
      /* 'RUN SUITE' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'INIT SUITE RESULT' */
      S181 ();
      if (returnInSub) return;
      AV21IsOnSkipMode = false ;
      System.out.println( "STARTING Suite "+AV9CurrentSuite.getgxTv_SdtSuite_Name()+"..." );
      System.out.println( "-----------------------------------" );
      System.out.println( "-----------------------------------" );
      /* User Code */
       try {
      if ( ! (GXutil.strcmp("", AV9CurrentSuite.getgxTv_SdtSuite_Setupobjectname())==0) )
      {
         AV27TestName = AV9CurrentSuite.getgxTv_SdtSuite_Setupobjectname() ;
         System.out.println( GXutil.format( "STARTING set up object %1 for suite %2...", AV9CurrentSuite.getgxTv_SdtSuite_Setupobjectname(), AV9CurrentSuite.getgxTv_SdtSuite_Name(), "", "", "", "", "", "", "") );
         callAux0 = new Object[ 0 ];
         DynamicExecute.dynamicExecute(context, remoteHandle, getClass(),  "com.parks." ,  AV27TestName ,  callAux0 );
         System.out.println( "ENDED Set up: OK" );
         System.out.println( "--------------------" );
      }
      AV38GXV4 = 1 ;
      while ( AV38GXV4 <= AV9CurrentSuite.getgxTv_SdtSuite_Tests().size() )
      {
         AV11CurrentTest = (gxtest.gxtest.SdtTest)((gxtest.gxtest.SdtTest)AV9CurrentSuite.getgxTv_SdtSuite_Tests().elementAt(-1+AV38GXV4));
         AV26TestIterationsResult = true ;
         AV23Iterator = (short)(1) ;
         while ( AV23Iterator <= AV11CurrentTest.getgxTv_SdtTest_Iterations() )
         {
            if ( AV21IsOnSkipMode )
            {
               /* Execute user subroutine: 'SKIP TEST' */
               S131 ();
               if (returnInSub) return;
            }
            else
            {
               AV29TestRetries = (short)(0) ;
               if ( GXutil.strcmp(AV11CurrentTest.getgxTv_SdtTest_Testtype(), "Unit") == 0 )
               {
                  /* Execute user subroutine: 'RUN UNIT TEST' */
                  S161 ();
                  if (returnInSub) return;
                  while ( ( AV29TestRetries < AV11CurrentTest.getgxTv_SdtTest_Retriesonerror() ) && ( ( GXutil.strcmp(AV12CurrentTestResult.getgxTv_SdtTestResult_Result(), "EXCEPTION") == 0 ) || ( GXutil.strcmp(AV12CurrentTestResult.getgxTv_SdtTestResult_Result(), "ERROR") == 0 ) ) )
                  {
                     AV29TestRetries = (short)(AV29TestRetries+1) ;
                     System.out.println( GXutil.format( "Retrying test %1. Attempt %2 of %3", AV11CurrentTest.getgxTv_SdtTest_Name(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TestRetries), 4, 0), GXutil.ltrimstr( AV11CurrentTest.getgxTv_SdtTest_Retriesonerror(), 4, 0), "", "", "", "", "", "") );
                     /* Execute user subroutine: 'RUN UNIT TEST' */
                     S161 ();
                     if (returnInSub) return;
                     AV12CurrentTestResult.setgxTv_SdtTestResult_Retriesmade( AV29TestRetries );
                  }
               }
               else
               {
                  if ( GXutil.strcmp(AV11CurrentTest.getgxTv_SdtTest_Testtype(), "Web") == 0 )
                  {
                     /* Execute user subroutine: 'RUN WEB TEST' */
                     S171 ();
                     if (returnInSub) return;
                     while ( ( AV29TestRetries < AV11CurrentTest.getgxTv_SdtTest_Retriesonerror() ) && ( ( GXutil.strcmp(AV12CurrentTestResult.getgxTv_SdtTestResult_Result(), "EXCEPTION") == 0 ) || ( GXutil.strcmp(AV12CurrentTestResult.getgxTv_SdtTestResult_Result(), "ERROR") == 0 ) ) )
                     {
                        AV29TestRetries = (short)(AV29TestRetries+1) ;
                        System.out.println( GXutil.format( "Retrying test %1. Attempt %2 of %3", AV11CurrentTest.getgxTv_SdtTest_Name(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TestRetries), 4, 0), GXutil.ltrimstr( AV11CurrentTest.getgxTv_SdtTest_Retriesonerror(), 4, 0), "", "", "", "", "", "") );
                        /* Execute user subroutine: 'RUN WEB TEST' */
                        S171 ();
                        if (returnInSub) return;
                        AV12CurrentTestResult.setgxTv_SdtTestResult_Retriesmade( AV29TestRetries );
                     }
                  }
                  else
                  {
                     System.out.println( "Invalid test "+AV11CurrentTest.getgxTv_SdtTest_Name() );
                  }
               }
            }
            AV26TestIterationsResult = (boolean)(AV26TestIterationsResult&&((GXutil.strcmp(AV12CurrentTestResult.getgxTv_SdtTestResult_Result(), "OK")==0)||(GXutil.strcmp(AV12CurrentTestResult.getgxTv_SdtTestResult_Result(), "WARNING")==0))) ;
            if ( ! AV11CurrentTest.getgxTv_SdtTest_Continueonerror() && ! AV26TestIterationsResult )
            {
               /* Execute user subroutine: 'ENABLE SKIP MODE' */
               S191 ();
               if (returnInSub) return;
            }
            AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Testresults().add(AV12CurrentTestResult, 0);
            AV23Iterator = (short)(AV23Iterator+1) ;
         }
         AV38GXV4 = (int)(AV38GXV4+1) ;
      }
      if ( ! (GXutil.strcmp("", AV9CurrentSuite.getgxTv_SdtSuite_Teardownobjectname())==0) )
      {
         AV27TestName = AV9CurrentSuite.getgxTv_SdtSuite_Teardownobjectname() ;
         System.out.println( GXutil.format( "STARTING tear down object %1 for suite %2...", AV9CurrentSuite.getgxTv_SdtSuite_Teardownobjectname(), AV9CurrentSuite.getgxTv_SdtSuite_Name(), "", "", "", "", "", "", "") );
         callAux0 = new Object[ 0 ];
         DynamicExecute.dynamicExecute(context, remoteHandle, getClass(),  "com.parks." ,  AV27TestName ,  callAux0 );
         System.out.println( "ENDED tear down: OK" );
         System.out.println( "--------------------" );
      }
      /* User Code */
       } catch (Exception e) {
      /* User Code */
           java.io.StringWriter sw = new java.io.StringWriter();
      /* User Code */
           java.io.PrintWriter pw = new java.io.PrintWriter(sw, true); e.printStackTrace(pw);
      /* User Code */
           AV16ExceptionStack = sw.getBuffer().toString();
      /* User Code */
           AV15ExceptionMsg = e.getMessage(); }
      /* Execute user subroutine: 'END SUITE INFO' */
      S201 ();
      if (returnInSub) return;
   }

   public void S191( )
   {
      /* 'ENABLE SKIP MODE' Routine */
      returnInSub = false ;
      if ( ! AV21IsOnSkipMode )
      {
         AV21IsOnSkipMode = true ;
         System.out.println( "Skip mode activated since test "+AV12CurrentTestResult.getgxTv_SdtTestResult_Name()+" failed" );
         System.out.println( "----------------------------------------------------------" );
      }
   }

   public void S151( )
   {
      /* 'ENABLE SUITE SKIP MODE' Routine */
      returnInSub = false ;
      if ( ! AV22IsOnSuiteSkipMode && ( AV25SuiteRetries == AV9CurrentSuite.getgxTv_SdtSuite_Retriesonerror() ) )
      {
         AV22IsOnSuiteSkipMode = true ;
         System.out.println( "Skip mode activated since suite "+AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Name()+" failed" );
         System.out.println( "----------------------------------------------------------" );
      }
   }

   public void S131( )
   {
      /* 'SKIP TEST' Routine */
      returnInSub = false ;
      AV12CurrentTestResult = (gxtest.gxtest.SdtTestResult)new gxtest.gxtest.SdtTestResult(remoteHandle, context);
      AV12CurrentTestResult.setgxTv_SdtTestResult_Name( AV11CurrentTest.getgxTv_SdtTest_Name() );
      AV12CurrentTestResult.setgxTv_SdtTestResult_Testtype( AV11CurrentTest.getgxTv_SdtTest_Testtype() );
      AV12CurrentTestResult.setgxTv_SdtTestResult_Result( "SKIPPED" );
      System.out.println( "-> Test "+AV11CurrentTest.getgxTv_SdtTest_Name()+" skipped" );
      System.out.println( "---------------------------------------" );
   }

   public void S181( )
   {
      /* 'INIT SUITE RESULT' Routine */
      returnInSub = false ;
      AV10CurrentSuiteResult = (gxtest.gxtest.SdtSuiteResult)new gxtest.gxtest.SdtSuiteResult(remoteHandle, context);
      AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Name( AV9CurrentSuite.getgxTv_SdtSuite_Name() );
      AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Continueonerror( AV9CurrentSuite.getgxTv_SdtSuite_Continueonerror() );
      AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Retriesonerror( AV9CurrentSuite.getgxTv_SdtSuite_Retriesonerror() );
      AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Setupobjectname( AV9CurrentSuite.getgxTv_SdtSuite_Setupobjectname() );
      AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Teardownobjectname( AV9CurrentSuite.getgxTv_SdtSuite_Teardownobjectname() );
      AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Start( GXutil.now( ) );
      AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Result( "OK" );
      AV15ExceptionMsg = "" ;
      AV16ExceptionStack = "" ;
   }

   public void S201( )
   {
      /* 'END SUITE INFO' Routine */
      returnInSub = false ;
      AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_End( GXutil.now( ) );
      if ( ! (GXutil.strcmp("", AV15ExceptionMsg)==0) )
      {
         AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Result( "EXCEPTION" );
         AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Errormsg( AV15ExceptionMsg );
         AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Errorstack( AV16ExceptionStack );
         System.out.println( AV15ExceptionMsg+GXutil.newLine( )+AV16ExceptionStack );
         AV15ExceptionMsg = "" ;
         AV16ExceptionStack = "" ;
      }
      else
      {
         if ( AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Testresults().size() == 0 )
         {
            AV13DominantResult = "WARNING" ;
         }
         else
         {
            AV13DominantResult = "OK" ;
            AV39GXV5 = 1 ;
            while ( AV39GXV5 <= AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Testresults().size() )
            {
               AV28TestResultIter = (gxtest.gxtest.SdtTestResult)((gxtest.gxtest.SdtTestResult)AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Testresults().elementAt(-1+AV39GXV5));
               if ( GXutil.strcmp(AV28TestResultIter.getgxTv_SdtTestResult_Result(), "EXCEPTION") == 0 )
               {
                  AV13DominantResult = "EXCEPTION" ;
                  if (true) break;
               }
               else if ( ( GXutil.strcmp(AV28TestResultIter.getgxTv_SdtTestResult_Result(), "ERROR") == 0 ) && ( GXutil.strcmp(AV13DominantResult, "ERROR") != 0 ) )
               {
                  AV13DominantResult = "ERROR" ;
               }
               else if ( ( GXutil.strcmp(AV28TestResultIter.getgxTv_SdtTestResult_Result(), "WARNING") == 0 ) && ( GXutil.strcmp(AV13DominantResult, "OK") == 0 ) )
               {
                  AV13DominantResult = "WARNING" ;
               }
               AV39GXV5 = (int)(AV39GXV5+1) ;
            }
         }
         AV10CurrentSuiteResult.setgxTv_SdtSuiteResult_Result( AV13DominantResult );
      }
      System.out.println( "ENDED Suite "+AV9CurrentSuite.getgxTv_SdtSuite_Name()+". Result: "+AV10CurrentSuiteResult.getgxTv_SdtSuiteResult_Result() );
      System.out.println( "-----------------------------------" );
      System.out.println( "-----------------------------------" );
   }

   public void S161( )
   {
      /* 'RUN UNIT TEST' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'INIT TEST RESULT' */
      S211 ();
      if (returnInSub) return;
      AV27TestName = AV11CurrentTest.getgxTv_SdtTest_Name() ;
      System.out.println( "STARTING Unit Test "+AV27TestName+"..." );
      /* User Code */
       try {
      callAux0 = new Object[ 0 ];
      DynamicExecute.dynamicExecute(context, remoteHandle, getClass(),  "com.parks." ,  AV27TestName ,  callAux0 );
      AV12CurrentTestResult.setgxTv_SdtTestResult_Result( "OK" );
      /* User Code */
       } catch (Exception e) {
      /* User Code */
           java.io.StringWriter sw = new java.io.StringWriter();
      /* User Code */
           java.io.PrintWriter pw = new java.io.PrintWriter(sw, true); e.printStackTrace(pw);
      /* User Code */
           AV16ExceptionStack = sw.getBuffer().toString();
      /* User Code */
           AV15ExceptionMsg = e.getMessage(); }
      /* Execute user subroutine: 'END TEST INFO' */
      S221 ();
      if (returnInSub) return;
   }

   public void S171( )
   {
      /* 'RUN WEB TEST' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'INIT TEST RESULT' */
      S211 ();
      if (returnInSub) return;
      AV27TestName = AV11CurrentTest.getgxTv_SdtTest_Name() ;
      System.out.println( "STARTING Web test "+AV27TestName+"..." );
      /* User Code */
       try {
      AV14Driver.setxmlreporterfilepath(AV17ExecutionData.getgxTv_SdtExecutionData_Internalresultsfile());
      AV14Driver.setbrowser(AV17ExecutionData.getgxTv_SdtExecutionData_Websettings().getgxTv_SdtWebSettings_Browser());
      AV14Driver.setbaseurl(AV17ExecutionData.getgxTv_SdtExecutionData_Websettings().getgxTv_SdtWebSettings_Baseurl());
      AV14Driver.setscreenshotmode(AV17ExecutionData.getgxTv_SdtExecutionData_Websettings().getgxTv_SdtWebSettings_Screenshotmode());
      AV14Driver.setverifystopsexecution(AV17ExecutionData.getgxTv_SdtExecutionData_Websettings().getgxTv_SdtWebSettings_Verifystopsexecution());
      AV14Driver.setfullpagescreenshot(AV17ExecutionData.getgxTv_SdtExecutionData_Websettings().getgxTv_SdtWebSettings_Fullpagescreenshot());
      AV14Driver.sethtmlmode(AV17ExecutionData.getgxTv_SdtExecutionData_Websettings().getgxTv_SdtWebSettings_Htmlmode());
      AV14Driver.setfileuploadbasepath(AV17ExecutionData.getgxTv_SdtExecutionData_Websettings().getgxTv_SdtWebSettings_Fileuploadbasepath());
      AV14Driver.setarguments(AV17ExecutionData.getgxTv_SdtExecutionData_Websettings().getgxTv_SdtWebSettings_Arguments());
      GXv_SdtWebdriver1[0] = AV14Driver;
      callAux1 = new Object[ 1 ];
      callAux1 [ 0 ] = GXv_SdtWebdriver1 ;
      DynamicExecute.dynamicExecute(context, remoteHandle, getClass(),  "com.parks." ,  AV27TestName ,  callAux1 );
      AV14Driver = GXv_SdtWebdriver1[0] ;
      AV12CurrentTestResult.setgxTv_SdtTestResult_Result( "OK" );
      /* User Code */
       } catch (Exception e) {
      /* User Code */
           java.io.StringWriter sw = new java.io.StringWriter();
      /* User Code */
           java.io.PrintWriter pw = new java.io.PrintWriter(sw, true); e.printStackTrace(pw);
      /* User Code */
           AV16ExceptionStack = sw.getBuffer().toString();
      /* User Code */
           AV15ExceptionMsg = e.getMessage(); }
      AV14Driver.silentend();
      /* Execute user subroutine: 'END TEST INFO' */
      S221 ();
      if (returnInSub) return;
   }

   public void S211( )
   {
      /* 'INIT TEST RESULT' Routine */
      returnInSub = false ;
      AV12CurrentTestResult = (gxtest.gxtest.SdtTestResult)new gxtest.gxtest.SdtTestResult(remoteHandle, context);
      AV12CurrentTestResult.setgxTv_SdtTestResult_Name( AV11CurrentTest.getgxTv_SdtTest_Name() );
      AV12CurrentTestResult.setgxTv_SdtTestResult_Testtype( AV11CurrentTest.getgxTv_SdtTest_Testtype() );
      AV12CurrentTestResult.setgxTv_SdtTestResult_Continueonerror( AV11CurrentTest.getgxTv_SdtTest_Continueonerror() );
      AV12CurrentTestResult.setgxTv_SdtTestResult_Retriesonerror( AV11CurrentTest.getgxTv_SdtTest_Retriesonerror() );
      AV31TimeStart = GXutil.nowms( ) ;
      AV12CurrentTestResult.setgxTv_SdtTestResult_Start( AV31TimeStart );
      AV8Cache.set("TestName", AV11CurrentTest.getgxTv_SdtTest_Name(), 0);
      new gxtest.gxtest.setsession(remoteHandle, context).execute( "gxtest4", AV12CurrentTestResult.toxml(false, true, "TestResult", "")) ;
      AV15ExceptionMsg = "" ;
      AV16ExceptionStack = "" ;
   }

   public void S221( )
   {
      /* 'END TEST INFO' Routine */
      returnInSub = false ;
      AV30TimeEnd = GXutil.nowms( ) ;
      AV8Cache.set("TestExecutionEnded", AV11CurrentTest.getgxTv_SdtTest_Name(), 0);
      AV12CurrentTestResult.fromxml(new gxtest.gxtest.getsession(remoteHandle, context).executeUdp( "gxtest4"), null, null);
      AV12CurrentTestResult.setgxTv_SdtTestResult_End( AV30TimeEnd );
      AV12CurrentTestResult.setgxTv_SdtTestResult_Elapsedtime( (long)(GXutil.dtdiffms( AV30TimeEnd, AV31TimeStart)*1000) );
      if ( ! (GXutil.strcmp("", AV15ExceptionMsg)==0) )
      {
         AV12CurrentTestResult.setgxTv_SdtTestResult_Result( "EXCEPTION" );
         AV12CurrentTestResult.setgxTv_SdtTestResult_Errormsg( AV15ExceptionMsg );
         AV12CurrentTestResult.setgxTv_SdtTestResult_Errorstack( AV16ExceptionStack );
         System.out.println( AV15ExceptionMsg+GXutil.newLine( )+AV16ExceptionStack );
         AV15ExceptionMsg = "" ;
         AV16ExceptionStack = "" ;
      }
      else
      {
         if ( AV12CurrentTestResult.getgxTv_SdtTestResult_Steps().size() == 0 )
         {
            AV13DominantResult = "WARNING" ;
         }
         else
         {
            AV13DominantResult = "OK" ;
            AV40GXV6 = 1 ;
            while ( AV40GXV6 <= AV12CurrentTestResult.getgxTv_SdtTestResult_Steps().size() )
            {
               AV24StepResultIter = (gxtest.gxtest.SdtStepResult)((gxtest.gxtest.SdtStepResult)AV12CurrentTestResult.getgxTv_SdtTestResult_Steps().elementAt(-1+AV40GXV6));
               if ( GXutil.strcmp(AV24StepResultIter.getgxTv_SdtStepResult_Result(), "EXCEPTION") == 0 )
               {
                  AV13DominantResult = "EXCEPTION" ;
                  if (true) break;
               }
               else if ( ( GXutil.strcmp(AV24StepResultIter.getgxTv_SdtStepResult_Result(), "ERROR") == 0 ) && ( GXutil.strcmp(AV13DominantResult, "ERROR") != 0 ) )
               {
                  AV13DominantResult = "ERROR" ;
               }
               else if ( ( GXutil.strcmp(AV24StepResultIter.getgxTv_SdtStepResult_Result(), "WARNING") == 0 ) && ( GXutil.strcmp(AV13DominantResult, "OK") == 0 ) )
               {
                  AV13DominantResult = "WARNING" ;
               }
               AV40GXV6 = (int)(AV40GXV6+1) ;
            }
         }
         AV12CurrentTestResult.setgxTv_SdtTestResult_Result( AV13DominantResult );
      }
      System.out.println( GXutil.format( "ENDED %1. Result: %2. Elapsed: %3 ms", AV11CurrentTest.getgxTv_SdtTest_Name(), AV12CurrentTestResult.getgxTv_SdtTestResult_Result(), GXutil.ltrimstr( AV12CurrentTestResult.getgxTv_SdtTestResult_Elapsedtime(), 18, 0), "", "", "", "", "", "") );
      System.out.println( "--------------------" );
   }

   public void S231( )
   {
      /* 'SAVE RESULTS' Routine */
      returnInSub = false ;
      AV19ExecutionResult.setgxTv_SdtExecutionResult_Websettings(AV17ExecutionData.getgxTv_SdtExecutionData_Websettings());
      AV32XmlWriter.openURL(AV17ExecutionData.getgxTv_SdtExecutionData_Targetresultsfile());
      AV32XmlWriter.writeStartDocument("UTF-8", (byte)(0));
      AV32XmlWriter.writeRawText(AV19ExecutionResult.toxml(false, true, "ExecutionResult", ""));
      AV32XmlWriter.close();
      new com.parks.testsreferences(remoteHandle, context).execute( ) ;
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(testsrunner.class);
      return new com.parks.GXcfg();
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
      AV8Cache = new com.genexus.util.CacheAPI();
      AV20File = new com.genexus.util.GXFile();
      AV17ExecutionData = new gxtest.gxtest.SdtExecutionData(remoteHandle, context);
      AV19ExecutionResult = new gxtest.gxtest.SdtExecutionResult(remoteHandle, context);
      AV9CurrentSuite = new gxtest.gxtest.SdtSuite(remoteHandle, context);
      AV10CurrentSuiteResult = new gxtest.gxtest.SdtSuiteResult(remoteHandle, context);
      AV11CurrentTest = new gxtest.gxtest.SdtTest(remoteHandle, context);
      AV12CurrentTestResult = new gxtest.gxtest.SdtTestResult(remoteHandle, context);
      AV27TestName = "" ;
      AV16ExceptionStack = "" ;
      AV15ExceptionMsg = "" ;
      AV13DominantResult = "" ;
      AV28TestResultIter = new gxtest.gxtest.SdtTestResult(remoteHandle, context);
      AV14Driver = new gxtest.gxtest.SdtWebdriver(remoteHandle, context);
      GXv_SdtWebdriver1 = new gxtest.gxtest.SdtWebdriver[1] ;
      AV31TimeStart = GXutil.resetTime( GXutil.nullDate() );
      AV30TimeEnd = GXutil.resetTime( GXutil.nullDate() );
      AV24StepResultIter = new gxtest.gxtest.SdtStepResult(remoteHandle, context);
      AV32XmlWriter = new com.genexus.xml.XMLWriter();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV23Iterator ;
   private short AV25SuiteRetries ;
   private short AV29TestRetries ;
   private short Gx_err ;
   private int AV35GXV1 ;
   private int AV36GXV2 ;
   private int AV37GXV3 ;
   private int AV38GXV4 ;
   private int AV39GXV5 ;
   private int AV40GXV6 ;
   private String AV13DominantResult ;
   private java.util.Date AV31TimeStart ;
   private java.util.Date AV30TimeEnd ;
   private boolean returnInSub ;
   private boolean AV22IsOnSuiteSkipMode ;
   private boolean AV21IsOnSkipMode ;
   private boolean AV26TestIterationsResult ;
   private String AV18ExecutionDataFilePath ;
   private String AV27TestName ;
   private String AV16ExceptionStack ;
   private String AV15ExceptionMsg ;
   private com.genexus.util.GXFile AV20File ;
   private gxtest.gxtest.SdtExecutionData AV17ExecutionData ;
   private gxtest.gxtest.SdtExecutionResult AV19ExecutionResult ;
   private Object[] callAux0 ;
   private Object[] callAux1 ;
   private com.genexus.util.CacheAPI AV8Cache ;
   private com.genexus.xml.XMLWriter AV32XmlWriter ;
   private gxtest.gxtest.SdtSuite AV9CurrentSuite ;
   private gxtest.gxtest.SdtTest AV11CurrentTest ;
   private gxtest.gxtest.SdtSuiteResult AV10CurrentSuiteResult ;
   private gxtest.gxtest.SdtTestResult AV12CurrentTestResult ;
   private gxtest.gxtest.SdtTestResult AV28TestResultIter ;
   private gxtest.gxtest.SdtStepResult AV24StepResultIter ;
   private gxtest.gxtest.SdtWebdriver AV14Driver ;
   private gxtest.gxtest.SdtWebdriver GXv_SdtWebdriver1[] ;
}


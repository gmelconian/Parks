package com.parks ;
import com.parks.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.parks.amusementpark", "/com.parks.amusementpark"})
public final  class amusementpark extends GXWebObjectStub
{
   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new amusementpark_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new amusementpark_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Amusement Park";
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

}


gx.evt.autoSkip=!1;gx.define("showshowwc",!0,function(n){var t,i;this.ServerClass="showshowwc";this.PackageName="com.parks";this.ServerFullClass="com.parks.showshowwc";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.anyGridBaseTable=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.SetStandaloneVars=function(){this.AV6ShowId=gx.fn.getIntegerValue("vSHOWID",".");this.AV6ShowId=gx.fn.getIntegerValue("vSHOWID",".")};this.Valid_Amusementparkid=function(){var n=gx.fn.currentGridRowImpl(20);return this.validCliEvt("Valid_Amusementparkid",20,function(){try{if(gx.fn.currentGridRowImpl(20)===0)return!0;var n=gx.util.balloon.getNew("AMUSEMENTPARKID",gx.fn.currentGridRowImpl(20));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Countryid=function(){var n=gx.fn.currentGridRowImpl(20);return this.validCliEvt("Valid_Countryid",20,function(){try{if(gx.fn.currentGridRowImpl(20)===0)return!0;var n=gx.util.balloon.getNew("COUNTRYID",gx.fn.currentGridRowImpl(20));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Cityid=function(){var n=gx.fn.currentGridRowImpl(20);return this.validCliEvt("Valid_Cityid",20,function(){try{if(gx.fn.currentGridRowImpl(20)===0)return!0;var n=gx.util.balloon.getNew("CITYID",gx.fn.currentGridRowImpl(20));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e111i2_client=function(){return this.executeServerEvent("'DOINSERT'",!1,null,!1,!1)};this.e141i2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e151i2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,18,19,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35];this.GXLastCtrlId=35;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",20,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"showshowwc",[],!1,1,!1,!0,0,!0,!1,!1,"",0,"px",0,"px","Nueva fila",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);i=this.GridContainer;i.addSingleLineEdit(7,21,"AMUSEMENTPARKID","Park Id","","AmusementParkId","int",0,"px",4,4,"right",null,[],7,"AmusementParkId",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");i.addSingleLineEdit(8,22,"AMUSEMENTPARKNAME","Park Name","","AmusementParkName","char",0,"px",50,50,"left",null,[],8,"AmusementParkName",!0,0,!1,!1,"DescriptionAttribute",1,"WWColumn");i.addSingleLineEdit(9,23,"AMUSEMENTPARKWEBSITE","Web Site","","AmusementParkWebSite","char",0,"px",60,60,"left",null,[],9,"AmusementParkWebSite",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");i.addSingleLineEdit(10,24,"AMUSEMENTPARKADDRESS","Park Address","","AmusementParkAddress","svchar",0,"px",1024,80,"left",null,[],10,"AmusementParkAddress",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");i.addBitmap(11,"AMUSEMENTPARKPHOTO",25,0,"px",17,"px",null,"","Park Photo","ImageAttribute","WWColumn WWOptionalColumn");i.addSingleLineEdit(12,26,"COUNTRYID","Country Id","","CountryId","int",0,"px",4,4,"right",null,[],12,"CountryId",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");i.addSingleLineEdit(13,27,"COUNTRYNAME","Country Name","","CountryName","char",0,"px",50,50,"left",null,[],13,"CountryName",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");i.addSingleLineEdit(24,28,"CITYID","City Id","","CityId","int",0,"px",4,4,"right",null,[],24,"CityId",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");i.addSingleLineEdit(25,29,"CITYNAME","City Name","","CityName","char",0,"px",50,50,"left",null,[],25,"CityName",!0,0,!1,!1,"Attribute",1,"WWColumn WWOptionalColumn");i.addSingleLineEdit("Update",30,"vUPDATE","","","Update","char",0,"px",20,20,"left",null,[],"Update","Update",!0,0,!1,!1,"TextActionAttribute",1,"WWTextActionColumn");i.addSingleLineEdit("Delete",31,"vDELETE","","","Delete","char",0,"px",20,20,"left",null,[],"Delete","Delete",!0,0,!1,!1,"TextActionAttribute",1,"WWTextActionColumn");this.GridContainer.emptyText="";this.setGrid(i);t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"MAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLETOP",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"BTNINSERT",grid:0,evt:"e111i2_client"};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"GRIDCELL",grid:0};t[14]={id:14,fld:"GRIDTABLE",grid:0};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,fld:"",grid:0};t[21]={id:21,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:this.Valid_Amusementparkid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AMUSEMENTPARKID",gxz:"Z7AmusementParkId",gxold:"O7AmusementParkId",gxvar:"A7AmusementParkId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A7AmusementParkId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z7AmusementParkId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("AMUSEMENTPARKID",n||gx.fn.currentGridRowImpl(20),gx.O.A7AmusementParkId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A7AmusementParkId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("AMUSEMENTPARKID",n||gx.fn.currentGridRowImpl(20),".")},nac:gx.falseFn};t[22]={id:22,lvl:2,type:"char",len:50,dec:0,sign:!1,ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AMUSEMENTPARKNAME",gxz:"Z8AmusementParkName",gxold:"O8AmusementParkName",gxvar:"A8AmusementParkName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A8AmusementParkName=n)},v2z:function(n){n!==undefined&&(gx.O.Z8AmusementParkName=n)},v2c:function(n){gx.fn.setGridControlValue("AMUSEMENTPARKNAME",n||gx.fn.currentGridRowImpl(20),gx.O.A8AmusementParkName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A8AmusementParkName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("AMUSEMENTPARKNAME",n||gx.fn.currentGridRowImpl(20))},nac:gx.falseFn};t[23]={id:23,lvl:2,type:"char",len:60,dec:0,sign:!1,ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AMUSEMENTPARKWEBSITE",gxz:"Z9AmusementParkWebSite",gxold:"O9AmusementParkWebSite",gxvar:"A9AmusementParkWebSite",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A9AmusementParkWebSite=n)},v2z:function(n){n!==undefined&&(gx.O.Z9AmusementParkWebSite=n)},v2c:function(n){gx.fn.setGridControlValue("AMUSEMENTPARKWEBSITE",n||gx.fn.currentGridRowImpl(20),gx.O.A9AmusementParkWebSite,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A9AmusementParkWebSite=this.val(n))},val:function(n){return gx.fn.getGridControlValue("AMUSEMENTPARKWEBSITE",n||gx.fn.currentGridRowImpl(20))},nac:gx.falseFn};t[24]={id:24,lvl:2,type:"svchar",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AMUSEMENTPARKADDRESS",gxz:"Z10AmusementParkAddress",gxold:"O10AmusementParkAddress",gxvar:"A10AmusementParkAddress",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A10AmusementParkAddress=n)},v2z:function(n){n!==undefined&&(gx.O.Z10AmusementParkAddress=n)},v2c:function(n){gx.fn.setGridControlValue("AMUSEMENTPARKADDRESS",n||gx.fn.currentGridRowImpl(20),gx.O.A10AmusementParkAddress,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A10AmusementParkAddress=this.val(n))},val:function(n){return gx.fn.getGridControlValue("AMUSEMENTPARKADDRESS",n||gx.fn.currentGridRowImpl(20))},nac:gx.falseFn};t[25]={id:25,lvl:2,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AMUSEMENTPARKPHOTO",gxz:"Z11AmusementParkPhoto",gxold:"O11AmusementParkPhoto",gxvar:"A11AmusementParkPhoto",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A11AmusementParkPhoto=n)},v2z:function(n){n!==undefined&&(gx.O.Z11AmusementParkPhoto=n)},v2c:function(n){gx.fn.setGridMultimediaValue("AMUSEMENTPARKPHOTO",n||gx.fn.currentGridRowImpl(20),gx.O.A11AmusementParkPhoto,gx.O.A40000AmusementParkPhoto_GXI)},c2v:function(n){gx.O.A40000AmusementParkPhoto_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.A11AmusementParkPhoto=this.val(n))},val:function(n){return gx.fn.getGridControlValue("AMUSEMENTPARKPHOTO",n||gx.fn.currentGridRowImpl(20))},val_GXI:function(n){return gx.fn.getGridControlValue("AMUSEMENTPARKPHOTO_GXI",n||gx.fn.currentGridRowImpl(20))},gxvar_GXI:"A40000AmusementParkPhoto_GXI",nac:gx.falseFn};t[26]={id:26,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:this.Valid_Countryid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COUNTRYID",gxz:"Z12CountryId",gxold:"O12CountryId",gxvar:"A12CountryId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A12CountryId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z12CountryId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("COUNTRYID",n||gx.fn.currentGridRowImpl(20),gx.O.A12CountryId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A12CountryId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("COUNTRYID",n||gx.fn.currentGridRowImpl(20),".")},nac:gx.falseFn};t[27]={id:27,lvl:2,type:"char",len:50,dec:0,sign:!1,ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COUNTRYNAME",gxz:"Z13CountryName",gxold:"O13CountryName",gxvar:"A13CountryName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A13CountryName=n)},v2z:function(n){n!==undefined&&(gx.O.Z13CountryName=n)},v2c:function(n){gx.fn.setGridControlValue("COUNTRYNAME",n||gx.fn.currentGridRowImpl(20),gx.O.A13CountryName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A13CountryName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("COUNTRYNAME",n||gx.fn.currentGridRowImpl(20))},nac:gx.falseFn};t[28]={id:28,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:this.Valid_Cityid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CITYID",gxz:"Z24CityId",gxold:"O24CityId",gxvar:"A24CityId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A24CityId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z24CityId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("CITYID",n||gx.fn.currentGridRowImpl(20),gx.O.A24CityId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A24CityId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("CITYID",n||gx.fn.currentGridRowImpl(20),".")},nac:gx.falseFn};t[29]={id:29,lvl:2,type:"char",len:50,dec:0,sign:!1,ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CITYNAME",gxz:"Z25CityName",gxold:"O25CityName",gxvar:"A25CityName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A25CityName=n)},v2z:function(n){n!==undefined&&(gx.O.Z25CityName=n)},v2c:function(n){gx.fn.setGridControlValue("CITYNAME",n||gx.fn.currentGridRowImpl(20),gx.O.A25CityName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A25CityName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("CITYNAME",n||gx.fn.currentGridRowImpl(20))},nac:gx.falseFn};t[30]={id:30,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vUPDATE",gxz:"ZV12Update",gxold:"OV12Update",gxvar:"AV12Update",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV12Update=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12Update=n)},v2c:function(n){gx.fn.setGridControlValue("vUPDATE",n||gx.fn.currentGridRowImpl(20),gx.O.AV12Update,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV12Update=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vUPDATE",n||gx.fn.currentGridRowImpl(20))},nac:gx.falseFn};t[31]={id:31,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:20,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDELETE",gxz:"ZV13Delete",gxold:"OV13Delete",gxvar:"AV13Delete",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV13Delete=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13Delete=n)},v2c:function(n){gx.fn.setGridControlValue("vDELETE",n||gx.fn.currentGridRowImpl(20),gx.O.AV13Delete,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV13Delete=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDELETE",n||gx.fn.currentGridRowImpl(20))},nac:gx.falseFn};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"",grid:0};t[35]={id:35,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SHOWID",gxz:"Z14ShowId",gxold:"O14ShowId",gxvar:"A14ShowId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A14ShowId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z14ShowId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("SHOWID",gx.O.A14ShowId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A14ShowId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SHOWID",".")},nac:gx.falseFn};this.declareDomainHdlr(35,function(){});this.Z7AmusementParkId=0;this.O7AmusementParkId=0;this.Z8AmusementParkName="";this.O8AmusementParkName="";this.Z9AmusementParkWebSite="";this.O9AmusementParkWebSite="";this.Z10AmusementParkAddress="";this.O10AmusementParkAddress="";this.Z11AmusementParkPhoto="";this.O11AmusementParkPhoto="";this.Z12CountryId=0;this.O12CountryId=0;this.Z13CountryName="";this.O13CountryName="";this.Z24CityId=0;this.O24CityId=0;this.Z25CityName="";this.O25CityName="";this.ZV12Update="";this.OV12Update="";this.ZV13Delete="";this.OV13Delete="";this.A14ShowId=0;this.Z14ShowId=0;this.O14ShowId=0;this.A14ShowId=0;this.A40000AmusementParkPhoto_GXI="";this.AV6ShowId=0;this.A7AmusementParkId=0;this.A8AmusementParkName="";this.A9AmusementParkWebSite="";this.A10AmusementParkAddress="";this.A11AmusementParkPhoto="";this.A12CountryId=0;this.A13CountryName="";this.A24CityId=0;this.A25CityName="";this.AV12Update="";this.AV13Delete="";this.Events={e111i2_client:["'DOINSERT'",!0],e141i2_client:["ENTER",!0],e151i2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6ShowId",fld:"vSHOWID",pic:"ZZZ9"},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""},{av:"sPrefix"}],[]];this.EvtParms.START=[[{av:"AV17Pgmname",fld:"vPGMNAME",pic:""},{av:"AV6ShowId",fld:"vSHOWID",pic:"ZZZ9"}],[{ctrl:"GRID",prop:"Rows"},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""},{av:'gx.fn.getCtrlProperty("SHOWID","Visible")',ctrl:"SHOWID",prop:"Visible"}]];this.EvtParms["GRID.LOAD"]=[[{av:"A7AmusementParkId",fld:"AMUSEMENTPARKID",pic:"ZZZ9",hsh:!0},{av:"A12CountryId",fld:"COUNTRYID",pic:"ZZZ9"}],[{av:'gx.fn.getCtrlProperty("vUPDATE","Link")',ctrl:"vUPDATE",prop:"Link"},{av:'gx.fn.getCtrlProperty("vDELETE","Link")',ctrl:"vDELETE",prop:"Link"},{av:'gx.fn.getCtrlProperty("AMUSEMENTPARKNAME","Link")',ctrl:"AMUSEMENTPARKNAME",prop:"Link"},{av:'gx.fn.getCtrlProperty("COUNTRYNAME","Link")',ctrl:"COUNTRYNAME",prop:"Link"}]];this.EvtParms["'DOINSERT'"]=[[{av:"A7AmusementParkId",fld:"AMUSEMENTPARKID",pic:"ZZZ9",hsh:!0}],[]];this.EvtParms.GRID_FIRSTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6ShowId",fld:"vSHOWID",pic:"ZZZ9"},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""},{av:"sPrefix"}],[]];this.EvtParms.GRID_PREVPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6ShowId",fld:"vSHOWID",pic:"ZZZ9"},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""},{av:"sPrefix"}],[]];this.EvtParms.GRID_NEXTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6ShowId",fld:"vSHOWID",pic:"ZZZ9"},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""},{av:"sPrefix"}],[]];this.EvtParms.GRID_LASTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6ShowId",fld:"vSHOWID",pic:"ZZZ9"},{av:"AV12Update",fld:"vUPDATE",pic:""},{av:"AV13Delete",fld:"vDELETE",pic:""},{av:"sPrefix"}],[]];this.EvtParms.VALID_AMUSEMENTPARKID=[[],[]];this.EvtParms.VALID_COUNTRYID=[[],[]];this.EvtParms.VALID_CITYID=[[],[]];this.setVCMap("AV6ShowId","vSHOWID",0,"int",4,0);this.setVCMap("AV6ShowId","vSHOWID",0,"int",4,0);this.setVCMap("AV6ShowId","vSHOWID",0,"int",4,0);i.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});i.addRefreshingVar({rfrVar:"AV6ShowId"});i.addRefreshingVar({rfrVar:"AV12Update",rfrProp:"Value",gxAttId:"Update"});i.addRefreshingVar({rfrVar:"AV13Delete",rfrProp:"Value",gxAttId:"Delete"});i.addRefreshingParm({rfrVar:"AV6ShowId"});i.addRefreshingParm({rfrVar:"AV12Update",rfrProp:"Value",gxAttId:"Update"});i.addRefreshingParm({rfrVar:"AV13Delete",rfrProp:"Value",gxAttId:"Delete"});this.Initialize()})
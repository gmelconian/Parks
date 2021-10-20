gx.evt.autoSkip=!1;gx.define("amusementpark",!1,function(){var n,t;this.ServerClass="amusementpark";this.PackageName="com.parks";this.ServerFullClass="com.parks.amusementpark";this.setObjectType("trn");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.SetStandaloneVars=function(){this.AV7AmusementParkId=gx.fn.getIntegerValue("vAMUSEMENTPARKID",".");this.AV11Insert_CountryId=gx.fn.getIntegerValue("vINSERT_COUNTRYID",".");this.AV12Insert_CityId=gx.fn.getIntegerValue("vINSERT_CITYID",".");this.A40000AmusementParkPhoto_GXI=gx.fn.getControlValue("AMUSEMENTPARKPHOTO_GXI");this.AV14Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE");this.AV9TrnContext=gx.fn.getControlValue("vTRNCONTEXT")};this.Valid_Amusementparkid=function(){return this.validCliEvt("Valid_Amusementparkid",0,function(){try{var n=gx.util.balloon.getNew("AMUSEMENTPARKID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Countryid=function(){return this.validSrvEvt("valid_Countryid",0).then(function(n){return n}.closure(this))};this.Valid_Cityid=function(){return this.validSrvEvt("valid_Cityid",0).then(function(n){return n}.closure(this))};this.Valid_Showid=function(){var t=gx.fn.currentGridRowImpl(83),n;return gx.fn.currentGridRowImpl(83)===0?!0:(n=gx.util.balloon.getNew("SHOWID",gx.fn.currentGridRowImpl(83)),gx.fn.gridDuplicateKey(84))?(n.setError(gx.text.format(gx.getMessage("GXM_1004"),"Show","","","","","","","","")),this.AnyError=gx.num.trunc(1,0),n.show()):this.validSrvEvt("valid_Showid",83).then(function(n){try{this.sMode12=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(12,83);this.standaloneModal0212();this.standaloneNotModal0212()}finally{this.Gx_mode=this.sMode12}return n}.closure(this))};this.standaloneModal0212=function(){try{gx.text.compare(this.Gx_mode,"INS")!=0?gx.fn.setCtrlProperty("SHOWID","Enabled",0):gx.fn.setCtrlProperty("SHOWID","Enabled",1)}catch(n){}};this.standaloneNotModal0212=function(){};this.e12022_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e13022_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e14022_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,84,85,86,87,88,89,90,91,92,93,94,95,96,97];this.GXLastCtrlId=97;this.Gridamusementpark_showContainer=new gx.grid.grid(this,12,"Show",83,"Gridamusementpark_show","Gridamusementpark_show","Gridamusementpark_showContainer",this.CmpContext,this.IsMasterPage,"amusementpark",[14],!1,1,!1,!0,5,!1,!1,!1,"",0,"px",0,"px","Nueva fila",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.Gridamusementpark_showContainer;t.addSingleLineEdit(14,84,"SHOWID","Show Id","","ShowId","int",0,"px",4,4,"right",null,[],14,"ShowId",!0,0,!1,!1,"Attribute",1,"");t.addBitmap("prompt_14","PROMPT_14",97,0,"",0,"",null,"","","gx-prompt Image","");t.addSingleLineEdit(15,85,"SHOWNAME","Show Name","","ShowName","char",0,"px",50,50,"left",null,[],15,"ShowName",!0,0,!1,!1,"Attribute",1,"");this.Gridamusementpark_showContainer.emptyText="";this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TITLECONTAINER",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"FORMCONTAINER",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"TOOLBARCELL",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"BTN_FIRST",grid:0,evt:"e15022_client",std:"FIRST"};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"BTN_PREVIOUS",grid:0,evt:"e16022_client",std:"PREVIOUS"};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"BTN_NEXT",grid:0,evt:"e17022_client",std:"NEXT"};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"BTN_LAST",grid:0,evt:"e18022_client",std:"LAST"};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"BTN_SELECT",grid:0,evt:"e19022_client",std:"SELECT"};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[34]={id:34,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Amusementparkid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Gridamusementpark_showContainer],fld:"AMUSEMENTPARKID",gxz:"Z7AmusementParkId",gxold:"O7AmusementParkId",gxvar:"A7AmusementParkId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A7AmusementParkId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z7AmusementParkId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("AMUSEMENTPARKID",gx.O.A7AmusementParkId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A7AmusementParkId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("AMUSEMENTPARKID",".")},nac:gx.falseFn};this.declareDomainHdlr(34,function(){});n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};n[39]={id:39,lvl:0,type:"char",len:50,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AMUSEMENTPARKNAME",gxz:"Z8AmusementParkName",gxold:"O8AmusementParkName",gxvar:"A8AmusementParkName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A8AmusementParkName=n)},v2z:function(n){n!==undefined&&(gx.O.Z8AmusementParkName=n)},v2c:function(){gx.fn.setControlValue("AMUSEMENTPARKNAME",gx.O.A8AmusementParkName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A8AmusementParkName=this.val())},val:function(){return gx.fn.getControlValue("AMUSEMENTPARKNAME")},nac:gx.falseFn};this.declareDomainHdlr(39,function(){});n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"",grid:0};n[44]={id:44,lvl:0,type:"char",len:60,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AMUSEMENTPARKWEBSITE",gxz:"Z9AmusementParkWebSite",gxold:"O9AmusementParkWebSite",gxvar:"A9AmusementParkWebSite",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A9AmusementParkWebSite=n)},v2z:function(n){n!==undefined&&(gx.O.Z9AmusementParkWebSite=n)},v2c:function(){gx.fn.setControlValue("AMUSEMENTPARKWEBSITE",gx.O.A9AmusementParkWebSite,0)},c2v:function(){this.val()!==undefined&&(gx.O.A9AmusementParkWebSite=this.val())},val:function(){return gx.fn.getControlValue("AMUSEMENTPARKWEBSITE")},nac:gx.falseFn};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,lvl:0,type:"svchar",len:1024,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AMUSEMENTPARKADDRESS",gxz:"Z10AmusementParkAddress",gxold:"O10AmusementParkAddress",gxvar:"A10AmusementParkAddress",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A10AmusementParkAddress=n)},v2z:function(n){n!==undefined&&(gx.O.Z10AmusementParkAddress=n)},v2c:function(){gx.fn.setControlValue("AMUSEMENTPARKADDRESS",gx.O.A10AmusementParkAddress,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A10AmusementParkAddress=this.val())},val:function(){return gx.fn.getControlValue("AMUSEMENTPARKADDRESS")},nac:gx.falseFn};this.declareDomainHdlr(49,function(){gx.fn.setCtrlProperty("AMUSEMENTPARKADDRESS","Link",gx.fn.getCtrlProperty("AMUSEMENTPARKADDRESS","Enabled")?"":"http://maps.google.com/maps?q="+encodeURIComponent(this.A10AmusementParkAddress))});n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,fld:"",grid:0};n[54]={id:54,lvl:0,type:"bits",len:1024,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AMUSEMENTPARKPHOTO",gxz:"Z11AmusementParkPhoto",gxold:"O11AmusementParkPhoto",gxvar:"A11AmusementParkPhoto",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A11AmusementParkPhoto=n)},v2z:function(n){n!==undefined&&(gx.O.Z11AmusementParkPhoto=n)},v2c:function(){gx.fn.setMultimediaValue("AMUSEMENTPARKPHOTO",gx.O.A11AmusementParkPhoto,gx.O.A40000AmusementParkPhoto_GXI)},c2v:function(){gx.O.A40000AmusementParkPhoto_GXI=this.val_GXI();this.val()!==undefined&&(gx.O.A11AmusementParkPhoto=this.val())},val:function(){return gx.fn.getBlobValue("AMUSEMENTPARKPHOTO")},val_GXI:function(){return gx.fn.getControlValue("AMUSEMENTPARKPHOTO_GXI")},gxvar_GXI:"A40000AmusementParkPhoto_GXI",nac:gx.falseFn};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Countryid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COUNTRYID",gxz:"Z12CountryId",gxold:"O12CountryId",gxvar:"A12CountryId",ucs:[],op:[64],ip:[64,59],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A12CountryId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z12CountryId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("COUNTRYID",gx.O.A12CountryId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A12CountryId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("COUNTRYID",".")},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(0==this.AV11Insert_CountryId)}};this.declareDomainHdlr(59,function(){});n[60]={id:60,fld:"",grid:0};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"",grid:0};n[63]={id:63,fld:"",grid:0};n[64]={id:64,lvl:0,type:"char",len:50,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COUNTRYNAME",gxz:"Z13CountryName",gxold:"O13CountryName",gxvar:"A13CountryName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A13CountryName=n)},v2z:function(n){n!==undefined&&(gx.O.Z13CountryName=n)},v2c:function(){gx.fn.setControlValue("COUNTRYNAME",gx.O.A13CountryName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A13CountryName=this.val())},val:function(){return gx.fn.getControlValue("COUNTRYNAME")},nac:gx.falseFn};this.declareDomainHdlr(64,function(){});n[65]={id:65,fld:"",grid:0};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"",grid:0};n[68]={id:68,fld:"",grid:0};n[69]={id:69,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Cityid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CITYID",gxz:"Z24CityId",gxold:"O24CityId",gxvar:"A24CityId",ucs:[],op:[74],ip:[74,69,59],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A24CityId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z24CityId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CITYID",gx.O.A24CityId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A24CityId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CITYID",".")},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(0==this.AV12Insert_CityId)}};this.declareDomainHdlr(69,function(){});n[70]={id:70,fld:"",grid:0};n[71]={id:71,fld:"",grid:0};n[72]={id:72,fld:"",grid:0};n[73]={id:73,fld:"",grid:0};n[74]={id:74,lvl:0,type:"char",len:50,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CITYNAME",gxz:"Z25CityName",gxold:"O25CityName",gxvar:"A25CityName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A25CityName=n)},v2z:function(n){n!==undefined&&(gx.O.Z25CityName=n)},v2c:function(){gx.fn.setControlValue("CITYNAME",gx.O.A25CityName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A25CityName=this.val())},val:function(){return gx.fn.getControlValue("CITYNAME")},nac:gx.falseFn};this.declareDomainHdlr(74,function(){});n[75]={id:75,fld:"",grid:0};n[76]={id:76,fld:"",grid:0};n[77]={id:77,fld:"SHOWTABLE",grid:0};n[78]={id:78,fld:"",grid:0};n[79]={id:79,fld:"",grid:0};n[80]={id:80,fld:"TITLESHOW",format:0,grid:0,ctrltype:"textblock"};n[81]={id:81,fld:"",grid:0};n[82]={id:82,fld:"",grid:0};n[84]={id:84,lvl:12,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,isacc:1,grid:83,gxgrid:this.Gridamusementpark_showContainer,fnc:this.Valid_Showid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SHOWID",gxz:"Z14ShowId",gxold:"O14ShowId",gxvar:"A14ShowId",ucs:[],op:[85],ip:[85,84],nacdep:[],ctrltype:"edit",inputType:"number",v2v:function(n){n!==undefined&&(gx.O.A14ShowId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z14ShowId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("SHOWID",n||gx.fn.currentGridRowImpl(83),gx.O.A14ShowId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A14ShowId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("SHOWID",n||gx.fn.currentGridRowImpl(83),".")},nac:gx.falseFn};n[85]={id:85,lvl:12,type:"char",len:50,dec:0,sign:!1,ro:1,isacc:1,grid:83,gxgrid:this.Gridamusementpark_showContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SHOWNAME",gxz:"Z15ShowName",gxold:"O15ShowName",gxvar:"A15ShowName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A15ShowName=n)},v2z:function(n){n!==undefined&&(gx.O.Z15ShowName=n)},v2c:function(n){gx.fn.setGridControlValue("SHOWNAME",n||gx.fn.currentGridRowImpl(83),gx.O.A15ShowName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A15ShowName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("SHOWNAME",n||gx.fn.currentGridRowImpl(83))},nac:gx.falseFn};n[86]={id:86,fld:"",grid:0};n[87]={id:87,fld:"",grid:0};n[88]={id:88,fld:"",grid:0};n[89]={id:89,fld:"",grid:0};n[90]={id:90,fld:"BTN_ENTER",grid:0,evt:"e13022_client",std:"ENTER"};n[91]={id:91,fld:"",grid:0};n[92]={id:92,fld:"BTN_CANCEL",grid:0,evt:"e14022_client"};n[93]={id:93,fld:"",grid:0};n[94]={id:94,fld:"BTN_DELETE",grid:0,evt:"e20022_client",std:"DELETE"};n[95]={id:95,fld:"PROMPT_12",grid:2};n[96]={id:96,fld:"PROMPT_24",grid:2};n[97]={id:97,fld:"PROMPT_14",grid:12};this.A7AmusementParkId=0;this.Z7AmusementParkId=0;this.O7AmusementParkId=0;this.A8AmusementParkName="";this.Z8AmusementParkName="";this.O8AmusementParkName="";this.A9AmusementParkWebSite="";this.Z9AmusementParkWebSite="";this.O9AmusementParkWebSite="";this.A10AmusementParkAddress="";this.Z10AmusementParkAddress="";this.O10AmusementParkAddress="";this.A40000AmusementParkPhoto_GXI="";this.A11AmusementParkPhoto="";this.Z11AmusementParkPhoto="";this.O11AmusementParkPhoto="";this.A12CountryId=0;this.Z12CountryId=0;this.O12CountryId=0;this.A13CountryName="";this.Z13CountryName="";this.O13CountryName="";this.A24CityId=0;this.Z24CityId=0;this.O24CityId=0;this.A25CityName="";this.Z25CityName="";this.O25CityName="";this.Z14ShowId=0;this.O14ShowId=0;this.Z15ShowName="";this.O15ShowName="";this.A14ShowId=0;this.A15ShowName="";this.A40000AmusementParkPhoto_GXI="";this.AV14Pgmname="";this.AV9TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV11Insert_CountryId=0;this.AV12Insert_CityId=0;this.AV15GXV1=0;this.AV13TrnContextAtt={AttributeName:"",AttributeValue:""};this.AV7AmusementParkId=0;this.AV10WebSession={};this.A7AmusementParkId=0;this.A12CountryId=0;this.A24CityId=0;this.A8AmusementParkName="";this.A9AmusementParkWebSite="";this.A10AmusementParkAddress="";this.A11AmusementParkPhoto="";this.A13CountryName="";this.A25CityName="";this.Gx_mode="";this.Events={e12022_client:["AFTER TRN",!0],e13022_client:["ENTER",!0],e14022_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7AmusementParkId",fld:"vAMUSEMENTPARKID",pic:"ZZZ9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV9TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0},{av:"AV7AmusementParkId",fld:"vAMUSEMENTPARKID",pic:"ZZZ9",hsh:!0},{av:"A7AmusementParkId",fld:"AMUSEMENTPARKID",pic:"ZZZ9"}],[]];this.EvtParms.START=[[{av:"AV14Pgmname",fld:"vPGMNAME",pic:""},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0}],[{av:"AV9TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0},{av:"AV11Insert_CountryId",fld:"vINSERT_COUNTRYID",pic:"ZZZ9"},{av:"AV12Insert_CityId",fld:"vINSERT_CITYID",pic:"ZZZ9"},{av:"AV15GXV1",fld:"vGXV1",pic:"99999999"},{av:"AV13TrnContextAtt",fld:"vTRNCONTEXTATT",pic:""}]];this.EvtParms["AFTER TRN"]=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV9TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0}],[]];this.EvtParms.VALID_AMUSEMENTPARKID=[[],[]];this.EvtParms.VALID_COUNTRYID=[[{av:"A12CountryId",fld:"COUNTRYID",pic:"ZZZ9"},{av:"A13CountryName",fld:"COUNTRYNAME",pic:""}],[{av:"A13CountryName",fld:"COUNTRYNAME",pic:""}]];this.EvtParms.VALID_CITYID=[[{av:"A12CountryId",fld:"COUNTRYID",pic:"ZZZ9"},{av:"A24CityId",fld:"CITYID",pic:"ZZZ9"},{av:"A25CityName",fld:"CITYNAME",pic:""}],[{av:"A25CityName",fld:"CITYNAME",pic:""}]];this.EvtParms.VALID_SHOWID=[[{av:"A14ShowId",fld:"SHOWID",pic:"ZZZ9"},{av:"A15ShowName",fld:"SHOWNAME",pic:""}],[{av:"A15ShowName",fld:"SHOWNAME",pic:""}]];this.setPrompt("PROMPT_12",[59]);this.setPrompt("PROMPT_24",[69]);this.setPrompt("PROMPT_14",[84]);this.EnterCtrl=["BTN_ENTER"];this.setVCMap("AV7AmusementParkId","vAMUSEMENTPARKID",0,"int",4,0);this.setVCMap("AV11Insert_CountryId","vINSERT_COUNTRYID",0,"int",4,0);this.setVCMap("AV12Insert_CityId","vINSERT_CITYID",0,"int",4,0);this.setVCMap("A40000AmusementParkPhoto_GXI","AMUSEMENTPARKPHOTO_GXI",0,"svchar",2048,0);this.setVCMap("AV14Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV9TrnContext","vTRNCONTEXT",0,"TransactionContext",0,0);t.addPostingVar({rfrVar:"Gx_mode"});this.Initialize()});gx.wi(function(){gx.createParentObj(this.amusementpark)})
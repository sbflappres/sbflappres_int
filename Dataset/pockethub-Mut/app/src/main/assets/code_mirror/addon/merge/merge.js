'use strict';(function(n){"object"==typeof exports&&"object"==typeof module?n(require("../../lib/codemirror")):"function"==typeof define&&define.amd?define(["../../lib/codemirror","diff_match_patch"],n):n(CodeMirror)})(function(n){function A(a,b){this.mv=a;this.type=b;this.classes="left"==b?{chunk:"CodeMirror-merge-l-chunk",start:"CodeMirror-merge-l-chunk-start",end:"CodeMirror-merge-l-chunk-end",insert:"CodeMirror-merge-l-inserted",del:"CodeMirror-merge-l-deleted",connect:"CodeMirror-merge-l-connect"}:
{chunk:"CodeMirror-merge-r-chunk",start:"CodeMirror-merge-r-chunk-start",end:"CodeMirror-merge-r-chunk-end",insert:"CodeMirror-merge-r-inserted",del:"CodeMirror-merge-r-deleted",connect:"CodeMirror-merge-r-connect"}}function z(a){a.diffOutOfDate&&(a.diff=L(a.orig.getValue(),a.edit.getValue()),a.chunks=M(a.diff),a.diffOutOfDate=!1,n.signal(a.edit,"updateDiff",a.diff))}function aa(a){function b(b){B=!0;h=!1;"full"==b&&(a.svg&&C(a.svg),a.copyButtons&&C(a.copyButtons),G(a.edit,e.marked,a.classes),G(a.orig,
k.marked,a.classes),e.from=e.to=k.from=k.to=0);z(a);a.showDifferences&&(N(a.edit,a.diff,e,DIFF_INSERT,a.classes),N(a.orig,a.diff,k,DIFF_DELETE,a.classes));x(a);"align"==a.mv.options.connect&&H(a);B=!1}function c(b){B||(a.dealigned=!0,f(b))}function f(a){B||h||(clearTimeout(g),!0===a&&(h=!0),g=setTimeout(b,!0===a?20:250))}function d(b,d){a.diffOutOfDate||(a.diffOutOfDate=!0,e.from=e.to=k.from=k.to=0);c(d.text.length-1!=d.to.line-d.from.line)}var e={from:0,to:0,marked:[]},k={from:0,to:0,marked:[]},
g,h=!1;a.edit.on("change",d);a.orig.on("change",d);a.edit.on("markerAdded",c);a.edit.on("markerCleared",c);a.orig.on("markerAdded",c);a.orig.on("markerCleared",c);a.edit.on("viewportChange",function(){f(!1)});a.orig.on("viewportChange",function(){f(!1)});b();return b}function ba(a){a.edit.on("scroll",function(){I(a,DIFF_INSERT)&&x(a)});a.orig.on("scroll",function(){I(a,DIFF_DELETE)&&x(a)})}function I(a,b){var c,f;if(a.diffOutOfDate)return!1;if(!a.lockScroll)return!0;var d,e,k=+new Date;b==DIFF_INSERT?
(d=a.edit,e=a.orig):(d=a.orig,e=a.edit);if(d.state.scrollSetBy==a&&(d.state.scrollSetAt||0)+50>k)return!1;var g=d.getScrollInfo();if("align"==a.mv.options.connect)l=g.top;else{var h=.5*g.clientHeight,l=g.top+h;c=d.lineAtHeight(l,"local");for(var m=a.chunks,n=b==DIFF_INSERT,u,t,p,r=0;r<m.length;r++){var v=m[r],O=n?v.editFrom:v.origFrom,q=n?v.editTo:v.origTo;null==t&&(O>c?(t=v.editFrom,p=v.origFrom):q>c&&(t=v.editTo,p=v.origTo));q<=c?(u=v.editTo,f=v.origTo):O<=c&&(u=v.editFrom,f=v.origFrom)}c={before:u,
after:t};f={before:f,after:p};d=P(d,b==DIFF_INSERT?c:f);b=P(e,b==DIFF_INSERT?f:c);var l=b.top-h+(l-d.top)/(d.bot-d.top)*(b.bot-b.top),y;l>g.top&&1>(y=g.top/h)?l=l*y+g.top*(1-y):(b=g.height-g.clientHeight-g.top)<h&&(d=e.getScrollInfo(),d.height-d.clientHeight-l>b&&1>(y=b/h)&&(l=l*y+(d.height-d.clientHeight-b)*(1-y)))}e.scrollTo(g.left,l);e.state.scrollSetAt=k;e.state.scrollSetBy=a;return!0}function P(a,b){var c=b.after;null==c&&(c=a.lastLine()+1);return{top:a.heightAtLine(b.before||0,"local"),bot:a.heightAtLine(c,
"local")}}function Q(a,b,c){(a.lockScroll=b)&&0!=c&&I(a,DIFF_INSERT)&&x(a);a.lockButton.innerHTML=b?"\u21db\u21da":"\u21db&nbsp;&nbsp;\u21da"}function G(a,b,c){for(var f=0;f<b.length;++f){var d=b[f];d instanceof n.TextMarker?d.clear():d.parent&&(a.removeLineClass(d,"background",c.chunk),a.removeLineClass(d,"background",c.start),a.removeLineClass(d,"background",c.end))}b.length=0}function N(a,b,c,f,d){var e=a.getViewport();a.operation(function(){c.from==c.to||20<e.from-c.to||20<c.from-e.to?(G(a,c.marked,
d),J(a,b,f,c.marked,e.from,e.to,d),c.from=e.from,c.to=e.to):(e.from<c.from&&(J(a,b,f,c.marked,e.from,c.from,d),c.from=e.from),e.to>c.to&&(J(a,b,f,c.marked,c.to,e.to,d),c.to=e.to))})}function J(a,b,c,f,d,e,k){function g(b,c){for(var g=Math.max(d,b),h=Math.min(e,c),l=g;l<h;++l){var m=a.addLineClass(l,"background",k.chunk);l==b&&a.addLineClass(m,"background",k.start);l==c-1&&a.addLineClass(m,"background",k.end);f.push(m)}b==c&&g==c&&h==c&&(g?f.push(a.addLineClass(g-1,"background",k.end)):f.push(a.addLineClass(g,
"background",k.start)))}for(var h=q(0,0),l=q(d,0),m=a.clipPos(q(e-1)),n=c==DIFF_DELETE?k.del:k.insert,u=0,t=0;t<b.length;++t){var p=b[t],r=p[0],p=p[1];r==DIFF_EQUAL?(r=h.line+(R(b,t)?0:1),D(h,p),p=h.line+(S(b,t)?1:0),p>r&&(t&&g(u,r),u=p)):r==c&&(r=D(h,p,!0),h=0<(l.line-h.line||l.ch-h.ch)?l:h,p=0>(m.line-r.line||m.ch-r.ch)?m:r,h.line==p.line&&h.ch==p.ch||f.push(a.markText(h,p,{className:n})),h=r)}u<=h.line&&g(u,h.line+1)}function x(a){if(a.showDifferences){if(a.svg){C(a.svg);var b=a.gap.offsetWidth;
T(a.svg,"width",b,"height",a.gap.offsetHeight)}a.copyButtons&&C(a.copyButtons);for(var c=a.edit.getViewport(),f=a.orig.getViewport(),d=a.mv.wrap.getBoundingClientRect().top,e=d-a.edit.getScrollerElement().getBoundingClientRect().top+a.edit.getScrollInfo().top,d=d-a.orig.getScrollerElement().getBoundingClientRect().top+a.orig.getScrollInfo().top,k=0;k<a.chunks.length;k++){var g=a.chunks[k];if(g.editFrom<=c.to&&g.editTo>=c.from&&g.origFrom<=f.to&&g.origTo>=f.from){var h=a,l=d,m=e,n=b,u="left"==h.type,
t=h.orig.heightAtLine(g.origFrom,"local")-l;if(h.svg){var p=t,r=h.edit.heightAtLine(g.editFrom,"local")-m;if(u)var v=p,p=r,r=v;var l=h.orig.heightAtLine(g.origTo,"local")-l,q=h.edit.heightAtLine(g.editTo,"local")-m;u&&(v=l,l=q,q=v);u=" C "+n/2+" "+r+" "+n/2+" "+p+" "+(n+2)+" "+p;p=" C "+n/2+" "+l+" "+n/2+" "+q+" -1 "+q;T(h.svg.appendChild(document.createElementNS("http://www.w3.org/2000/svg","path")),"d","M -1 "+r+u+" L "+(n+2)+" "+l+p+" z","class",h.classes.connect)}h.copyButtons&&(n=h.copyButtons.appendChild(w("div",
"left"==h.type?"\u21dd":"\u21dc","CodeMirror-merge-copy")),r=h.mv.options.allowEditingOriginals,n.title=r?"Push to left":"Revert chunk",n.chunk=g,n.style.top=t+"px",r&&(m=h.orig.heightAtLine(g.editFrom,"local")-m,t=h.copyButtons.appendChild(w("div","right"==h.type?"\u21dd":"\u21dc","CodeMirror-merge-copy-reverse")),t.title="Push to right",t.chunk={editFrom:g.origFrom,editTo:g.origTo,origFrom:g.editFrom,origTo:g.editTo},t.style.top=m+"px","right"==h.type?t.style.left="2px":t.style.right="2px"))}}}}
function E(a,b){for(var c=0,f=0,d=0;d<b.length;d++){var e=b[d];if(e.editTo>a&&e.editFrom<=a)return null;if(e.editFrom>a)break;c=e.editTo;f=e.origTo}return f+(a-c)}function ca(a,b){for(var c=[],f=0;f<a.chunks.length;f++){var d=a.chunks[f];c.push([d.origTo,d.editTo,b?E(d.editTo,b.chunks):null])}if(b)for(f=0;f<b.chunks.length;f++){for(var d=b.chunks[f],e=0;e<c.length;e++){var k=c[e];if(k[1]==d.editTo){e=-1;break}else if(k[1]>d.editTo)break}-1<e&&c.splice(e-1,0,[E(d.editTo,a.chunks),d.editTo,d.origTo])}return c}
function H(a,b){if(a.dealigned||b){if(!a.orig.curOp)return a.orig.operation(function(){H(a,b)});a.dealigned=!1;var c=a.mv.left==a?a.mv.right:a.mv.left;c&&(z(c),c.dealigned=!1);for(var f=ca(a,c),d=a.mv.aligners,e=0;e<d.length;e++)d[e].clear();d.length=0;var k=[a.orig,a.edit],g=[];c&&k.push(c.orig);for(e=0;e<k.length;e++)g.push(k[e].getScrollInfo().top);for(c=0;c<f.length;c++)da(k,f[c],d);for(e=0;e<k.length;e++)k[e].scrollTo(null,g[e])}}function da(a,b,c){for(var f=0,d=[],e=0;e<a.length;e++)if(null!=
b[e]){var k=a[e].heightAtLine(b[e],"local");d[e]=k;f=Math.max(f,k)}for(e=0;e<a.length;e++)null!=b[e]&&(k=f-d[e],1<k&&c.push(ea(a[e],b[e],k)))}function ea(a,b,c){var f=!0;b>a.lastLine()&&(b--,f=!1);var d=document.createElement("div");d.className="CodeMirror-merge-spacer";d.style.height=c+"px";d.style.minWidth="1px";return a.addLineWidget(b,d,{height:c,above:f})}function U(a,b,c,f){if(!a.diffOutOfDate){a=f.editTo>b.lastLine()?q(f.editFrom-1):q(f.editFrom,0);var d=f.origTo>c.lastLine()?q(f.origFrom-
1):q(f.origFrom,0);b.replaceRange(c.getRange(d,q(f.origTo,0)),a,q(f.editTo,0))}}function V(a){var b=a.lockButton=w("div",null,"CodeMirror-merge-scrolllock");b.title="Toggle locked scrolling";var c=w("div",[b],"CodeMirror-merge-scrolllock-wrap");n.on(b,"click",function(){Q(a,!a.lockScroll)});b=[c];!1!==a.mv.options.revertButtons&&(a.copyButtons=w("div",null,"CodeMirror-merge-copybuttons-"+a.type),n.on(a.copyButtons,"click",function(b){b=b.target||b.srcElement;b.chunk&&("CodeMirror-merge-copy-reverse"==
b.className?U(a,a.orig,a.edit,b.chunk):U(a,a.edit,a.orig,b.chunk))}),b.unshift(a.copyButtons));"align"!=a.mv.options.connect&&((c=document.createElementNS&&document.createElementNS("http://www.w3.org/2000/svg","svg"))&&!c.createSVGRect&&(c=null),(a.svg=c)&&b.push(c));return a.gap=w("div",b,"CodeMirror-merge-gap")}function W(a){return"string"==typeof a?a:a.getValue()}function L(a,b){a=X.diff_main(a,b);X.diff_cleanupSemantic(a);for(b=0;b<a.length;++b){var c=a[b];c[1]?b&&a[b-1][0]==c[0]&&(a.splice(b--,
1),a[b][1]+=c[1]):a.splice(b--,1)}return a}function M(a){for(var b=[],c=0,f=0,d=q(0,0),e=q(0,0),k=0;k<a.length;++k){var g=a[k],h=g[0];if(h==DIFF_EQUAL){var l=R(a,k)?0:1,h=d.line+l,l=e.line+l;D(d,g[1],null,e);var m=S(a,k)?1:0,g=d.line+m,m=e.line+m;g>h&&(k&&b.push({origFrom:f,origTo:l,editFrom:c,editTo:h}),c=g,f=m)}else D(h==DIFF_INSERT?d:e,g[1])}(c<=d.line||f<=e.line)&&b.push({origFrom:f,origTo:e.line+1,editFrom:c,editTo:d.line+1});return b}function S(a,b){if(b==a.length-1)return!0;var c=a[b+1][1];
if(1==c.length||10!=c.charCodeAt(0))return!1;if(b==a.length-2)return!0;c=a[b+2][1];return 1<c.length&&10==c.charCodeAt(0)}function R(a,b){if(0==b)return!0;var c=a[b-1][1];if(10!=c.charCodeAt(c.length-1))return!1;if(1==b)return!0;c=a[b-2][1];return 10==c.charCodeAt(c.length-1)}function fa(a,b,c){function f(){e.clear();a.removeLineClass(b,"wrap","CodeMirror-merge-collapsed-line")}a.addLineClass(b,"wrap","CodeMirror-merge-collapsed-line");var d=document.createElement("span");d.className="CodeMirror-merge-collapsed-widget";
d.title="Identical text collapsed. Click to expand.";var e=a.markText(q(b,0),q(c-1),{inclusiveLeft:!0,inclusiveRight:!0,replacedWith:d,clearOnEnter:!0});n.on(d,"click",f);return{mark:e,clear:f}}function ga(a,b){function c(){for(var a=0;a<f.length;a++)f[a].clear()}for(var f=[],d=0;d<b.length;d++){var e=b[d],e=fa(e.cm,e.line,e.line+a);f.push(e);e.mark.on("clear",c)}return f[0].mark}function Y(a,b,c,f){for(var d=0;d<a.chunks.length;d++)for(var e=a.chunks[d],k=e.editFrom-b;k<e.editTo+b;k++){var g=k+c;
0<=g&&g<f.length&&(f[g]=!1)}}function w(a,b,c,f){a=document.createElement(a);c&&(a.className=c);f&&(a.style.cssText=f);if("string"==typeof b)a.appendChild(document.createTextNode(b));else if(b)for(c=0;c<b.length;++c)a.appendChild(b[c]);return a}function C(a){for(var b=a.childNodes.length;0<b;--b)a.removeChild(a.firstChild)}function T(a){for(var b=1;b<arguments.length;b+=2)a.setAttribute(arguments[b],arguments[b+1])}function K(a,b){b||(b={});for(var c in a)a.hasOwnProperty(c)&&(b[c]=a[c]);return b}
function D(a,b,c,f){a=c?q(a.line,a.ch):a;for(c=0;;){var d=b.indexOf("\n",c);if(-1==d)break;++a.line;f&&++f.line;c=d+1}a.ch=(c?0:a.ch)+(b.length-c);f&&(f.ch=(c?0:f.ch)+(b.length-c));return a}function Z(a,b){var c=null,f=a.state.diffViews,d=a.getCursor().line;if(f)for(var e=0;e<f.length;e++){var k=f[e],g=a==k.orig;z(k);if(0>b)a:{for(var k=k.chunks,h=k.length-1;0<=h;h--){var l=k[h],l=(g?l.origTo:l.editTo)-1;if(l<d){g=l;break a}}g=void 0}else a:{k=k.chunks;for(h=0;h<k.length;h++)if(l=k[h],l=g?l.origFrom:
l.editFrom,l>d){g=l;break a}g=void 0}null!=g&&(null==c||(0>b?g>c:g<c))&&(c=g)}if(null!=c)a.setCursor(c,0);else return n.Pass}var q=n.Pos;A.prototype={constructor:A,init:function(a,b,c){this.edit=this.mv.edit;(this.edit.state.diffViews||(this.edit.state.diffViews=[])).push(this);this.orig=n(a,K({value:b,readOnly:!this.mv.options.allowEditingOriginals},K(c)));this.orig.state.diffViews=[this];this.diff=L(W(b),W(c.value));this.chunks=M(this.diff);this.diffOutOfDate=this.dealigned=!1;this.showDifferences=
!1!==c.showDifferences;this.forceUpdate=aa(this);Q(this,!0,!1);ba(this)},setShowDifferences:function(a){a=!1!==a;a!=this.showDifferences&&(this.showDifferences=a,this.forceUpdate("full"))}};var B=!1,F=n.MergeView=function(a,b){if(!(this instanceof F))return new F(a,b);this.options=b;var c=b.origLeft,f=null==b.origRight?b.orig:b.origRight,d=null!=c,e=null!=f,k=1+(d?1:0)+(e?1:0),g=[],h=this.left=null,l=this.right=null,m=this;if(d){var h=this.left=new A(this,"left"),q=w("div",null,"CodeMirror-merge-pane");
g.push(q);g.push(V(h))}d=w("div",null,"CodeMirror-merge-pane");g.push(d);if(e){l=this.right=new A(this,"right");g.push(V(l));var u=w("div",null,"CodeMirror-merge-pane");g.push(u)}(e?u:d).className+=" CodeMirror-merge-pane-rightmost";g.push(w("div",null,null,"height: 0; clear: both;"));var t=this.wrap=a.appendChild(w("div",g,"CodeMirror-merge CodeMirror-merge-"+k+"pane"));this.edit=n(d,K(b));h&&h.init(q,c,b);l&&l.init(u,f,b);b.collapseIdentical&&this.editor().operation(function(){var a=b.collapseIdentical;
"number"!=typeof a&&(a=2);for(var c=[],d=m.editor(),e=d.firstLine(),f=e,g=d.lastLine();f<=g;f++)c.push(!0);m.left&&Y(m.left,a,e,c);m.right&&Y(m.right,a,e,c);for(f=0;f<c.length;f++)if(c[f]){for(var g=f+e,h=1;f<c.length-1&&c[f+1];f++,h++);if(h>a){var k=[{line:g,cm:d}];m.left&&k.push({line:E(g,m.left.chunks),cm:m.left.orig});m.right&&k.push({line:E(g,m.right.chunks),cm:m.right.orig});k=ga(h,k);if(m.options.onCollapse)m.options.onCollapse(m,g,h,k)}}});"align"==b.connect&&(this.aligners=[],H(this.left||
this.right,!0));var p=function(){h&&x(h);l&&x(l)};n.on(window,"resize",p);var r=setInterval(function(){for(var a=t.parentNode;a&&a!=document.body;a=a.parentNode);a||(clearInterval(r),n.off(window,"resize",p))},5E3)};F.prototype={constuctor:F,editor:function(){return this.edit},rightOriginal:function(){return this.right&&this.right.orig},leftOriginal:function(){return this.left&&this.left.orig},setShowDifferences:function(a){this.right&&this.right.setShowDifferences(a);this.left&&this.left.setShowDifferences(a)},
rightChunks:function(){if(this.right)return z(this.right),this.right.chunks},leftChunks:function(){if(this.left)return z(this.left),this.left.chunks}};var X=new diff_match_patch;n.commands.goNextDiff=function(a){return Z(a,1)};n.commands.goPrevDiff=function(a){return Z(a,-1)}});

(this.webpackJsonpboiler=this.webpackJsonpboiler||[]).push([[0],{12:function(e,t,n){},13:function(e,t,n){"use strict";n.r(t);var a=n(1),r=n(2),o=n(4),c=n(3),i=n(0),s=n.n(i),u=n(6),l=n.n(u),m=(n(12),function(e){Object(o.a)(n,e);var t=Object(c.a)(n);function n(e){var r;return Object(a.a)(this,n),(r=t.call(this,e)).countBegin=function(){r.timer=setInterval((function(){if(r.remainingSecond>=0){var e=r.getMinutesFromTotalSecond(r.remainingSecond),t=r.getSecondFromTotalSecond(r.remainingSecond);r.remainingSecond-=1,r.setState({minutes:e,seconds:t})}else clearInterval(r.timer),r.props.queryState()}),1e3)},r.getMinutesFromTotalSecond=function(e){return Math.floor(e/60)},r.getSecondFromTotalSecond=function(e){return Math.floor(e%60)},r.state={minutes:0,seconds:0},r.remainingSecond=r.props.totalSecond,r.remainingSecond>0&&r.countBegin(),r}return Object(r.a)(n,[{key:"componentWillUnmount",value:function(){clearInterval(this.timer)}},{key:"render",value:function(){return 0===this.state.minutes&&0===this.state.seconds?s.a.createElement("span",null,"querying, please wait..."):s.a.createElement("span",null,this.state.minutes," minutes ",this.state.seconds," seconds")}}]),n}(i.Component)),h=function(e){Object(o.a)(n,e);var t=Object(c.a)(n);function n(){return Object(a.a)(this,n),t.apply(this,arguments)}return Object(r.a)(n,[{key:"render",value:function(){var e=this;return s.a.createElement("div",null,s.a.createElement("p",{className:"occupied"},"Someone is using boiler"),s.a.createElement("p",{className:"occupied"},"estimated remaining time:"),s.a.createElement(m,{totalSecond:this.props.totalSecond,queryState:this.props.queryState}),s.a.createElement("br",null),s.a.createElement("br",null),s.a.createElement("button",{onClick:function(){return e.props.onClick("Free")}},"Free it Now"))}}]),n}(s.a.Component),p=function(e){Object(o.a)(n,e);var t=Object(c.a)(n);function n(e){var r;return Object(a.a)(this,n),(r=t.call(this,e)).handleChange=function(e){r.setState({time:e.target.value})},r.state={time:10},r}return Object(r.a)(n,[{key:"render",value:function(){var e=this;return s.a.createElement("div",null,s.a.createElement("p",{className:"free"},"No one using boiler now"),s.a.createElement("p",null,"input the time you want to use the boiler(unit: minute)"),s.a.createElement("input",{type:"text",value:this.state.time,onChange:this.handleChange}),s.a.createElement("button",{onClick:function(){return e.props.onClick("Occupied",e.state.time)}},"Occupy it"))}}]),n}(s.a.Component),d=function(e){Object(o.a)(n,e);var t=Object(c.a)(n);function n(){return Object(a.a)(this,n),t.apply(this,arguments)}return Object(r.a)(n,[{key:"render",value:function(){return this.props.state.match("Free")?s.a.createElement(p,{onClick:this.props.onClick}):s.a.createElement(h,{onClick:this.props.onClick,totalSecond:this.props.totalSecond,queryState:this.props.queryState})}}]),n}(s.a.Component),S=function(e){Object(o.a)(n,e);var t=Object(c.a)(n);function n(){return Object(a.a)(this,n),t.apply(this,arguments)}return Object(r.a)(n,[{key:"render",value:function(){return s.a.createElement("p",null,"boiler is ",this.props.state)}}]),n}(s.a.Component),f=function(e){Object(o.a)(n,e);var t=Object(c.a)(n);function n(e){var r;return Object(a.a)(this,n),(r=t.call(this,e)).queryState=function(){var e="/".concat("state");fetch(e,{mode:"cors"}).then((function(e){return e.json()})).then((function(e){return r.setState({state:e.data.boilerState,totalSecond:e.data.remainingOccupiedTime})}))},r.postStateChange=function(e,t){var n="/";n=e.match("Free")?n.concat("state/free"):n.concat("state/occupied?time=".concat(t)),fetch(n,{method:"POST",mode:"cors"}).then((function(e){return e.json()})).then((function(e){return r.handleStateChangeResult(e.status)})),r.setState({totalSecond:60*t})},r.handleStateChange=function(e,t){r.setState({newState:e}),r.postStateChange(e,t)},r.state={state:"Free",newState:"",totalSecond:0},r.queryState(),r}return Object(r.a)(n,[{key:"handleStateChangeResult",value:function(e){if(1===e){var t=this.state.newState;this.setState({state:t})}else alert("change state failed, plase refresh and try again later")}},{key:"render",value:function(){return s.a.createElement("div",{className:"boiler"},s.a.createElement("div",{className:"boiler-state"},s.a.createElement(S,{state:this.state.state})),s.a.createElement("div",{className:"State-Changer"},s.a.createElement(d,{onClick:this.handleStateChange,state:this.state.state,totalSecond:this.state.totalSecond,queryState:this.queryState})))}}]),n}(s.a.Component);l.a.render(s.a.createElement(f,null),document.getElementById("root"))},7:function(e,t,n){e.exports=n(13)}},[[7,1,2]]]);
//# sourceMappingURL=main.f1e1b695.chunk.js.map
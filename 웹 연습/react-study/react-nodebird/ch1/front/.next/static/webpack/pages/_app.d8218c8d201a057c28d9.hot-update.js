webpackHotUpdate_N_E("pages/_app",{

/***/ "./pages/_app.js":
/*!***********************!*\
  !*** ./pages/_app.js ***!
  \***********************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var next_head__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! next/head */ "./node_modules/next/dist/next-server/lib/head.js");
/* harmony import */ var next_head__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(next_head__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var prop_types__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! prop-types */ "./node_modules/prop-types/index.js");
/* harmony import */ var prop_types__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(prop_types__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _components_AppLayout__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../components/AppLayout */ "./components/AppLayout.js");
/* harmony import */ var next_redux_wrapper__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! next-redux-wrapper */ "./node_modules/next-redux-wrapper/es6/index.js");
/* harmony import */ var _reducers__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../reducers */ "./reducers/index.js");
/* harmony import */ var react_redux__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! react-redux */ "./node_modules/react-redux/es/index.js");
/* harmony import */ var redux__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! redux */ "./node_modules/redux/es/redux.js");
var _this = undefined,
    _jsxFileName = "C:\\Users\\82108\\WebstormProjects\\react-nodebird\\ch1\\front\\pages\\_app.js";

var __jsx = react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement;





 //index.js를 의미함->생략


 //provider가 redux의 state를 제공함

var NodeBird = function NodeBird(_ref) {
  var Component = _ref.Component,
      store = _ref.store;
  return __jsx(react_redux__WEBPACK_IMPORTED_MODULE_6__["Provider"], {
    store: store,
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 14,
      columnNumber: 9
    }
  }, __jsx(next_head__WEBPACK_IMPORTED_MODULE_1___default.a, {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 15,
      columnNumber: 13
    }
  }, __jsx("title", {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 16,
      columnNumber: 17
    }
  }, "NodeBird"), __jsx("link", {
    rel: "stylesheet",
    href: "https://cdnjs.cloudflare.com/ajax/libs/antd/3.18.1/antd.css",
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 17,
      columnNumber: 17
    }
  }), __jsx("script", {
    src: "https://cdnjs.cloudflare.com/ajax/libs/antd/3.18.1/antd.js",
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 18,
      columnNumber: 17
    }
  })), __jsx(_components_AppLayout__WEBPACK_IMPORTED_MODULE_3__["default"], {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 20,
      columnNumber: 13
    }
  }, __jsx(Component, {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 21,
      columnNumber: 17
    }
  })));
}; //node는 리액트에 들어갈 수 있는 모든 것을 node라고 표시함


_c = NodeBird;
NodeBird.propTypes = {
  Component: prop_types__WEBPACK_IMPORTED_MODULE_2___default.a.elementType.isRequired,
  store: prop_types__WEBPACK_IMPORTED_MODULE_2___default.a.object
};
/* harmony default export */ __webpack_exports__["default"] = (Object(next_redux_wrapper__WEBPACK_IMPORTED_MODULE_4__["default"])(function (initialState, options) {
  //_app에 store를 넣어주는 역할, initialState는 redux에서 state를 넣어줌
  var middlewares = [];
  var enhancer = Object(redux__WEBPACK_IMPORTED_MODULE_7__["compose"])(redux__WEBPACK_IMPORTED_MODULE_7__["applyMiddleware"].apply(void 0, middlewares), window.__REDUX); //미들웨어끼리 합쳐주는 compose

  var store = Object(redux__WEBPACK_IMPORTED_MODULE_7__["createStore"])(_reducers__WEBPACK_IMPORTED_MODULE_5__["default"], initialState, enhancer);
  return store;
})(NodeBird));

var _c;

$RefreshReg$(_c, "NodeBird");

;
    var _a, _b;
    // Legacy CSS implementations will `eval` browser code in a Node.js context
    // to extract CSS. For backwards compatibility, we need to check we're in a
    // browser context before continuing.
    if (typeof self !== 'undefined' &&
        // AMP / No-JS mode does not inject these helpers:
        '$RefreshHelpers$' in self) {
        var currentExports = module.__proto__.exports;
        var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;
        // This cannot happen in MainTemplate because the exports mismatch between
        // templating and execution.
        self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.i);
        // A module can be accepted automatically based on its exports, e.g. when
        // it is a Refresh Boundary.
        if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {
            // Save the previous exports on update so we can compare the boundary
            // signatures.
            module.hot.dispose(function (data) {
                data.prevExports = currentExports;
            });
            // Unconditionally accept an update to this module, we'll check if it's
            // still a Refresh Boundary later.
            module.hot.accept();
            // This field is set when the previous version of this module was a
            // Refresh Boundary, letting us know we need to check for invalidation or
            // enqueue an update.
            if (prevExports !== null) {
                // A boundary can become ineligible if its exports are incompatible
                // with the previous exports.
                //
                // For example, if you add/remove/change exports, we'll want to
                // re-execute the importing modules, and force those components to
                // re-render. Similarly, if you convert a class component to a
                // function, we want to invalidate the boundary.
                if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {
                    module.hot.invalidate();
                }
                else {
                    self.$RefreshHelpers$.scheduleUpdate();
                }
            }
        }
        else {
            // Since we just executed the code for the module, it's possible that the
            // new exports made it ineligible for being a boundary.
            // We only care about the case when we were _previously_ a boundary,
            // because we already accepted this update (accidental side effect).
            var isNoLongerABoundary = prevExports !== null;
            if (isNoLongerABoundary) {
                module.hot.invalidate();
            }
        }
    }

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../node_modules/webpack/buildin/harmony-module.js */ "./node_modules/webpack/buildin/harmony-module.js")(module)))

/***/ })

})
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vcGFnZXMvX2FwcC5qcyJdLCJuYW1lcyI6WyJOb2RlQmlyZCIsIkNvbXBvbmVudCIsInN0b3JlIiwicHJvcFR5cGVzIiwiUHJvcFR5cGVzIiwiZWxlbWVudFR5cGUiLCJpc1JlcXVpcmVkIiwib2JqZWN0Iiwid2l0aFJlZHV4IiwiaW5pdGlhbFN0YXRlIiwib3B0aW9ucyIsIm1pZGRsZXdhcmVzIiwiZW5oYW5jZXIiLCJjb21wb3NlIiwiYXBwbHlNaWRkbGV3YXJlIiwid2luZG93IiwiX19SRURVWCIsImNyZWF0ZVN0b3JlIiwicmVkdWNlciJdLCJtYXBwaW5ncyI6Ijs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0NBQ2tDOztBQUNsQztDQUVBOztBQUdBLElBQU1BLFFBQVEsR0FBRyxTQUFYQSxRQUFXLE9BQTBCO0FBQUEsTUFBdkJDLFNBQXVCLFFBQXZCQSxTQUF1QjtBQUFBLE1BQVpDLEtBQVksUUFBWkEsS0FBWTtBQUN2QyxTQUNJLE1BQUMsb0RBQUQ7QUFBVSxTQUFLLEVBQUlBLEtBQW5CO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsS0FDSSxNQUFDLGdEQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsS0FDSTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLGdCQURKLEVBRUk7QUFBTSxPQUFHLEVBQUMsWUFBVjtBQUF1QixRQUFJLEVBQUMsNkRBQTVCO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsSUFGSixFQUdJO0FBQVEsT0FBRyxFQUFDLDREQUFaO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsSUFISixDQURKLEVBTUksTUFBQyw2REFBRDtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLEtBQ0ksTUFBQyxTQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsSUFESixDQU5KLENBREo7QUFZSCxDQWJELEMsQ0FjQTs7O0tBZE1GLFE7QUFlTkEsUUFBUSxDQUFDRyxTQUFULEdBQXFCO0FBQ2pCRixXQUFTLEVBQUVHLGlEQUFTLENBQUNDLFdBQVYsQ0FBc0JDLFVBRGhCO0FBRWpCSixPQUFLLEVBQUNFLGlEQUFTLENBQUNHO0FBRkMsQ0FBckI7QUFJZUMsaUlBQVMsQ0FBQyxVQUFDQyxZQUFELEVBQWVDLE9BQWYsRUFBeUI7QUFBQztBQUMvQyxNQUFNQyxXQUFXLEdBQUcsRUFBcEI7QUFDQSxNQUFNQyxRQUFRLEdBQUdDLHFEQUFPLENBQUNDLHFEQUFlLE1BQWYsU0FBbUJILFdBQW5CLENBQUQsRUFBa0NJLE1BQU0sQ0FBQ0MsT0FBekMsQ0FBeEIsQ0FGOEMsQ0FFNEI7O0FBQzFFLE1BQU1kLEtBQUssR0FBR2UseURBQVcsQ0FBQ0MsaURBQUQsRUFBVVQsWUFBVixFQUF3QkcsUUFBeEIsQ0FBekI7QUFDQSxTQUFPVixLQUFQO0FBQ0gsQ0FMdUIsQ0FBVCxDQUtaRixRQUxZLENBQWYiLCJmaWxlIjoic3RhdGljL3dlYnBhY2svcGFnZXMvX2FwcC5kODIxOGM4ZDIwMWEwNTdjMjhkOS5ob3QtdXBkYXRlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IFJlYWN0IGZyb20gJ3JlYWN0JztcclxuaW1wb3J0IEhlYWQgZnJvbSAnbmV4dC9oZWFkJztcclxuaW1wb3J0IFByb3BUeXBlcyBmcm9tICdwcm9wLXR5cGVzJztcclxuaW1wb3J0IEFwcExheW91dCBmcm9tICcuLi9jb21wb25lbnRzL0FwcExheW91dCc7XHJcbmltcG9ydCB3aXRoUmVkdXggZnJvbSAnbmV4dC1yZWR1eC13cmFwcGVyJztcclxuaW1wb3J0IHJlZHVjZXIgZnJvbSAnLi4vcmVkdWNlcnMnOy8vaW5kZXguanPrpbwg7J2Y66+47ZWoLT7sg53rnrVcclxuaW1wb3J0IHtQcm92aWRlcn0gZnJvbSAncmVhY3QtcmVkdXgnO1xyXG5pbXBvcnQge2NyZWF0ZVN0b3JlLCBjb21wb3NlLCBhcHBseU1pZGRsZXdhcmV9IGZyb20gXCJyZWR1eFwiO1xyXG4vL3Byb3ZpZGVy6rCAIHJlZHV47J2YIHN0YXRl66W8IOygnOqzte2VqFxyXG5cclxuXHJcbmNvbnN0IE5vZGVCaXJkID0gKHsgQ29tcG9uZW50LCBzdG9yZSB9KSA9PiB7XHJcbiAgICByZXR1cm4gKFxyXG4gICAgICAgIDxQcm92aWRlciBzdG9yZSA9IHtzdG9yZX0+XHJcbiAgICAgICAgICAgIDxIZWFkPlxyXG4gICAgICAgICAgICAgICAgPHRpdGxlPk5vZGVCaXJkPC90aXRsZT5cclxuICAgICAgICAgICAgICAgIDxsaW5rIHJlbD1cInN0eWxlc2hlZXRcIiBocmVmPVwiaHR0cHM6Ly9jZG5qcy5jbG91ZGZsYXJlLmNvbS9hamF4L2xpYnMvYW50ZC8zLjE4LjEvYW50ZC5jc3NcIiAvPlxyXG4gICAgICAgICAgICAgICAgPHNjcmlwdCBzcmM9XCJodHRwczovL2NkbmpzLmNsb3VkZmxhcmUuY29tL2FqYXgvbGlicy9hbnRkLzMuMTguMS9hbnRkLmpzXCI+PC9zY3JpcHQ+XHJcbiAgICAgICAgICAgIDwvSGVhZD5cclxuICAgICAgICAgICAgPEFwcExheW91dD5cclxuICAgICAgICAgICAgICAgIDxDb21wb25lbnQgLz5cclxuICAgICAgICAgICAgPC9BcHBMYXlvdXQ+XHJcbiAgICAgICAgPC9Qcm92aWRlcj5cclxuICAgICk7XHJcbn1cclxuLy9ub2Rl64qUIOumrOyVoe2KuOyXkCDrk6TslrTqsIgg7IiYIOyeiOuKlCDrqqjrk6Ag6rKD7J2EIG5vZGXrnbzqs6Ag7ZGc7Iuc7ZWoXHJcbk5vZGVCaXJkLnByb3BUeXBlcyA9IHtcclxuICAgIENvbXBvbmVudDogUHJvcFR5cGVzLmVsZW1lbnRUeXBlLmlzUmVxdWlyZWQsXHJcbiAgICBzdG9yZTpQcm9wVHlwZXMub2JqZWN0XHJcbn07XHJcbmV4cG9ydCBkZWZhdWx0IHdpdGhSZWR1eCgoaW5pdGlhbFN0YXRlLCBvcHRpb25zKT0+ey8vX2FwcOyXkCBzdG9yZeulvCDrhKPslrTso7zripQg7Jet7ZWgLCBpbml0aWFsU3RhdGXripQgcmVkdXjsl5DshJwgc3RhdGXrpbwg64Sj7Ja07KSMXHJcbiAgICBjb25zdCBtaWRkbGV3YXJlcyA9IFtdO1xyXG4gICAgY29uc3QgZW5oYW5jZXIgPSBjb21wb3NlKGFwcGx5TWlkZGxld2FyZSguLi5taWRkbGV3YXJlcyksIHdpbmRvdy5fX1JFRFVYKTsvL+uvuOuTpOybqOyWtOuBvOumrCDtlanss5Dso7zripQgY29tcG9zZVxyXG4gICAgY29uc3Qgc3RvcmUgPSBjcmVhdGVTdG9yZShyZWR1Y2VyLCBpbml0aWFsU3RhdGUsIGVuaGFuY2VyKTtcclxuICAgIHJldHVybiBzdG9yZTtcclxufSkoTm9kZUJpcmQpOyJdLCJzb3VyY2VSb290IjoiIn0=
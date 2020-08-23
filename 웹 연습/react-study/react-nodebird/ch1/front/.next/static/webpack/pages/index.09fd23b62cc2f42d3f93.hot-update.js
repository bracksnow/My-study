webpackHotUpdate_N_E("pages/index",{

/***/ "./pages/index.js":
/*!************************!*\
  !*** ./pages/index.js ***!
  \************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var antd__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! antd */ "./node_modules/antd/es/index.js");
/* harmony import */ var _ant_design_icons__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ant-design/icons */ "./node_modules/@ant-design/icons/es/index.js");
var _this = undefined,
    _jsxFileName = "C:\\Users\\82108\\WebstormProjects\\react-nodebird\\ch1\\front\\pages\\index.js";

var __jsx = react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement;



var dummy = {
  isLoggedIn: true,
  imagePaths: [],
  mainPosts: [{
    User: {
      id: 1,
      nickname: "Dogveloper"
    },
    content: "첫번째 게시글",
    img: 'https://source.unsplash.com/random'
  }]
};

var Home = function Home() {
  return __jsx("div", {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 20,
      columnNumber: 9
    }
  }, dummy.isLoggedIn && __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Form"], {
    style: {
      margin: '10px, 0, 20px'
    },
    encType: "multipart/form-data",
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 21,
      columnNumber: 34
    }
  }, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Input"].TextArea, {
    maxLength: 150,
    placecholder: "\uC5B4\uB5A4 \uC77C\uC774 \uC788\uC5C8\uB098\uC694",
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 22,
      columnNumber: 13
    }
  }), __jsx("div", {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 23,
      columnNumber: 13
    }
  }, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Input"], {
    type: "file",
    multiple: true,
    hidden: true,
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 24,
      columnNumber: 17
    }
  }), __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Button"], {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 25,
      columnNumber: 17
    }
  }, "\uC774\uBBF8\uC9C0 \uC5C5\uB85C\uB4DC"), __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Button"], {
    type: "primary",
    style: {
      "float": "right"
    },
    htmlType: "submit",
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 26,
      columnNumber: 17
    }
  }, "\uC81C\uCD9C")), __jsx("div", {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 28,
      columnNumber: 13
    }
  }, dummy.imagePaths.map(function (v, i) {
    return __jsx("div", {
      key: v,
      style: {
        display: 'inline-block'
      },
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 31,
        columnNumber: 25
      }
    }, __jsx("img", {
      src: 'http://localhost:3065/' + v,
      style: {
        width: '200px'
      },
      alt: v,
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 32,
        columnNumber: 29
      }
    }), __jsx("div", {
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 33,
        columnNumber: 29
      }
    }, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Button"], {
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 34,
        columnNumber: 33
      }
    }, "\uC81C\uAC70")));
  }))), dummy.mainPosts.map(function (c) {
    return __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Card"], {
      key: +c.createdAt,
      cover: c.img && __jsx("img", {
        alt: "example",
        src: c.img,
        __self: _this,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 45,
          columnNumber: 41
        }
      }),
      actions: [__jsx(_ant_design_icons__WEBPACK_IMPORTED_MODULE_2__["RetweetOutlined"], {
        key: "message",
        __self: _this,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 47,
          columnNumber: 29
        }
      }), __jsx(_ant_design_icons__WEBPACK_IMPORTED_MODULE_2__["HeartOutlined"], {
        key: "heart",
        __self: _this,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 48,
          columnNumber: 29
        }
      }), __jsx(_ant_design_icons__WEBPACK_IMPORTED_MODULE_2__["MessageOutlined"], {
        key: "message",
        __self: _this,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 49,
          columnNumber: 29
        }
      }), __jsx(_ant_design_icons__WEBPACK_IMPORTED_MODULE_2__["EllipsisOutlined"], {
        key: "ellipsis",
        __self: _this,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 50,
          columnNumber: 29
        }
      })],
      extra: __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Button"], {
        __self: _this,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 52,
          columnNumber: 32
        }
      }, "\uD314\uB85C\uC6B0"),
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 43,
        columnNumber: 21
      }
    }, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Card"].Meta, {
      avatar: __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Avatar"], {
        __self: _this,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 55,
          columnNumber: 37
        }
      }, c.User.nickname[0]),
      title: c.User.nickname,
      description: c.content,
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 54,
        columnNumber: 25
      }
    }));
  }));
};

_c = Home;
/* harmony default export */ __webpack_exports__["default"] = (Home);

var _c;

$RefreshReg$(_c, "Home");

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
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vcGFnZXMvaW5kZXguanMiXSwibmFtZXMiOlsiZHVtbXkiLCJpc0xvZ2dlZEluIiwiaW1hZ2VQYXRocyIsIm1haW5Qb3N0cyIsIlVzZXIiLCJpZCIsIm5pY2tuYW1lIiwiY29udGVudCIsImltZyIsIkhvbWUiLCJtYXJnaW4iLCJtYXAiLCJ2IiwiaSIsImRpc3BsYXkiLCJ3aWR0aCIsImMiLCJjcmVhdGVkQXQiXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQUNBO0FBQ0E7QUFFQSxJQUFNQSxLQUFLLEdBQUc7QUFDVkMsWUFBVSxFQUFHLElBREg7QUFFVkMsWUFBVSxFQUFFLEVBRkY7QUFHVkMsV0FBUyxFQUFHLENBQUM7QUFDVEMsUUFBSSxFQUFHO0FBQ0hDLFFBQUUsRUFBRyxDQURGO0FBRUhDLGNBQVEsRUFBRztBQUZSLEtBREU7QUFLVEMsV0FBTyxFQUFHLFNBTEQ7QUFNVEMsT0FBRyxFQUFHO0FBTkcsR0FBRDtBQUhGLENBQWQ7O0FBYUEsSUFBTUMsSUFBSSxHQUFHLFNBQVBBLElBQU8sR0FBSztBQUNkLFNBQ0k7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxLQUNLVCxLQUFLLENBQUNDLFVBQU4sSUFBb0IsTUFBQyx5Q0FBRDtBQUFNLFNBQUssRUFBSTtBQUFDUyxZQUFNLEVBQUM7QUFBUixLQUFmO0FBQTBDLFdBQU8sRUFBRyxxQkFBcEQ7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxLQUNyQixNQUFDLDBDQUFELENBQU8sUUFBUDtBQUFnQixhQUFTLEVBQUksR0FBN0I7QUFBa0MsZ0JBQVksRUFBRyxvREFBakQ7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxJQURxQixFQUVyQjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLEtBQ0ksTUFBQywwQ0FBRDtBQUFPLFFBQUksRUFBRyxNQUFkO0FBQXFCLFlBQVEsTUFBN0I7QUFB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ZDNmOTMuaG90LXVwZGF0ZS5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCBSZWFjdCBmcm9tICdyZWFjdCc7XHJcbmltcG9ydCB7Rm9ybSwgSW5wdXQsIEJ1dHRvbiwgQ2FyZCwgQXZhdGFyfSBmcm9tICdhbnRkJ1xyXG5pbXBvcnQgeyBIZWFydE91dGxpbmVkLCBSZXR3ZWV0T3V0bGluZWQsIE1lc3NhZ2VPdXRsaW5lZCwgRWxsaXBzaXNPdXRsaW5lZCB9IGZyb20gJ0BhbnQtZGVzaWduL2ljb25zJztcclxuXHJcbmNvbnN0IGR1bW15ID0ge1xyXG4gICAgaXNMb2dnZWRJbiA6IHRydWUsXHJcbiAgICBpbWFnZVBhdGhzOiBbXSxcclxuICAgIG1haW5Qb3N0cyA6IFt7XHJcbiAgICAgICAgVXNlciA6IHtcclxuICAgICAgICAgICAgaWQgOiAxLFxyXG4gICAgICAgICAgICBuaWNrbmFtZSA6IFwiRG9ndmVsb3BlclwiLFxyXG4gICAgICAgIH0sXHJcbiAgICAgICAgY29udGVudCA6IFwi7LKr67KI7Ke4IOqyjOyLnOq4gFwiLFxyXG4gICAgICAgIGltZyA6ICdodHRwczovL3NvdXJjZS51bnNwbGFzaC5jb20vcmFuZG9tJyxcclxuICAgIH1dLFxyXG59O1xyXG5cclxuY29uc3QgSG9tZSA9ICgpID0+e1xyXG4gICAgcmV0dXJuIChcclxuICAgICAgICA8ZGl2PlxyXG4gICAgICAgICAgICB7ZHVtbXkuaXNMb2dnZWRJbiAmJiA8Rm9ybSBzdHlsZSA9IHt7bWFyZ2luOicxMHB4LCAwLCAyMHB4JyB9fSBlbmNUeXBlID0gXCJtdWx0aXBhcnQvZm9ybS1kYXRhXCI+XHJcbiAgICAgICAgICAgIDxJbnB1dC5UZXh0QXJlYSBtYXhMZW5ndGggPSB7MTUwfSBwbGFjZWNob2xkZXIgPSBcIuyWtOuWpCDsnbzsnbQg7J6I7JeI64KY7JqUXCIvPlxyXG4gICAgICAgICAgICA8ZGl2PlxyXG4gICAgICAgICAgICAgICAgPElucHV0IHR5cGUgPSBcImZpbGVcIiBtdWx0aXBsZSBoaWRkZW4+PC9JbnB1dD5cclxuICAgICAgICAgICAgICAgIDxCdXR0b24+7J2066+47KeAIOyXheuhnOuTnDwvQnV0dG9uPlxyXG4gICAgICAgICAgICAgICAgPEJ1dHRvbiB0eXBlID0gXCJwcmltYXJ5XCIgc3R5bGUgPSB7e2Zsb2F0OlwicmlnaHRcIn19IGh0bWxUeXBlID0gXCJzdWJtaXRcIj7soJzstpw8L0J1dHRvbj5cclxuICAgICAgICAgICAgPC9kaXY+XHJcbiAgICAgICAgICAgIDxkaXY+XHJcbiAgICAgICAgICAgICAgICB7ZHVtbXkuaW1hZ2VQYXRocy5tYXAoKHYsaSk9PntcclxuICAgICAgICAgICAgICAgICAgICByZXR1cm4oXHJcbiAgICAgICAgICAgICAgICAgICAgICAgIDxkaXYga2V5PXt2fSBzdHlsZT17e2Rpc3BsYXk6J2lubGluZS1ibG9jayd9fT5cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxpbWcgc3JjPXsnaHR0cDovL2xvY2FsaG9zdDozMDY1Lycrdn0gc3R5bGUgPSB7e3dpZHRoOicyMDBweCd9fSBhbHQgPSB7dn0vPlxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgPGRpdj5cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICA8QnV0dG9uPuygnOqxsDwvQnV0dG9uPlxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgPC9kaXY+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgICAgICAgICAgICAgICk7XHJcbiAgICAgICAgICAgICAgICB9KX1cclxuICAgICAgICAgICAgPC9kaXY+XHJcbiAgICAgICAgICAgIDwvRm9ybT59XHJcbiAgICAgICAgICAgIHtkdW1teS5tYWluUG9zdHMubWFwKChjKT0+e1xyXG4gICAgICAgICAgICAgICAgcmV0dXJuKFxyXG4gICAgICAgICAgICAgICAgICAgIDxDYXJkXHJcbiAgICAgICAgICAgICAgICAgICAgICAgIGtleT17K2MuY3JlYXRlZEF0fVxyXG4gICAgICAgICAgICAgICAgICAgICAgICBjb3Zlcj17Yy5pbWcgJiYgPGltZyBhbHQ9XCJleGFtcGxlXCIgc3JjPXtjLmltZ30gLz59XHJcbiAgICAgICAgICAgICAgICAgICAgICAgIGFjdGlvbnMgPSB7W1xyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgPFJldHdlZXRPdXRsaW5lZCBrZXk9XCJtZXNzYWdlXCIvPixcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxIZWFydE91dGxpbmVkIGtleSA9IFwiaGVhcnRcIiAvPixcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxNZXNzYWdlT3V0bGluZWQga2V5PVwibWVzc2FnZVwiIC8+LFxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgPEVsbGlwc2lzT3V0bGluZWQga2V5PVwiZWxsaXBzaXNcIiAvPixcclxuICAgICAgICAgICAgICAgICAgICAgICAgXX1cclxuICAgICAgICAgICAgICAgICAgICAgICAgZXh0cmE9ezxCdXR0b24+7YyU66Gc7JqwPC9CdXR0b24+fVxyXG4gICAgICAgICAgICAgICAgICAgID5cclxuICAgICAgICAgICAgICAgICAgICAgICAgPENhcmQuTWV0YVxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgYXZhdGFyPXs8QXZhdGFyPntjLlVzZXIubmlja25hbWVbMF19PC9BdmF0YXI+fVxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgdGl0bGU9e2MuVXNlci5uaWNrbmFtZX1cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGRlc2NyaXB0aW9uPXtjLmNvbnRlbnR9XHJcbiAgICAgICAgICAgICAgICAgICAgICAgIC8+XHJcbiAgICAgICAgICAgICAgICAgICAgPC9DYXJkPlxyXG4gICAgICAgICAgICAgICAgKTtcclxuICAgICAgICAgICAgfSl9XHJcbiAgICAgICAgPC9kaXY+XHJcbiAgICApO1xyXG59O1xyXG5cclxuZXhwb3J0IGRlZmF1bHQgSG9tZTsiXSwic291cmNlUm9vdCI6IiJ9
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
    placeholder: "\uC5B4\uB5A4 \uC77C\uC774 \uC788\uC5C8\uB098\uC694",
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
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vcGFnZXMvaW5kZXguanMiXSwibmFtZXMiOlsiZHVtbXkiLCJpc0xvZ2dlZEluIiwiaW1hZ2VQYXRocyIsIm1haW5Qb3N0cyIsIlVzZXIiLCJpZCIsIm5pY2tuYW1lIiwiY29udGVudCIsImltZyIsIkhvbWUiLCJtYXJnaW4iLCJtYXAiLCJ2IiwiaSIsImRpc3BsYXkiLCJ3aWR0aCIsImMiLCJjcmVhdGVkQXQiXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQUNBO0FBQ0E7QUFFQSxJQUFNQSxLQUFLLEdBQUc7QUFDVkMsWUFBVSxFQUFHLElBREg7QUFFVkMsWUFBVSxFQUFFLEVBRkY7QUFHVkMsV0FBUyxFQUFHLENBQUM7QUFDVEMsUUFBSSxFQUFHO0FBQ0hDLFFBQUUsRUFBRyxDQURGO0FBRUhDLGNBQVEsRUFBRztBQUZSLEtBREU7QUFLVEMsV0FBTyxFQUFHLFNBTEQ7QUFNVEMsT0FBRyxFQUFHO0FBTkcsR0FBRDtBQUhGLENBQWQ7O0FBYUEsSUFBTUMsSUFBSSxHQUFHLFNBQVBBLElBQU8sR0FBSztBQUNkLFNBQ0k7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxLQUNLVCxLQUFLLENBQUNDLFVBQU4sSUFBb0IsTUFBQyx5Q0FBRDtBQUFNLFNBQUssRUFBSTtBQUFDUyxZQUFNLEVBQUM7QUFBUixLQUFmO0FBQTBDLFdBQU8sRUFBRyxxQkFBcEQ7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxLQUNyQixNQUFDLDBDQUFELENBQU8sUUFBUDtBQUFnQixhQUFTLEVBQUksR0FBN0I7QUFBa0MsZUFBVyxFQUFHLG9EQUFoRDtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLElBRHFCLEVBRXJCO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsS0FDSSxNQUFDLDBDQUFEO0FBQU8sUUFBSSxFQUFHLE1BQWQ7QUFBcUIsWUFBUSxNQUE3QjtBQUE4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YjRmMi5ob3QtdXBkYXRlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IFJlYWN0IGZyb20gJ3JlYWN0JztcclxuaW1wb3J0IHtGb3JtLCBJbnB1dCwgQnV0dG9uLCBDYXJkLCBBdmF0YXJ9IGZyb20gJ2FudGQnXHJcbmltcG9ydCB7IEhlYXJ0T3V0bGluZWQsIFJldHdlZXRPdXRsaW5lZCwgTWVzc2FnZU91dGxpbmVkLCBFbGxpcHNpc091dGxpbmVkIH0gZnJvbSAnQGFudC1kZXNpZ24vaWNvbnMnO1xyXG5cclxuY29uc3QgZHVtbXkgPSB7XHJcbiAgICBpc0xvZ2dlZEluIDogdHJ1ZSxcclxuICAgIGltYWdlUGF0aHM6IFtdLFxyXG4gICAgbWFpblBvc3RzIDogW3tcclxuICAgICAgICBVc2VyIDoge1xyXG4gICAgICAgICAgICBpZCA6IDEsXHJcbiAgICAgICAgICAgIG5pY2tuYW1lIDogXCJEb2d2ZWxvcGVyXCIsXHJcbiAgICAgICAgfSxcclxuICAgICAgICBjb250ZW50IDogXCLssqvrsojsp7gg6rKM7Iuc6riAXCIsXHJcbiAgICAgICAgaW1nIDogJ2h0dHBzOi8vc291cmNlLnVuc3BsYXNoLmNvbS9yYW5kb20nLFxyXG4gICAgfV0sXHJcbn07XHJcblxyXG5jb25zdCBIb21lID0gKCkgPT57XHJcbiAgICByZXR1cm4gKFxyXG4gICAgICAgIDxkaXY+XHJcbiAgICAgICAgICAgIHtkdW1teS5pc0xvZ2dlZEluICYmIDxGb3JtIHN0eWxlID0ge3ttYXJnaW46JzEwcHgsIDAsIDIwcHgnIH19IGVuY1R5cGUgPSBcIm11bHRpcGFydC9mb3JtLWRhdGFcIj5cclxuICAgICAgICAgICAgPElucHV0LlRleHRBcmVhIG1heExlbmd0aCA9IHsxNTB9IHBsYWNlaG9sZGVyID0gXCLslrTrlqQg7J287J20IOyeiOyXiOuCmOyalFwiLz5cclxuICAgICAgICAgICAgPGRpdj5cclxuICAgICAgICAgICAgICAgIDxJbnB1dCB0eXBlID0gXCJmaWxlXCIgbXVsdGlwbGUgaGlkZGVuPjwvSW5wdXQ+XHJcbiAgICAgICAgICAgICAgICA8QnV0dG9uPuydtOuvuOyngCDsl4XroZzrk5w8L0J1dHRvbj5cclxuICAgICAgICAgICAgICAgIDxCdXR0b24gdHlwZSA9IFwicHJpbWFyeVwiIHN0eWxlID0ge3tmbG9hdDpcInJpZ2h0XCJ9fSBodG1sVHlwZSA9IFwic3VibWl0XCI+7KCc7LacPC9CdXR0b24+XHJcbiAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgICAgICA8ZGl2PlxyXG4gICAgICAgICAgICAgICAge2R1bW15LmltYWdlUGF0aHMubWFwKCh2LGkpPT57XHJcbiAgICAgICAgICAgICAgICAgICAgcmV0dXJuKFxyXG4gICAgICAgICAgICAgICAgICAgICAgICA8ZGl2IGtleT17dn0gc3R5bGU9e3tkaXNwbGF5OidpbmxpbmUtYmxvY2snfX0+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8aW1nIHNyYz17J2h0dHA6Ly9sb2NhbGhvc3Q6MzA2NS8nK3Z9IHN0eWxlID0ge3t3aWR0aDonMjAwcHgnfX0gYWx0ID0ge3Z9Lz5cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxkaXY+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgPEJ1dHRvbj7soJzqsbA8L0J1dHRvbj5cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgICAgICAgICAgICAgICAgICA8L2Rpdj5cclxuICAgICAgICAgICAgICAgICAgICApO1xyXG4gICAgICAgICAgICAgICAgfSl9XHJcbiAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgICAgICA8L0Zvcm0+fVxyXG4gICAgICAgICAgICB7ZHVtbXkubWFpblBvc3RzLm1hcCgoYyk9PntcclxuICAgICAgICAgICAgICAgIHJldHVybihcclxuICAgICAgICAgICAgICAgICAgICA8Q2FyZFxyXG4gICAgICAgICAgICAgICAgICAgICAgICBrZXk9eytjLmNyZWF0ZWRBdH1cclxuICAgICAgICAgICAgICAgICAgICAgICAgY292ZXI9e2MuaW1nICYmIDxpbWcgYWx0PVwiZXhhbXBsZVwiIHNyYz17Yy5pbWd9IC8+fVxyXG4gICAgICAgICAgICAgICAgICAgICAgICBhY3Rpb25zID0ge1tcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxSZXR3ZWV0T3V0bGluZWQga2V5PVwibWVzc2FnZVwiLz4sXHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8SGVhcnRPdXRsaW5lZCBrZXkgPSBcImhlYXJ0XCIgLz4sXHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8TWVzc2FnZU91dGxpbmVkIGtleT1cIm1lc3NhZ2VcIiAvPixcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxFbGxpcHNpc091dGxpbmVkIGtleT1cImVsbGlwc2lzXCIgLz4sXHJcbiAgICAgICAgICAgICAgICAgICAgICAgIF19XHJcbiAgICAgICAgICAgICAgICAgICAgICAgIGV4dHJhPXs8QnV0dG9uPu2MlOuhnOyasDwvQnV0dG9uPn1cclxuICAgICAgICAgICAgICAgICAgICA+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgIDxDYXJkLk1ldGFcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGF2YXRhcj17PEF2YXRhcj57Yy5Vc2VyLm5pY2tuYW1lWzBdfTwvQXZhdGFyPn1cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIHRpdGxlPXtjLlVzZXIubmlja25hbWV9XHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBkZXNjcmlwdGlvbj17Yy5jb250ZW50fVxyXG4gICAgICAgICAgICAgICAgICAgICAgICAvPlxyXG4gICAgICAgICAgICAgICAgICAgIDwvQ2FyZD5cclxuICAgICAgICAgICAgICAgICk7XHJcbiAgICAgICAgICAgIH0pfVxyXG4gICAgICAgIDwvZGl2PlxyXG4gICAgKTtcclxufTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IEhvbWU7Il0sInNvdXJjZVJvb3QiOiIifQ==
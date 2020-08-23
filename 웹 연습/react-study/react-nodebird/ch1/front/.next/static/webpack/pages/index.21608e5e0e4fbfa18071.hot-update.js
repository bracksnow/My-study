webpackHotUpdate_N_E("pages/index",{

/***/ "./components/PostFrom.js":
/*!********************************!*\
  !*** ./components/PostFrom.js ***!
  \********************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var antd__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! antd */ "./node_modules/antd/es/index.js");
var _this = undefined,
    _jsxFileName = "C:\\Users\\82108\\WebstormProjects\\react-nodebird\\ch1\\front\\components\\PostFrom.js";

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

var PostForm = function PostForm() {
  return __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Form"], {
    style: {
      margin: '10px, 0, 20px'
    },
    encType: "multipart/form-data",
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 19,
      columnNumber: 9
    }
  }, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Input"].TextArea, {
    maxLength: 150,
    placeholder: "\uC5B4\uB5A4 \uC77C\uC774 \uC788\uC5C8\uB098\uC694?",
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 20,
      columnNumber: 13
    }
  }), __jsx("div", {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 21,
      columnNumber: 13
    }
  }, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Input"], {
    type: "file",
    multiple: true,
    hidden: true,
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 22,
      columnNumber: 17
    }
  }), __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Button"], {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 23,
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
      lineNumber: 24,
      columnNumber: 17
    }
  }, "\uC81C\uCD9C")), __jsx("div", {
    __self: _this,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 26,
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
        lineNumber: 29,
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
        lineNumber: 30,
        columnNumber: 29
      }
    }), __jsx("div", {
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 31,
        columnNumber: 29
      }
    }, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Button"], {
      __self: _this,
      __source: {
        fileName: _jsxFileName,
        lineNumber: 32,
        columnNumber: 33
      }
    }, "\uC81C\uAC70")));
  })));
};

_c = PostForm;
/* harmony default export */ __webpack_exports__["default"] = (PostForm);

var _c;

$RefreshReg$(_c, "PostForm");

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
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vY29tcG9uZW50cy9Qb3N0RnJvbS5qcyJdLCJuYW1lcyI6WyJkdW1teSIsImlzTG9nZ2VkSW4iLCJpbWFnZVBhdGhzIiwibWFpblBvc3RzIiwiVXNlciIsImlkIiwibmlja25hbWUiLCJjb250ZW50IiwiaW1nIiwiUG9zdEZvcm0iLCJtYXJnaW4iLCJtYXAiLCJ2IiwiaSIsImRpc3BsYXkiLCJ3aWR0aCJdLCJtYXBwaW5ncyI6Ijs7Ozs7Ozs7Ozs7Ozs7Ozs7O0FBQUE7QUFDQTtBQUVBLElBQU1BLEtBQUssR0FBRztBQUNWQyxZQUFVLEVBQUcsSUFESDtBQUVWQyxZQUFVLEVBQUUsRUFGRjtBQUdWQyxXQUFTLEVBQUcsQ0FBQztBQUNUQyxRQUFJLEVBQUc7QUFDSEMsUUFBRSxFQUFHLENBREY7QUFFSEMsY0FBUSxFQUFHO0FBRlIsS0FERTtBQUtUQyxXQUFPLEVBQUcsU0FMRDtBQU1UQyxPQUFHLEVBQUc7QUFORyxHQUFEO0FBSEYsQ0FBZDs7QUFhQSxJQUFNQyxRQUFRLEdBQUksU0FBWkEsUUFBWSxHQUFLO0FBQ25CLFNBQ0ksTUFBQyx5Q0FBRDtBQUFNLFNBQUssRUFBSTtBQUFDQyxZQUFNLEVBQUM7QUFBUixLQUFmO0FBQTBDLFdBQU8sRUFBRyxxQkFBcEQ7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxLQUNJLE1BQUMsMENBQUQsQ0FBTyxRQUFQO0FBQWdCLGFBQVMsRUFBSSxHQUE3QjtBQUFrQyxlQUFXLEVBQUcscURBQWhEO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsSUFESixFQUVJO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsS0FDSSxNQUFDLDBDQUFEO0FBQU8sUUFBSSxFQUFHLE1BQWQ7QUFBcUIsWUFBUSxNQUE3QjtBQUE4QixVQUFNLE1BQXBDO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsSUFESixFQUVJLE1BQUMsMkNBQUQ7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSw2Q0FGSixFQUdJLE1BQUMsMkNBQUQ7QUFBUSxRQUFJLEVBQUcsU0FBZjtBQUF5QixTQUFLLEVBQUk7QUFBQyxlQUFNO0FBQVAsS0FBbEM7QUFBbUQsWUFBUSxFQUFHLFFBQTlEO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsb0JBSEosQ0FGSixFQU9JO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsS0FDS1YsS0FBSyxDQUFDRSxVQUFOLENBQWlCUyxHQUFqQixDQUFxQixVQUFDQyxDQUFELEVBQUdDLENBQUgsRUFBTztBQUN6QixXQUNJO0FBQUssU0FBRyxFQUFFRCxDQUFWO0FBQWEsV0FBSyxFQUFFO0FBQUNFLGVBQU8sRUFBQztBQUFULE9BQXBCO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsT0FDSTtBQUFLLFNBQUcsRUFBRSwyQkFBeUJGLENBQW5DO0FBQXNDLFdBQUssRUFBSTtBQUFDRyxhQUFLLEVBQUM7QUFBUCxPQUEvQztBQUFnRSxTQUFHLEVBQUlILENBQXZFO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsTUFESixFQUVJO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsT0FDSSxNQUFDLDJDQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsc0JBREosQ0FGSixDQURKO0FBUUgsR0FUQSxDQURMLENBUEosQ0FESjtBQXNCSCxDQXZCRDs7S0FBTUgsUTtBQXdCU0EsdUVBQWYiLCJmaWxlIjoic3RhdGljL3dlYnBhY2svcGFnZXMvaW5kZXguMjE2MDhlNWUwZTRmYmZhMTgwNzEuaG90LXVwZGF0ZS5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCBSZWFjdCBmcm9tICdyZWFjdCc7XHJcbmltcG9ydCB7QnV0dG9uLCBGb3JtLCBJbnB1dH0gZnJvbSBcImFudGRcIjtcclxuXHJcbmNvbnN0IGR1bW15ID0ge1xyXG4gICAgaXNMb2dnZWRJbiA6IHRydWUsXHJcbiAgICBpbWFnZVBhdGhzOiBbXSxcclxuICAgIG1haW5Qb3N0cyA6IFt7XHJcbiAgICAgICAgVXNlciA6IHtcclxuICAgICAgICAgICAgaWQgOiAxLFxyXG4gICAgICAgICAgICBuaWNrbmFtZSA6IFwiRG9ndmVsb3BlclwiLFxyXG4gICAgICAgIH0sXHJcbiAgICAgICAgY29udGVudCA6IFwi7LKr67KI7Ke4IOqyjOyLnOq4gFwiLFxyXG4gICAgICAgIGltZyA6ICdodHRwczovL3NvdXJjZS51bnNwbGFzaC5jb20vcmFuZG9tJyxcclxuICAgIH1dLFxyXG59O1xyXG5cclxuY29uc3QgUG9zdEZvcm0gID0gKCkgPT57XHJcbiAgICByZXR1cm4oXHJcbiAgICAgICAgPEZvcm0gc3R5bGUgPSB7e21hcmdpbjonMTBweCwgMCwgMjBweCcgfX0gZW5jVHlwZSA9IFwibXVsdGlwYXJ0L2Zvcm0tZGF0YVwiPlxyXG4gICAgICAgICAgICA8SW5wdXQuVGV4dEFyZWEgbWF4TGVuZ3RoID0gezE1MH0gcGxhY2Vob2xkZXIgPSBcIuyWtOuWpCDsnbzsnbQg7J6I7JeI64KY7JqUP1wiLz5cclxuICAgICAgICAgICAgPGRpdj5cclxuICAgICAgICAgICAgICAgIDxJbnB1dCB0eXBlID0gXCJmaWxlXCIgbXVsdGlwbGUgaGlkZGVuPjwvSW5wdXQ+XHJcbiAgICAgICAgICAgICAgICA8QnV0dG9uPuydtOuvuOyngCDsl4XroZzrk5w8L0J1dHRvbj5cclxuICAgICAgICAgICAgICAgIDxCdXR0b24gdHlwZSA9IFwicHJpbWFyeVwiIHN0eWxlID0ge3tmbG9hdDpcInJpZ2h0XCJ9fSBodG1sVHlwZSA9IFwic3VibWl0XCI+7KCc7LacPC9CdXR0b24+XHJcbiAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgICAgICA8ZGl2PlxyXG4gICAgICAgICAgICAgICAge2R1bW15LmltYWdlUGF0aHMubWFwKCh2LGkpPT57XHJcbiAgICAgICAgICAgICAgICAgICAgcmV0dXJuKFxyXG4gICAgICAgICAgICAgICAgICAgICAgICA8ZGl2IGtleT17dn0gc3R5bGU9e3tkaXNwbGF5OidpbmxpbmUtYmxvY2snfX0+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8aW1nIHNyYz17J2h0dHA6Ly9sb2NhbGhvc3Q6MzA2NS8nK3Z9IHN0eWxlID0ge3t3aWR0aDonMjAwcHgnfX0gYWx0ID0ge3Z9Lz5cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxkaXY+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgPEJ1dHRvbj7soJzqsbA8L0J1dHRvbj5cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgICAgICAgICAgICAgICAgICA8L2Rpdj5cclxuICAgICAgICAgICAgICAgICAgICApO1xyXG4gICAgICAgICAgICAgICAgfSl9XHJcbiAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgIDwvRm9ybT5cclxuICAgICk7XHJcbn1cclxuZXhwb3J0IGRlZmF1bHQgUG9zdEZvcm07Il0sInNvdXJjZVJvb3QiOiIifQ==
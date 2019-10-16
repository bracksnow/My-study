//학번:60161589 
//이름:권선구
"use strict";

function swap(arr, i, j) {
  var t = arr[i];
  arr[i] = arr[j];
  arr[j] = t;
}

/* 필요에 따라 추가 함수 구현 가능 */

function quickSort(arr, left, right) {
  var pl = left;
  var pr = right;
  var pivot = arr[(pl+pr)/2];
  do{
      while(arr[pl]<pivot){
        pl++;
      }
      while(arr[pr]>pivot){
        pr--;
      }
      if(pl<=pr){
          swap(arr,pl++,pr--);
      }
  }while(pl<=pr);

  if(left<pr){
    quickSort(arr,left,pr);
  }
  if(pl<right){
    quickSort(arr,pl,right);
  }
}
  /* 구현 필요 */


var data = [
  [6, 3, 2, 7, 8, 3, 1, 0, 9, 5],
  [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
  [9, 8, 7, 6, 5, 4, 3, 2, 1, 0],
  [1, 10, 2, 21],
  [],
  [1,1,1,1,1,1,1,1,1,1]
];

// 두 배열 a와 b의 내용을 비교. 같으면 true 아니면 false
function compareArray(a, b) {
  if (a.length !== b.length) {
    return false;
  }
  for(var i in a) {
    if (a[i] !== b[i]) {
      return false;
    }
  }
  return true;
}

// 배열 a의 각 원소를 복사하여 새로운 배열을 return
function deepCopyArray(a) {
  var ret = [];
  for(var i in a) {
    ret[i] = a[i];
  }
  return ret;
}

// 주어진 data에 대해 JavaScript Array.sort함수의 결과와 비교하여 다르면 에러 출력
for(var i in data) {
  var arr1 = deepCopyArray(data[i]);
  var arr2 = deepCopyArray(data[i]);
  quickSort(arr1,0,arr1.length-1);
  arr2.sort(function(a, b) {return a-b;});
  if (!compareArray(arr1, arr2)) {
    console.log("Fail!!!", data[i], arr1, arr2);
  }
}

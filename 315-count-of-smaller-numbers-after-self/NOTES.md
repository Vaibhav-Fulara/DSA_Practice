//         return res;
//     }
//     Number[] merge(Number[] left,Number[] right){
//         int length = left.length + right.length;
//         Number[] res = new Number[length];
//         int l=0,r=0,i=0;
//         while(i<length){
//             if(l<left.length && r<right.length){
//                 if(left[l].value<=right[r].value){
//                     left[l].smaller += r;
//                     res[i++] = left[l++];
//                 }
//                 else res[i++] = right[r++];
//             }
//             else if(l<left.length){
//                 left[l].smaller += r;
//                 res[i++] = left[l++];
//             }
//             else res[i++] = right[r++];
//         }
//         return res;
//     }
```
​
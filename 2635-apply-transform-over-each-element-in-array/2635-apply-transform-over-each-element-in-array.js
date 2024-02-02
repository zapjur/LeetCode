/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const array = [];
    let index = 0;
    for(const elem of arr){
        array[index] = fn(elem, index);
        index++;
    }
    return array;
};
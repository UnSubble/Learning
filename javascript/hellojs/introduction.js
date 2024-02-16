console.log('Hello, js!');
console.log(typeof 'böyle de yazilabilir');
console.log(typeof(6.3))

// var kullanmıyoruz artık. Sadece let ve const

let word = 'javascript'
console.log(word[0])
word[1] = 'A' // immutable...
console.log(word)

let numOne = 3;
console.log(3 == numOne)
let float = 1.3;
console.log(1.3 == float) // true

let str = "string"
console.log(str == "string") // true

let dizi = [1, 2, "3", true, 5, [4,5]]

let obj = {
    name: "hob",
    age: 31
}

console.log(typeof obj) // object

console.log(Math.round(5.5));

const test = "javascript"

test.length
test[0] // j

let regex = /deneme/gi // -> g: global=bütün text, i = case insensitive 

let sayi = '2'
parseInt(sayi) // 2
Number(sayi) // 2
+sayi // 2

// 0 haric tum sayilar, non empty stringler, true -> bunlar mantıksal olarak true verir

// == -> sadece degerin esit olup olmadigina bakar.
// === -> hem degerin hem de veri turunun ayni olup olmadigina bakar

console.log(5 == '5') // true
console.log(5 === '5') // false
console.log(5 !== '5') // true

// confirm("emin misin?") // cancel ok diye iki secenek verir. ok -> true , cancel -> false
// prompt("bir sayi gir") // input almak icin

const date = new Date();

const arr = Array()
const arr2 = []

console.log(typeof arr) // obj
console.log(Array.isArray(arr)) // true

// arr.slice() == arr.subArray() -> javadaki sub yerine slice kullanıyoruz

// arr.shift() --> removeFirst
// arr.unsihft() --> addFirst

// arr.pop() --> removeLast
// arr.push() --> addLast

function testing() {
    console.log("bu bir fonksiyon")
}
testing()

let retVal = testing()
console.log(typeof retVal)  // -> undefined

function varargsFunc(...args) {
    console.log(args) 
}

function varargsFunc2() {
    console.log(arguments)  // ...args yerine gecer.
}

const anonymousFunc = function(name) {
    console.log("hi", name)
}

anonymousFunc('test'); // --> kendi kendini cagiran fonksiyonlardan once ; koyulmalı

// kendi kendini cagiran fonksiyon
(function(n) {
    console.log(n * n)
})(4) // --> direkt call'layabiliyoruz.

const arrowFunc = () => {
    console.log("arrow function")
}

const lambda = name => {
    console.log(name)
}

lambda("ahmet")

const multipleParams = (name, age) => {
    console.log(`${name} is ${age} years old.`)
}

multipleParams("ahmet", 21)

const lambda2 = n => n * n

lambda2(2)

const defaultValFunc = function(num1 = 1, num2 = 3) {
    console.log(num1 * num2)
}

function t() {
    console.log("test")
}

t() // --> call

function k(haluk) {
    haluk()
}

k(t) // --> invoke

const user = {
    name: 'İsmail',
    surname: 'Kulak',
    age: 21,
    skills: [
        'Java'
    ]
}

console.log(user.name)

const user2 = {
    "phone number": '555555555' // --> birden fazla kelime ile key olusturmak istiyorsak string olarak olusturmaliyiz
}

console.log(user2["phone number"])

const objFunc = {
    firstName: 'İsmail',
    lastName: 'Kulak',
    age: 435,
    country: 'Turkey',
    getFullName: function() {
        return `${this.firstName} ${this.lastName}`
    },
    getFullNameWithLambda: () => `${user.firstName} ${user.lastName}`
}

Object.assign(objFunc) // --> clone()

for (let [key, val] of Object.entries(objFunc)) {
    console.log(key, ":", val)
}

Object.freeze(user) // immutable yapıyor. Exception fırlatmaz.



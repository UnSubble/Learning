#[derive(Debug)]
struct Person {
    name: String,
    age: i8,
    work: String
}

struct Point(i32, i32);

impl Person {
    fn new(name: &str, age: i8, work: &str) -> Person /* Self de yazabilirdik */ {
        Person {
            name: name.to_string(),
            age,
            work: work.to_string()
        }
    }

    // self, &self, mut self, &mut self
    fn get_age(&self) -> i8 {
        self.age
    }
}

#[derive(Debug)]
enum Shape {
    Circle(f64),
    Rectangle(f64, f64),
    Triangle(f64, f64, f64)
}

fn main() {
    let mut x: u32 = 10;
    match x {
        0..5 => println!("x is less than 5"),
        value @ 5 => println!("x is {}", value),
        6..=10 => println!("6<=x<=10"),
        _ => println!("idk")
    }

    loop {
        // infinite loop
        break;
    }

    for i in 1..=10 {
        println!("{i}");
    }

    let arr: [i32; 5] = [1,2,3,4,5];

    for item in arr {
        println!("{item}");
    }

    let mut result = match x {
        5 => "five",
        _ => "unknown"
    };

    println!("{result}");

    result = loop {
        x += 1;
        if x >= 100 {
            break "limit";
        }
    };

    println!("{result}");

    println!("{}", return_param(x as i64)) ;
    println!("{}", return_multiple().1);

    let (r, s) = return_multiple();
    println!("{} {}", r, s);

    let p1 = Person {
        name: "a".to_string(),
        age: 26,
        work: "dentist".to_string()
    };

    println!("{p1:?}");

    let p2 = Person {
        name: "b".to_string(),
        ..p1
    };

    println!("{:?}", p2);

    println!("{}", p2.get_age());

    let point = Point(5, 6);
    println!("{}, {}", point.0, point.1);

    let shape = Shape::Rectangle(18_f64, 28_f64);

    println!("{:?}", shape);
}

fn return_param(x: i64) -> i64 {
    x
}

fn return_multiple() -> (char, char) {
    ('r', 's')
}
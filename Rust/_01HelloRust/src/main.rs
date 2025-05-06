

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

    println!("{}", return_param(x as i64));
    println!("{}", return_multiple().1);

    let (r, s) = return_multiple();
    println!("{} {}", r, s);
}

fn return_param(x: i64) -> i64 {
    x
}

fn return_multiple() -> (char, char) {
    ('r', 's')
}
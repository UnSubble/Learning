package _02.notes;

public class Notes_2 {

}

// Richardson modelinde 3 tane faktor RESTFul web servicelerin gelismislik/olgunluk seviyesini belirtir.

// URI (uniform resource identifier)
// HTTP methods
// Hypermedia

// Level Zero
// Level One
// Level Two
// Level Three

//-------
// LEVEL ZERO
// bu level tipik özelliği ; single URI , single method
// servisin tek bir giriş noktası ve tek bir method kullanılmaktadır (genelde http post)
// bu yaklaşım SOAP web service'lerinde yer almaktadır. tek giriş noktası ve http post 

// Level ONE
// ---------
// multiple uri , single method
// burada birden fazla uri var, fakat yine tek tip method yer almaktadır (HTTP POST)

// Level TWO
// ---------
// multiple uri , multiple method
// CRUD -> create (post) , read (get) , update(put), delete (delete)

// Level THREE
// -----------
// multiple uri , multiple methods , hypermedia/hateoas

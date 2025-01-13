interface Room {
	
}

class LuxuryRoom implements Room {
	
}

enum RoomType implements Room {
	SINGLE, DOUBLE
}

void main() {
	checkin(new LuxuryRoom());
}

void checkin(Room room) {
	switch (room) {
	case RoomType.SINGLE -> System.out.println("Single room checkin successful");
	case RoomType.DOUBLE -> System.out.println("Double room checkin successful");
	case LuxuryRoom l -> System.out.println("Luxury room checkin successful");
	default -> System.out.println("Room was not found");
	}
}

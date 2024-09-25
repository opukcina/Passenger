package pm;

    class Passenger {
        String name;
        Passenger next;

        // Constructor
        public Passenger(String name) {
            this.name = name;
            this.next = null;
        }
    }

    class Flight {
        private Passenger head;

        // Constructor
        public Flight() {
            this.head = null;
        }

        public void addPassenger(String name) {
            Passenger newPassenger = new Passenger(name);

            if (head == null) {
                head = newPassenger;
            } else {
                Passenger temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newPassenger;
            }
        }

        public void removePassenger(String name) {
            if (head == null) {
                System.out.println("Daftar penumpang kosong.");
                return;
            }

            if (head.name.equals(name)) {
                head = head.next;
                System.out.println("Penumpang " + name + " berhasil dihapus.");
                return;
            }

            Passenger current = head;
            Passenger previous = null;

            while (current != null && !current.name.equals(name)) {
                previous = current;
                current = current.next;
            }

            if (current == null) {
                System.out.println("Penumpang " + name + " tidak ditemukan.");
            } else {
                // Hapus penumpang dengan menghubungkan node sebelumnya ke node berikutnya
                previous.next = current.next;
                System.out.println("Penumpang " + name + " berhasil dihapus.");
            }
        }

        public void displayPassengers() {
            if (head == null) {
                System.out.println("Daftar penumpang kosong.");
            } else {
                Passenger temp = head;
                while (temp != null) {
                    System.out.println(temp.name);
                    temp = temp.next;
                }
            }
        }

        public static void main(String[] args) {
            Flight flight = new Flight();
            flight.addPassenger("Nugra");
            flight.addPassenger("Ofuk");
            flight.addPassenger("Jaky");

            System.out.println("Daftar penumpang sebelum penghapusan:");
            flight.displayPassengers();

            flight.removePassenger("Ofuk");

            System.out.println("\nDaftar penumpang setelah penghapusan:");
            flight.displayPassengers();
        }
    }



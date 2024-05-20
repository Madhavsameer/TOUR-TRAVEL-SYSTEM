import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.Text;
public class vehiclebooking extends Frame implements ActionListener, ItemListener {

    Label t1, heading, userinfo, nameLabel, contactLabel, genderLabel, foodLabel, journeyInfo, fromLabel,
            destinationLabel, dateLabel, seatLabel,
            nameW, contactNumW, dateInputW, seatInputW, availableSeats, bookingDetails;
    String headersName[] = { "Booking Id", "Date", "From", "To", "Name", "PhoneNo", "Gender", "Food", "Seats" };
    Label Header[] = new Label[10];
    Label bookingIdOP[] = new Label[100];
    Label dateOP[] = new Label[100];
    Label fromOP[] = new Label[100];
    Label toOP[] = new Label[100];
    Label nameOP[] = new Label[100];
    Label phonenoOP[] = new Label[100];
    Label genderOP[] = new Label[100];
    Label foodOP[] = new Label[100];
    Label seatsOP[] = new Label[100];
    TextField name, contactNum, dateInput;
    Checkbox Male, Female, Veg, Nveg;
    Choice from, destination, seatInput;
    Button b1;
    TextArea t2;
    int bookingsId = 0;
    BookingDetails ticketDetails[] = new BookingDetails[100];

    vehiclebooking() {
        setSize(1910, 900);
        setTitle("Sameer Travels");
        setLayout(null);
        setVisible(true);
        setBackground((Color.pink));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        

        // Heading
        heading = new Label("Sameer Travels", Label.CENTER);
        heading.setBounds(150, 40, 1300, 35);
        heading.setFont(new Font("arial", Font.BOLD, 35));
        heading.setForeground((Color.blue));
        add(heading);

        // Form Labels
        // Journey Information
        journeyInfo = new Label("Journey Information", Label.RIGHT);
        journeyInfo.setBounds(1000, 100, 200, 30);
        journeyInfo.setFont(new Font("Helvetica", Font.BOLD, 15));
        add(journeyInfo);

        bookingDetails = new Label("Enter your Booking Details",Label.LEFT);
        bookingDetails.setBounds(500, 100, 200, 30);
        bookingDetails.setFont(new Font("Helvetica", Font.BOLD, 15));
        add(bookingDetails);

        dateLabel = new Label("Date:");
        dateInput = new TextField();
        dateLabel.setBounds(400, 150, 100, 25);
        dateInput.setBounds(500, 150, 100, 25);
        dateLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        add(dateLabel);
        add(dateInput);

        fromLabel = new Label("From :");

        from = new Choice();
        from.add("Select");
        from.add("Patna");
        from.add("Kolkata");
        from.add("Ranchi");
        from.add("Bhuvaneshwar");
        from.add("Vishakhapatanam");
        from.add("Hyderabad");
        from.add("Bhopal");
        from.add("Bengalure");
        from.add("Chennai");
        from.addItemListener(this);
        fromLabel.setBounds(300, 200, 100, 25);
        from.setBounds(400, 200, 70, 100);
        fromLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        add(fromLabel);
        add(from);

        destinationLabel = new Label("To :");
        destination = new Choice();
        destination.add("Select");
        destination.add("Patna");
        destination.add("Kolkata");
        destination.add("Ranchi");
        destination.add("Bhuvaneshwar");
        destination.add("Vishakhapatanam");
        destination.add("Hyderabad");
        destination.add("Bhopal");
        destination.add("Bengalure");
        destination.add("Chennai");
        destination.addItemListener(this);
        destinationLabel.setBounds(500, 200, 100, 25);
        destination.setBounds(600, 200, 70, 100);
        destinationLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        add(destinationLabel);
        add(destination);

        availableSeats = new Label("", Label.CENTER);
        availableSeats.setBounds(400, 250, 300, 30);
        availableSeats.setFont(new Font("Helvetica", Font.BOLD, 15));
        add(availableSeats);

        // User Information
        userinfo = new Label("User Information", Label.CENTER);
        userinfo.setBounds(400, 300, 300, 30);
        userinfo.setFont(new Font("Helvetica", Font.BOLD, 15));
        add(userinfo);

        nameLabel = new Label("Name:");
        name = new TextField();
        nameLabel.setBounds(400, 350, 100, 25);
        name.setBounds(500, 350, 100, 25);
        nameLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        add(nameLabel);
        add(name);

        contactLabel = new Label("Contact Number:");
        contactNum = new TextField("+91");
        contactLabel.setBounds(400, 400, 100, 25);
        contactNum.setBounds(500, 400, 100, 25);
        contactLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        add(contactLabel);
        add(contactNum);

        genderLabel = new Label("Gender:");
        CheckboxGroup genderBox = new CheckboxGroup();
        Male = new Checkbox("Male", genderBox, false);
        Female = new Checkbox("Female", genderBox, false);
        genderLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        Male.setFont(new Font("Helvetica", Font.BOLD, 12));
        Female.setFont(new Font("Helvetica", Font.BOLD, 12));
        genderLabel.setBounds(400, 450, 100, 25);
        Male.setBounds(500, 450, 50, 25);
        Female.setBounds(550, 450, 60, 25);
        add(genderLabel);
        add(Male);
        add(Female);

        foodLabel = new Label("Food Preference:");
        CheckboxGroup foodBox = new CheckboxGroup();
        Veg = new Checkbox("Veg", foodBox, false);
        Nveg = new Checkbox("Non Veg", foodBox, false);
        foodLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        Veg.setFont(new Font("Helvetica", Font.BOLD, 12));
        Nveg.setFont(new Font("Helvetica", Font.BOLD, 12));
        foodLabel.setBounds(400, 500, 100, 25);
        Veg.setBounds(500, 500, 50, 25);
        Nveg.setBounds(550, 500, 60, 25);
        add(foodLabel);
        add(Veg);
        add(Nveg);

        seatLabel = new Label("Seats :");
        seatInput = new Choice();
        seatInput.add("1");
        seatInput.add("2");
        seatInput.add("3");
        seatInput.add("4");
        seatInput.add("5");
        seatLabel.setBounds(400, 550, 100, 25);
        seatInput.setBounds(500, 550, 100, 25);
        seatLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
        add(seatInput);
        add(seatLabel);

        b1 = new Button("Book Ticket");
        b1.setBounds(500, 600, 100, 25);
        b1.addActionListener(this);
        b1.setBackground(Color.green);
        add(b1);

        t1 = new Label("Bookings Confirmed :-)", Label.CENTER);
        t1.setBounds(500, 650, 1000, 30);
        t1.setFont(new Font("Helvetica", Font.BOLD, 12));
        add(t1);

        // Booked Tickets Details
        for (int i = 0; i < headersName.length; i++) {
            Header[i] = new Label(headersName[i]);
            Header[i].setFont(new Font("Helvetica", Font.BOLD, 12));
            Header[i].setBounds(800 + (i * 85), 150, 85, 30);
            add(Header[i]);
        }
    }
    
    

    public static void main(String[] args) {
        new vehiclebooking();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String Source, Destination;
        Source = from.getSelectedItem();
        Destination = destination.getSelectedItem();

        if (Source.equals("Select") || Destination.equals("Select")) {
            availableSeats.setText("Select Proper Source And Destination");
            availableSeats.setForeground(Color.RED);
        }

        else if (Source.equals(Destination)) {
            availableSeats.setText("Source And Destination Can't Be Same");
            availableSeats.setForeground(Color.RED);
        }

        else {
            availableSeats.setText("100 Seats Available");
            availableSeats.setForeground(Color.green);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Source, Destination, date;
        Source = from.getSelectedItem();
        Destination = destination.getSelectedItem();
        String Name, ContactNum, Seats;
        boolean male, female, veg, nVeg;
        Name = name.getText();
        ContactNum = contactNum.getText();
        Seats = seatInput.getSelectedItem();
        male = Male.getState();
        female = Female.getState();
        veg = Veg.getState();
        nVeg = Nveg.getState();
        date = dateInput.getText();

        if (date.isEmpty()) {
            availableSeats.setText("Select Date");
            availableSeats.setForeground(Color.RED);
        }

        else if (Source.equals("Select") || Destination.equals("Select")) {
            availableSeats.setText("Select Proper Source And Destination");
            availableSeats.setForeground(Color.RED);
        }

        else if (Source.equals(Destination)) {
            availableSeats.setText("Source And Destination Can't Be Same");
            availableSeats.setForeground(Color.RED);
        }

        else if (Name.isEmpty()) {
            t1.setText("Enter Proper Name");
            t1.setForeground(Color.red);
        }

        else if (ContactNum.isEmpty() || ContactNum.length() < 10) {
            t1.setText("Enter Proper Contact Number");
            t1.setForeground(Color.red);
        }

        else if (!male && !female) {
            t1.setText("Select Proper Gender");
            t1.setForeground(Color.red);
        }

        else if (!veg && !nVeg) {
            t1.setText("Select Food Preference");
            t1.setForeground(Color.red);
        }

        else {
            t1.setText("Bookings Confirmed :-)");
            t1.setForeground(Color.GREEN);
            ticketDetails[bookingsId] = new  BookingDetails(bookingsId, date, Name, ContactNum, Seats, Source,
                    Destination, male, female, veg, nVeg);
            setTicketDetails(ticketDetails[bookingsId]);
            bookingsId++;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            clearField();
        }
    }
    

    void setTicketDetails(BookingDetails ticket) {
        bookingIdOP[ticket.getBookingID()] = new Label("AST121" + ticket.getBookingID());
        dateOP[ticket.getBookingID()] = new Label(ticket.getDate());
        fromOP[ticket.getBookingID()] = new Label(ticket.getFrom());
        toOP[ticket.getBookingID()] = new Label(ticket.getDestination());
        nameOP[ticket.getBookingID()] = new Label(ticket.getName());
        phonenoOP[ticket.getBookingID()] = new Label(ticket.getContactNum());
        genderOP[ticket.getBookingID()] = new Label(ticket.getGender());
        foodOP[ticket.getBookingID()] = new Label(ticket.getFood());
        seatsOP[ticket.getBookingID()] = new Label(ticket.getSeats());

        bookingIdOP[ticket.getBookingID()].setBounds(800, 200 + (ticket.getBookingID() * 50), 85, 30);
        dateOP[ticket.getBookingID()].setBounds(885, 200 + (ticket.getBookingID() * 50), 85, 30);
        fromOP[ticket.getBookingID()].setBounds(970, 200 + (ticket.getBookingID() * 50), 85, 30);
        toOP[ticket.getBookingID()].setBounds(1055, 200 + (ticket.getBookingID() * 50), 85, 30);
        nameOP[ticket.getBookingID()].setBounds(1140, 200 + (ticket.getBookingID() * 50), 85, 30);
        phonenoOP[ticket.getBookingID()].setBounds(1205, 200 + (ticket.getBookingID() * 50), 85, 30);
        genderOP[ticket.getBookingID()].setBounds(1330, 200 + (ticket.getBookingID() * 50), 85, 30);
        foodOP[ticket.getBookingID()].setBounds(1395, 200 + (ticket.getBookingID() * 50), 85, 30);
        seatsOP[ticket.getBookingID()].setBounds(1480, 200 + (ticket.getBookingID() * 50), 85, 30);

        add(bookingIdOP[ticket.getBookingID()]);
        add(dateOP[ticket.getBookingID()]);
        add(fromOP[ticket.getBookingID()]);
        add(toOP[ticket.getBookingID()]);
        add(nameOP[ticket.getBookingID()]);
        add(phonenoOP[ticket.getBookingID()]);
        add(genderOP[ticket.getBookingID()]);
        add(foodOP[ticket.getBookingID()]);
        add(seatsOP[ticket.getBookingID()]);

    }

    void clearField() {
        dateInput.setText("");
        from.select(0);
        destination.select(0);
        availableSeats.setText("");
        name.setText("");
        contactNum.setText("");
        Male.setState(false);
        Female.setState(false);
        Veg.setState(false);
        Nveg.setState(false);
        seatInput.select(0);
        t1.setText("");
    }

    class BookingDetails {
        private String Name, ContactNum, Seats, gender, food, Source, destination, date;
        private boolean male, female, veg, nveg;
        private int BookingID;

        public BookingDetails(int BookingID, String date, String Name, String ContactNum, String Seats, String from,
                String destination, boolean male, boolean female, boolean veg, boolean nveg) {
            this.BookingID = BookingID;
            this.date = date;
            this.Name = Name;
            this.ContactNum = ContactNum;
            this.Seats = Seats;
            this.Source = from;
            this.destination = destination;
            this.male = male;
            this.female = female;
            this.veg = veg;
            this.nveg = nveg;
        }

        public String getFrom() {
            return Source;
        }

        public String getDestination() {
            return destination;
        }

        public String getName() {
            return Name;
        }

        public String getContactNum() {
            return ContactNum;
        }

        public String getDate() {
            return date;
        }

        public String getSeats() {
            return Seats;
        }

        public int getBookingID() {
            return BookingID;
        }

        public String getGender() {

            if (male) {
                gender = "Male";
            }

            else {
                gender = "Female";
            }
            return gender;
        }

        public String getFood() {
            if (veg) {
                food = "Veg";
            }

            else {
                food = "Non-Veg";
            }
            return food;
            
        }
    }
}
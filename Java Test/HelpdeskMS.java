class Employee 
{
    String fullName, assignedCategory;;
    int pointLevel;
    

    public Employee(String fullName, int pointLevel, String assignedCategory) 
    {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.assignedCategory = assignedCategory;
    }
}

class Ticket 
{
    int id, point;
    String name;
    String category;
    String assignedEmployee = "";
    boolean isCompleted = false;

    public Ticket(int id, String name, String category, int point) 
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.point = point;
    }
}

class HelpDesk 
{
    Employee emp1, emp2;
    Ticket[] tickets = new Ticket[5];

    void setEmployee1(Employee e) {emp1 = e;}

    void setEmployee2(Employee e) {emp2 = e;}

    void addTicket(Ticket t, int pos) 
    {
        if (pos >= 1 && pos <= 5) tickets[pos - 1] = t;
    }

    void completeTicket(String employeeName, int ticketId) 
    {
        Employee employee = (emp1 != null && emp1.fullName.equals(employeeName)) ? emp1 :
                            (emp2 != null && emp2.fullName.equals(employeeName)) ? emp2 : null;
        if (employee == null) 
        {
            System.out.println("Employee not found.");
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) 
        {
            Ticket t = tickets[i];
            if (t != null && t.id == ticketId) 
            {
                if (t.isCompleted) 
                {
                    System.out.println("Ticket " + ticketId + " is already completed.");
                    return;
                }
                if (employee.pointLevel >= t.point) 
                {
                    t.isCompleted = true;
                    t.assignedEmployee = employeeName;
                    System.out.println("Ticket " + ticketId + " marked as completed by " + employeeName + ".");
                } 
                else 
                {
                    System.out.println("Ticket " + ticketId + " cannot be completed by " + employeeName + " (Insufficient points). ");
                }
                return;
            }
        }
        System.out.println("Ticket not found.");
    }

    int getWaitingTicketCount() 
    {
        int count = 0;
        for (int i = 0; i < tickets.length; i++) 
        {
            if (tickets[i] != null && !tickets[i].isCompleted) count++;
        }
        return count;
    }

    int getCompletedTicketsTotalPoint() 
    {
        int sum = 0;
        for (int i = 0; i < tickets.length; i++) 
        {
            if (tickets[i] != null && tickets[i].isCompleted) sum += tickets[i].point;
        }
        return sum;
    }
}

public class HelpdeskMS{
    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();
        
        Employee alice = new Employee("Alice Brown", 5, "SOFTWARE");
        Employee bob = new Employee("Bob Smith", 8, "HARDWARE");
        helpDesk.setEmployee1(alice);
        helpDesk.setEmployee2(bob);
        
        Ticket t1 = new Ticket(101, "Software Bug", "SOFTWARE", 4);
        Ticket t2 = new Ticket(102, "Network Issue", "HARDWARE", 7);
        Ticket t3 = new Ticket(103, "System Crash", "HARDWARE", 10);
        Ticket t4 = new Ticket(104, "Printer Not Working", "HARDWARE", 3);
        Ticket t5 = new Ticket(105, "UI Bug", "SOFTWARE", 2);
        
        helpDesk.addTicket(t1, 1);
        helpDesk.addTicket(t2, 2);
        helpDesk.addTicket(t3, 3);
        helpDesk.addTicket(t4, 4);
        helpDesk.addTicket(t5, 5);
        
        helpDesk.completeTicket("Alice Brown", 101);
        helpDesk.completeTicket("Bob Smith", 102);
        helpDesk.completeTicket("Alice Brown", 103);
        helpDesk.completeTicket("Bob Smith", 104);
        helpDesk.completeTicket("Alice Brown", 105);
        
        System.out.println(helpDesk.getWaitingTicketCount()); 
        System.out.println(helpDesk.getCompletedTicketsTotalPoint());
    }
}

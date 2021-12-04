package com.example.flyaway.FlyAway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlyAwayservice {

    public List<Customer> getCustomers;
    @Autowired
    private FlyAwayrepositary flyAwayrepositary;

    @Autowired
    private FlyAwayrepositaryForAdmin flyAwayrepositaryForAdmin;

    @Autowired
    private FlyawayrepositaryForCustomer flyawayrepositaryForCustomer;

    public List<Flight> getFlights(Flight flight) {
        List<Flight> flights = flyAwayrepositary.findFlights(flight.getDate(), flight.getDestination(), flight.getPerson(), flight.getSource());
        return flights;
    }

    public void save(Admin user) {

        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        String mobileno = user.getMobileno();
        String address = user.getAddress();
        String password = user.getPassword();

        if (!firstname.equals("") && !lastname.equals("") && !mobileno.equals("") && !address.equals("") && !password.equals("")) {
            flyAwayrepositaryForAdmin.save(user);
        }
    }

    public boolean validation(Admin user) {
        List<Admin> users = (List<Admin>) flyAwayrepositaryForAdmin.findAll();
        for (int i = 0; i < users.size(); i++) {
            Admin a = users.get(i);
            if (user.getMobileno().equals(a.getMobileno()) && user.getPassword().equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public Admin update(Admin user) {
        Admin existingAdmin = flyAwayrepositaryForAdmin.findByMobileno(user.getMobileno());
        existingAdmin.setPassword(user.getPassword());
        return flyAwayrepositaryForAdmin.save(existingAdmin);
    }

    public void savecustomer(Customer user) {
        flyawayrepositaryForCustomer.save(user);
    }

    public void saveflight(Flight user) {
        flyAwayrepositary.save(user);
    }

    public List<Customer> findcustomerdata(Customer user) {
        List<Customer> users = (List<Customer>) flyawayrepositaryForCustomer.findAll();
        return users;
    }

    public List<Flight> findflightdata(Customer user) {
        List<Flight>users=(List<Flight>)flyAwayrepositary.findAll();
        return users;
    }

    public void submitsave(Customer user) {
        flyawayrepositaryForCustomer.save(user);
    }
}



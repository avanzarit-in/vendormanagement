package com.avanzarit.apps.gst.batch.job.customerimport;

import com.avanzarit.apps.gst.auth.model.Role;
import com.avanzarit.apps.gst.auth.model.User;
import com.avanzarit.apps.gst.auth.model.UserStatusEnum;
import com.avanzarit.apps.gst.auth.properties.UserProperties;
import com.avanzarit.apps.gst.auth.repository.RoleRepository;
import com.avanzarit.apps.gst.auth.service.UserService;
import com.avanzarit.apps.gst.email.EmailServiceImpl;
import com.avanzarit.apps.gst.model.Customer;
import com.avanzarit.apps.gst.properties.AppProperties;
import com.avanzarit.apps.gst.repository.CustomerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CustomerDataImportWriter implements ItemWriter<Customer> {

    private UserService userService;
    private RoleRepository roleRepository;
    private CustomerRepository customerRepository;
    private SimpleMailMessage template;
    private EmailServiceImpl emailService;
    private String defaultPassword;
    private String contextURL;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setTemplate(SimpleMailMessage updatePasswordMessage) {
        this.template = updatePasswordMessage;
    }

    @Autowired
    public void setEmailService(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setDefaultPassword(UserProperties properties) {
        this.defaultPassword = properties.getDefaultPassword();
    }

    @Autowired
    public void setContextURL(AppProperties properties) {
        this.contextURL = properties.getContextURL();

    }

    @Override
    public void write(List<? extends Customer> customers) throws Exception {
        for (Customer customer : customers) {

            customerRepository.save(customer);

            if (userService.findByUsername(customer.getCustomerId()) == null) {
                Role vendorRole = roleRepository.findByName("CUSTOMER");
                Set<Role> roleSet = new HashSet<>();
                roleSet.add(vendorRole);
                User user = new User();
                user.setUsername(customer.getCustomerId());
                user.setPassword(defaultPassword);
                user.setEmail(customer.getEmail());
                user.setUserStatus(UserStatusEnum.NEW);
                user.setRoles(roleSet);
                userService.save(user);

                if (!StringUtils.isEmpty(user.getEmail())) {
                    String text = String.format(template.getText(), contextURL, user.getUsername(), defaultPassword);
                    emailService.sendSimpleMessage(user.getEmail(), "Welcome to Customer Management Portal", text);
                }
            }
        }
    }
}

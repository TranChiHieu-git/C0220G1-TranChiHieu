package com.codegym.furama.controller;


import com.codegym.furama.SesionStaff.staff;
import com.codegym.furama.model.admin.ContractModel.Contract;
import com.codegym.furama.model.admin.ContractModel.ContractDetails.ContractDetails;
import com.codegym.furama.model.admin.ContractModel.ContractDetails.Servicefollow.ServiceFollow;
import com.codegym.furama.model.admin.ServiceModel.Service;
import com.codegym.furama.model.admin.ServiceModel.TypeRent.TypeRent;
import com.codegym.furama.model.admin.ServiceModel.TypeService.TypeService;
import com.codegym.furama.model.admin.StaffModel.LevelModel.Level;
import com.codegym.furama.model.admin.StaffModel.PartModel.Part;
import com.codegym.furama.model.admin.StaffModel.PositionModel.Position;
import com.codegym.furama.model.admin.StaffModel.Staff;
import com.codegym.furama.model.admin.UserModel.TypeUserModel.TypeUser;
import com.codegym.furama.model.admin.UserModel.User;
import com.codegym.furama.model.admin.account.accountLogin;
import com.codegym.furama.model.admin.validateContract.validateContract;
import com.codegym.furama.model.admin.validateContractDetails.validConDe;
import com.codegym.furama.model.admin.validateService.ServiceValid;
import com.codegym.furama.model.admin.validateStaff.staffValid;
import com.codegym.furama.model.admin.validateUser.validateUser;
import com.codegym.furama.model.user.accountUserNormal.accountUserNormal;
import com.codegym.furama.model.user.accountUserNormal.usernormal;
import com.codegym.furama.model.user.accountUserNormal.validateAccountUser;
import com.codegym.furama.service.Contract.ContractDetailsService;
import com.codegym.furama.service.Contract.ContractService;
import com.codegym.furama.service.Contract.serviceFollowService;
import com.codegym.furama.service.Service.ServiceService;
import com.codegym.furama.service.Service.TypeRentSerVice;
import com.codegym.furama.service.Service.TypeSerViceService;
import com.codegym.furama.service.Staff.StaffService;
import com.codegym.furama.service.Staff.LevelService;
import com.codegym.furama.service.Staff.PartService;
import com.codegym.furama.service.Staff.PositionService;
import com.codegym.furama.service.User.TypeUSerService;
import com.codegym.furama.service.User.UserService;
import com.codegym.furama.service.UserNormal.UserNormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"staff", "usernormal"})

public class IndexController {
    @Autowired
    StaffService staffService;
    @Autowired
    LevelService levelService;
    @Autowired
    PartService partService;
    @Autowired
    PositionService positionService;
    @Autowired
    TypeRentSerVice typeRentSerVice;
    @Autowired
    TypeSerViceService typeSerViceService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    UserService userService;
    @Autowired
    TypeUSerService typeUSerService;
    @Autowired
    ContractService contractService;
    @Autowired
    serviceFollowService serviceFollowService;
    @Autowired
    ContractDetailsService contractDetailsService;
    @Autowired
    UserNormalService userNormalService;

    @ModelAttribute("typerent")
    public Iterable<TypeRent> typeRents() {
        return typeRentSerVice.findAllTypeRent();
    }

    @ModelAttribute("typeservice")
    public Iterable<TypeService> typeServices() {
        return typeSerViceService.findAllTypeService();
    }

    @ModelAttribute("level")
    public Iterable<Level> levels() {
        return levelService.findAllLevel();
    }

    @ModelAttribute("part")
    public Iterable<Part> parts() {
        return partService.findAllPart();
    }

    @ModelAttribute("pos")
    public Iterable<Position> positions() {
        return positionService.findAllPos();
    }

    @ModelAttribute("staff")
    public staff setStaff() {
        return new staff();
    }

    @ModelAttribute("usernormal")
    public usernormal setUserNormal() {
        return new usernormal();
    }

    @ModelAttribute("typeuser")
    public Iterable<TypeUser> typeUsers() {
        return typeUSerService.findAllTypeUSer();
    }

    @ModelAttribute("stafff")
    public Iterable<Staff> staffs() {
        return staffService.findAllStaff();
    }

    @ModelAttribute("service")
    public Iterable<Service> services() {
        return serviceService.findAllService();
    }

    @ModelAttribute("user")
    public Iterable<User> users() {
        return userService.findAllUser();
    }

    @ModelAttribute("servicefollow")
    public Iterable<ServiceFollow> serviceFollows() {
        return serviceFollowService.findAllServiceFollow();
    }

    @GetMapping("/")
    public ModelAndView index(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal) {
        ModelAndView modelAndView = new ModelAndView("user/index");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null && usernormal.getAccountUserNormal() == null) {
            modelAndView.setViewName("admin/index");
        } else if (staff.getStaff() == null && usernormal.getAccountUserNormal() != null) {
            modelAndView.setViewName("user/index");
        } else {
            modelAndView.addObject("accountLogin", new accountLogin());
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal) {
        ModelAndView modelAndView = new ModelAndView("user/index");
        staff.setStaff(null);
        usernormal.setAccountUserNormal(null);
        return modelAndView;
    }

    @PostMapping("/logined")
    public ModelAndView logined(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal,
                                @Valid @ModelAttribute("accountLogin") accountLogin accountLogin, BindingResult bindingResult,
                                @PageableDefault(size = 8) Pageable pageable) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }
        String isStaff = accountLogin.getAcc().substring(0, 6);
        Staff staf = staffService.findAcc(accountLogin.getAcc(), accountLogin.getPass());
        accountUserNormal accountUserNormal = userNormalService.comfirmlogin(accountLogin.getAcc(), accountLogin.getPass());
        ModelAndView modelAndView = new ModelAndView("login");
        if ((isStaff.equals("admin-")) && (staf != null) && (accountUserNormal == null)) {
            modelAndView.setViewName("admin/index");
            staff.setStaff(staf);
            modelAndView.addObject("listUserHaveContract", contractService.findAllContractOrderByName(pageable));
            modelAndView.addObject("message", 0);
        } else if (!(isStaff.equals("admin-")) && (staf == null) && (accountUserNormal != null)) {
            modelAndView.setViewName("user/index");
            usernormal.setAccountUserNormal(accountUserNormal);
        }
        return modelAndView;
    }

    @GetMapping("/admin/nhanvien")
    public ModelAndView adminNhanVien(@ModelAttribute("staff") staff staff, @PageableDefault(size = 10) Pageable pageable,
                                      @RequestParam Optional<String> keyword) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/index");
            String keywordLast = null;
            if (keyword.isPresent()) {
                keywordLast = keyword.get();
                modelAndView.addObject("listStaff", staffService.findStaffByName(keywordLast, pageable));
            } else {

                modelAndView.addObject("listStaff", staffService.findAllStaff(pageable));
            }
            modelAndView.addObject("message", 1);
            modelAndView.addObject("keyword", keywordLast);
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @GetMapping("/admin/nhanvien/add")
    public ModelAndView addNhanVien(@ModelAttribute("staff") staff staff) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/staff/addnhanvien");
            modelAndView.addObject("staffNew", new staffValid());
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/nhanvien/added")
    public ModelAndView checkValidation(@ModelAttribute("staff") staff staff, @Valid @ModelAttribute("staffNew") staffValid staffValid,
                                        BindingResult bindingResult, @PageableDefault(size = 10) Pageable pageable) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/staff/addnhanvien");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/index");
                staffService.saveStaff(new Staff(staffValid.name, staffValid.dayOfBirth, staffValid.numberOfCMND, staffValid.salary,
                        staffValid.numberPhone, staffValid.email, staffValid.address, staffValid.account, staffValid.password,
                        positionService.findPosById(staffValid.idPosition), partService.findPartById(staffValid.idPosition),
                        levelService.findLevelById(staffValid.idLevel)));
                modelAndView.addObject("listStaff", staffService.findAllStaff(pageable));
                modelAndView.addObject("message", 1);
            }
            modelAndView.addObject("accountLogin", new accountLogin());
            return modelAndView;
        }
    }

    @GetMapping("/admin/nhanvien/read/{id}")
    ModelAndView readStaff(@ModelAttribute("staff") staff staff, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("staffByid", staffService.findStaffById(id));
            modelAndView.setViewName("admin/staff/staffinfor");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @GetMapping("/admin/nhanvien/delete/{id}")
    ModelAndView deleteStaff(@ModelAttribute("staff") staff staff, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("staffByid", staffService.findStaffById(id));
            modelAndView.setViewName("admin/staff/deletestaff");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/nhanvien/deleted")
    ModelAndView deletedStaff(@ModelAttribute("staff") staff staff, @ModelAttribute("staffByid") Staff staffdeleted,
                              @PageableDefault(size = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            staffService.deleteStaff(staffdeleted);
            modelAndView.setViewName("admin/index");
            modelAndView.addObject("listStaff", staffService.findAllStaff(pageable));
            modelAndView.addObject("message", 1);
        } else {
            modelAndView.addObject("accountLogin", new accountLogin());
        }
        return modelAndView;
    }

    @GetMapping("/admin/nhanvien/edit/{id}")
    ModelAndView editStaff(@ModelAttribute("staff") staff staff, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("staffByid", staffService.findStaffById(id));
            modelAndView.setViewName("admin/staff/editstaff");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/nhanvien/edited")
    public ModelAndView editStaff(@ModelAttribute("staff") staff staff, @Valid @ModelAttribute("staffByid") Staff staffEdited,
                                  BindingResult bindingResultEdit, @PageableDefault(size = 10) Pageable pageable) {
        if (bindingResultEdit.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/staff/editstaff");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/index");
                staffService.saveStaff(staffEdited);
                modelAndView.addObject("listStaff", staffService.findAllStaff(pageable));
                modelAndView.addObject("message", 1);
            }
            modelAndView.addObject("accountLogin", new accountLogin());
            return modelAndView;
        }
    }

    @GetMapping("/admin/dichvu")
    public ModelAndView adminDichVu(@ModelAttribute("staff") staff staff, @PageableDefault(size = 10) Pageable pageable,
                                    @RequestParam Optional<String> keyword) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/index");
            String keywordLast = null;
            if (keyword.isPresent()) {
                keywordLast = keyword.get();
                modelAndView.addObject("listService", serviceService.findAllServiceByName(keywordLast, pageable));
            } else {

                modelAndView.addObject("listService", serviceService.findAllService(pageable));
            }
            modelAndView.addObject("message", 2);
            modelAndView.addObject("keyword", keywordLast);
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @GetMapping("/admin/dichvu/add")
    public ModelAndView addDichVu(@ModelAttribute("staff") staff staff) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/service/addservice");
            modelAndView.addObject("serviceNew", new ServiceValid());
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/dichvu/added")
    public ModelAndView checkValidDichVu(@ModelAttribute("staff") staff staff, @Valid @ModelAttribute("serviceNew") ServiceValid serviceValid,
                                         BindingResult bindingResult, @PageableDefault(size = 10) Pageable pageable) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/service/addservice");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/index");
                Service service = new Service(serviceValid.getName(),
                        Double.parseDouble(serviceValid.getArea()), Integer.parseInt(serviceValid.getNumberOfFloor()),
                        Integer.parseInt(serviceValid.getNumberOfMaxPeople()), Integer.parseInt(serviceValid.getPriceOfRent()),
                        serviceValid.getStatus(), typeRentSerVice.findTypeRentById(serviceValid.getIdTypeTent()),
                        typeSerViceService.findTypeServiceById(serviceValid.getIdTypeService()));
                service.setId(setidDV(serviceValid.getIdTypeService()));
                serviceService.saveService(service);
                modelAndView.addObject("listService", serviceService.findAllService(pageable));
                modelAndView.addObject("message", 2);
            }
            modelAndView.addObject("accountLogin", new accountLogin());
            return modelAndView;
        }
    }

    public String setidDV(int idtypeService) {
        String prefix;
        switch (idtypeService) {
            case 1:
                prefix = "VL-";
                break;
            case 2:
                prefix = "HO-";
                break;
            default:
                prefix = "RO-";
                break;
        }

        String idService;
        int id = 0;
        boolean flag = true;
        do {
            id++;
            String value = String.valueOf(id);
            switch (value.length()) {
                case 1:
                    value = "000" + value;
                    break;
                case 2:
                    value = "00" + value;
                    break;
                case 3:
                    value = "0" + value;
                    break;
                default:
                    value = value;
                    break;
            }
            idService = prefix + value;
            if (serviceService.findServiceById(idService) == null) {
                flag = false;
                break;
            }
        } while (flag);
        return idService;
    }

    @GetMapping("/admin/dichvu/read/{id}")
    ModelAndView readService(@ModelAttribute("staff") staff staff, @PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("serviceByid", serviceService.findServiceById(id));
            modelAndView.setViewName("admin/service/serviceinfor");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @GetMapping("/admin/dichvu/edit/{id}")
    ModelAndView editService(@ModelAttribute("staff") staff staff, @PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("serviceByid", serviceService.findServiceById(id));
            modelAndView.setViewName("admin/service/editservice");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/dichvu/edited")
    public ModelAndView editedService(@ModelAttribute("staff") staff staff, @Valid @ModelAttribute("serviceByid") Service serviceEdited,
                                      BindingResult bindingResultEdit, @PageableDefault(size = 10) Pageable pageable) {
        if (bindingResultEdit.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/staff/editstaff");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/index");
                serviceService.saveService(serviceEdited);
                modelAndView.addObject("listService", serviceService.findAllService(pageable));
                modelAndView.addObject("message", 2);
            }
            modelAndView.addObject("accountLogin", new accountLogin());
            return modelAndView;
        }
    }

    @GetMapping("/admin/dichvu/delete/{id}")
    ModelAndView deleteService(@ModelAttribute("staff") staff staff, @PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("serviceByid", serviceService.findServiceById(id));
            modelAndView.setViewName("admin/service/deleteservice");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/dichvu/deleted")
    ModelAndView deletedService(@ModelAttribute("staff") staff staff, @ModelAttribute("serviceByid") Service servicedeleted,
                                @PageableDefault(size = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            serviceService.deleteService(servicedeleted);
            modelAndView.setViewName("admin/index");
            modelAndView.addObject("listService", serviceService.findAllService(pageable));
            modelAndView.addObject("message", 2);
        } else {
            modelAndView.addObject("accountLogin", new accountLogin());
        }
        return modelAndView;
    }


    @GetMapping("/admin/khachhang")
    public ModelAndView adminKhachHang(@ModelAttribute("staff") staff staff, @PageableDefault(size = 10) Pageable pageable,
                                       @RequestParam Optional<String> keyword) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/index");
            String keywordLast = null;
            if (keyword.isPresent()) {
                keywordLast = keyword.get();
                modelAndView.addObject("listUser", userService.findAllUSerByNameID(keywordLast, pageable));
            } else {
                modelAndView.addObject("listUser", userService.findAllUser(pageable));
            }
            modelAndView.addObject("message", 3);
            modelAndView.addObject("keyword", keywordLast);
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @GetMapping("/admin/khachhang/add")
    public ModelAndView addKhachHang(@ModelAttribute("staff") staff staff) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/user/adduser");
            modelAndView.addObject("userNew", new validateUser());
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/khachhang/added")
    public ModelAndView checkValidKhachHang(@ModelAttribute("staff") staff staff, @Valid @ModelAttribute("userNew") validateUser userValid,
                                            BindingResult bindingResult, @PageableDefault(size = 10) Pageable pageable) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/user/adduser");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/index");
                User user = new User(userValid.getName(), userValid.getDayOfBirth(), userValid.getNumberOfCMND(),
                        userValid.getNumberPhone(), userValid.getEmail(), userValid.getAddress(),
                        typeUSerService.findTypeUser(userValid.getIdTypeUser()));
                user.setId(setid());
                userService.saveUser(user);
                modelAndView.addObject("listUser", userService.findAllUser(pageable));
                modelAndView.addObject("message", 3);
            }
            modelAndView.addObject("accountLogin", new accountLogin());
            return modelAndView;
        }
    }

    public String setid() {
        String prefix = "KH-";
        String idUser;
        int id = 0;
        boolean flag = true;
        do {
            id++;
            String value = String.valueOf(id);
            switch (value.length()) {
                case 1:
                    value = "000" + value;
                    break;
                case 2:
                    value = "00" + value;
                    break;
                case 3:
                    value = "0" + value;
                    break;
                default:
                    value = value;
                    break;
            }
            idUser = prefix + value;
            if (userService.findUserById(idUser) == null) {
                flag = false;
                break;
            }
        } while (flag);
        return idUser;
    }

    @GetMapping("/admin/khachhang/read/{id}")
    ModelAndView readUser(@ModelAttribute("staff") staff staff, @PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("userByid", userService.findUserById(id));
            modelAndView.setViewName("admin/user/userinfor");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @GetMapping("/admin/khachhang/edit/{id}")
    ModelAndView editUser(@ModelAttribute("staff") staff staff, @PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("userByid", userService.findUserById(id));
            modelAndView.setViewName("admin/user/edituser");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/khachhang/edited")
    public ModelAndView editedService(@ModelAttribute("staff") staff staff, @Valid @ModelAttribute("userByid") User userEdited,
                                      BindingResult bindingResultEdit, @PageableDefault(size = 10) Pageable pageable) {
        if (bindingResultEdit.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/user/edituser");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/index");
                userService.saveUser(userEdited);
                modelAndView.addObject("listUser", userService.findAllUser(pageable));
                modelAndView.addObject("message", 3);
            }
            modelAndView.addObject("accountLogin", new accountLogin());
            return modelAndView;
        }
    }


    @GetMapping("/admin/khachhang/delete/{id}")
    ModelAndView deleteUser(@ModelAttribute("staff") staff staff, @PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("userByid", userService.findUserById(id));
            modelAndView.setViewName("admin/user/deleteuser");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/khachhang/deleted")
    ModelAndView deletedUser(@ModelAttribute("staff") staff staff, @ModelAttribute("userByid") User userdeleted,
                             @PageableDefault(size = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            for (Contract c : userService.findUserById(userdeleted.getId()).contract) {
                for (ContractDetails cd : contractService.findContractById(c.getId()).contractDetails) {
                    contractDetailsService.deleteContractDetails(cd.getIdContractDetails());
                }
                contractService.deleteContract(contractService.findContractById(c.getId()));
            }
            userService.deleteUSer(userdeleted);
            modelAndView.setViewName("admin/index");
            modelAndView.addObject("listUser", userService.findAllUser(pageable));
            modelAndView.addObject("message", 3);
        } else {
            modelAndView.addObject("accountLogin", new accountLogin());
        }
        return modelAndView;
    }

    @GetMapping("/admin/hopdong")
    public ModelAndView adminHopDong(@ModelAttribute("staff") staff staff, @PageableDefault(size = 4) Pageable pageable,
                                     @RequestParam Optional<String> keyword) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/index");
            String keywordLast = null;
            if (keyword.isPresent()) {
                keywordLast = keyword.get();
                modelAndView.addObject("listContract", contractService.findAllContractByName(keywordLast, pageable));
            } else {
                for (Contract a : contractService.findAllContract()) {
                    a.setTotalCost();
                    contractService.saveContract(a);
                }
                modelAndView.addObject("listContract", contractService.findAllContract(pageable));
            }
            modelAndView.addObject("message", 4);
            modelAndView.addObject("keyword", keywordLast);
        }

        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @GetMapping("/admin/hopdong/add")
    public ModelAndView addHopDong(@ModelAttribute("staff") staff staff) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/contract/addcontract");
            modelAndView.addObject("contractNew", new validateContract());
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/hopdong/added")
    public ModelAndView checkValidHopDong(@ModelAttribute("staff") staff staff, @Valid @ModelAttribute("contractNew") validateContract contractValid,
                                          BindingResult bindingResult, @PageableDefault(size = 4) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/contract/addcontract");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/index");
                Contract contracta = new Contract(contractValid.contractDate, contractValid.endContractDate,
                        Integer.parseInt(contractValid.deposit), serviceService.findServiceById(contractValid.serviceId),
                        staffService.findStaffById(staff.getStaff().id),
                        userService.findUserById(contractValid.userId));
                contractService.saveContract(contracta);
                contracta.setTotalCost();
                contractService.saveContract(contracta);
                modelAndView.addObject("listContract", contractService.findAllContract(pageable));
                modelAndView.addObject("message", 4);
            } else {
                modelAndView.addObject("accountLogin", new accountLogin());
            }
            return modelAndView;
        }
    }

    @GetMapping("/admin/hopdong/edit/{id}")
    ModelAndView editContract(@ModelAttribute("staff") staff staff, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/contract/editcontract");
            modelAndView.addObject("contractByid", contractService.findContractById(id));
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/hopdong/edited")
    public ModelAndView editedContract(@ModelAttribute("staff") staff staff, @Valid @ModelAttribute("contractByid") Contract contractEdited,
                                       BindingResult bindingResultEdit, @PageableDefault(size = 4) Pageable pageable) {
        if (bindingResultEdit.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/contract/editcontract");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/index");
                contractEdited.setService(serviceService.findServiceById(contractEdited.service.id));
                contractEdited.setStaff(staff.getStaff());
                contractEdited.setTotalCost();
                contractEdited.setContractDetails((List<ContractDetails>)
                        contractDetailsService.findAllContractDetailsByName(contractEdited.getId()));
                contractService.saveContract(contractEdited);
                for (Contract a : contractService.findAllContract()) {
                    a.setTotalCost();
                    contractService.saveContract(a);
                }
                modelAndView.addObject("listContract", contractService.findAllContract(pageable));
                modelAndView.addObject("message", 4);
            }
            modelAndView.addObject("accountLogin", new accountLogin());
            return modelAndView;
        }
    }

    @GetMapping("/admin/hopdong/delete/{id}")
    ModelAndView deleteContract(@ModelAttribute("staff") staff staff, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("contractByid", contractService.findContractById(id));
            modelAndView.setViewName("admin/contract/deletecontract");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/hopdong/deleted")
    ModelAndView deletedContract(@ModelAttribute("staff") staff staff, @ModelAttribute("contractByid") Contract contractdeleted,
                                 @PageableDefault(size = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            for (ContractDetails a : contractService.findContractById(contractdeleted.getId()).getContractDetails()) {
                contractDetailsService.deleteContractDetails(a.getIdContractDetails());
            }
            contractService.deleteContract(contractdeleted);
            modelAndView.setViewName("admin/index");
            modelAndView.addObject("listContract", contractService.findAllContract(pageable));
            modelAndView.addObject("message", 4);
        } else {
            modelAndView.addObject("accountLogin", new accountLogin());
        }
        return modelAndView;
    }

    @GetMapping("/admin/hopdong/addhopdongchitiet/{id}")
    public ModelAndView addHopDongChiTiet(@ModelAttribute("staff") staff staff, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.setViewName("admin/contract/addcontractDetails");
            validConDe validConDe = new validConDe();
            validConDe.setContractId(id);
            modelAndView.addObject("contractDetailsNew", validConDe);
            modelAndView.addObject("contractss", contractService.findContractById(id));
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @PostMapping("/admin/hopdong/addhopdongchitieted")
    public ModelAndView checkValidHopDongChiTiet(@ModelAttribute("staff") staff staff, @Valid @ModelAttribute("contractDetailsNew") validConDe validConDe,
                                                 BindingResult bindingResult, @PageableDefault(size = 4) Pageable pageable) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/contract/addcontractDetails");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            if (staff.getStaff() != null) {
                modelAndView.setViewName("admin/index");
                ContractDetails contractDetails = new ContractDetails(Integer.parseInt(validConDe.getAmountContractDetails()),
                        serviceFollowService.findServiceFollowById(validConDe.getServicefollowId()),
                        contractService.findContractById(validConDe.getContractId()));
                contractDetailsService.saveContractDetails(contractDetails);
                contractDetails.getContract().setTotalCost();
                contractDetailsService.saveContractDetails(contractDetails);
                modelAndView.addObject("listContract", contractService.findAllContract(pageable));
                modelAndView.addObject("message", 4);
            } else {
                modelAndView.addObject("accountLogin", new accountLogin());
            }
            return modelAndView;
        }
    }

    @GetMapping("/admin/hopdong/read/{id}")
    ModelAndView readContract(@ModelAttribute("staff") staff staff, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (staff.getStaff() != null) {
            modelAndView.addObject("contractByid", contractService.findContractById(id));
            modelAndView.addObject("contractss", contractDetailsService.findAllContractDetailsByName(id));
            modelAndView.setViewName("admin/contract/contractinfor");
        }
        modelAndView.addObject("accountLogin", new accountLogin());
        return modelAndView;
    }

    @GetMapping("/hinhanh")
    ModelAndView photo(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal) {
        ModelAndView modelAndView = new ModelAndView("user/photo");
        return modelAndView;
    }

    @GetMapping("/khuyenmai")
    ModelAndView discount(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal) {
        ModelAndView modelAndView = new ModelAndView("user/discount");
        return modelAndView;
    }

    @GetMapping("/Review")
    ModelAndView review(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal) {
        ModelAndView modelAndView = new ModelAndView("user/review");

        return modelAndView;
    }
    @GetMapping("/HocVien")
    ModelAndView hv(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal) {
        ModelAndView modelAndView = new ModelAndView("user/BTVN");
        return modelAndView;
    }

    @GetMapping("/signup")
    ModelAndView signup(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal) {
        ModelAndView modelAndView = new ModelAndView("user/signup");
        modelAndView.addObject("userNew", new validateAccountUser());
        return modelAndView;
    }

    @PostMapping("/signuped")
    public ModelAndView checkValidationSign(@ModelAttribute("staff") staff staff, @ModelAttribute("usernormal") usernormal usernormal,
                                            @Valid @ModelAttribute("userNew") validateAccountUser validateAccountUser,
                                            BindingResult bindingResult, @PageableDefault(size = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("admin/index");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("user/signup");
            return modelAndView;
        } else {
            modelAndView.setViewName("user/index");
            accountUserNormal accountUserNormal = new accountUserNormal(validateAccountUser.name, validateAccountUser.dayOfBirth,
                    validateAccountUser.numberOfCMND, validateAccountUser.numberPhone, validateAccountUser.email, validateAccountUser.address,
                    validateAccountUser.account, validateAccountUser.password);
            userNormalService.saveUser(accountUserNormal);
            if (staff.getStaff() != null && usernormal.getAccountUserNormal() == null) {
                modelAndView.setViewName("admin/index");
            } else if (staff.getStaff() == null && usernormal.getAccountUserNormal() == null) {
                usernormal.setAccountUserNormal(accountUserNormal);
            }
            return modelAndView;
        }
    }
}

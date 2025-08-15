package com.system.college_erp_system.service.application;

import com.system.college_erp_system.model.party.Party;
import com.system.college_erp_system.model.party.contactMech.ContactMech;
import com.system.college_erp_system.model.party.contactMech.PartyContactMech;
import com.system.college_erp_system.model.party.contactMech.PhoneNumber;
import com.system.college_erp_system.model.party.contactMech.PostalAddress;
import com.system.college_erp_system.service.party.PartyService;
import com.system.college_erp_system.service.party.contactMech.ContactMechService;
import com.system.college_erp_system.service.party.contactMech.PartyContactMechService;
import com.system.college_erp_system.service.party.contactMech.PhoneNumberService;
import com.system.college_erp_system.service.party.contactMech.PostalAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {
    @Autowired
    private PartyService partyService;
    @Autowired
    private PersonService personService;
    @Autowired
    private PartyRoleService partyRoleService;
    @Autowired
    private PartyRoleDetailsService partyRoleDetailsService;
    @Autowired
    private ContactMechService contactMechService;
    @Autowired
    private PhoneNumberService phoneNumberService;
    @Autowired
    private PostalAddressService postalAddressService;
    @Autowired
    private PartyContactMechService partyContactMechService;

    public void createStudent(Party p, Person per, PartyRole prl, PartyRoleDetails prld, ContactMech cm1, PartyContactMech pcm1,
                              ContactMech cm2, PhoneNumber pn, PartyContactMech pcm2, ContactMech cm3, PostalAddress pa, PartyContactMech pcm3){

        if (prl.getPartyRoleType().getEnumId().equals("STUDENT")) {

            Long partyId = partyService.createParty(p);
            per.setPartyId(partyId);
            personService.createPerson(per);

            partyRoleService.createPartyRole(prl);
//            partyRoleDetailsService.createPartyRoleDetails(prl);

            if (cm1.getContactMechType().getEnumId().equals("EMAIl")) {
                contactMechService.createContactMech(cm1);
                Long contactMechId1 = cm1.getContactMechId();
                pcm1.setPartyContactMechId(contactMechId1);
                partyContactMechService.createPartyContactMech(pcm1);
            }

            if (cm2.getContactMechType().getEnumId().equals("PHONE_NUMBER")) {
                Long contactMechId2 = contactMechService.createContactMech(cm2);
                pn.setContactMechId(contactMechId2);
                phoneNumberService.createPhoneNumber(pn);
                pcm2.setPartyContactMechId(contactMechId2);
                partyContactMechService.createPartyContactMech(pcm2);
            }

            if (cm2.getContactMechType().getEnumId().equals("POSTAL_ADDRESS")) {
                Long contactMechId3 = contactMechService.createContactMech(cm3);
                pa.setContactMechId(contactMechId3);
                postalAddressService.createPostalAddress(pa);
                pcm3.setPartyContactMechId(contactMechId3);
                partyContactMechService.createPartyContactMech(pcm3);
            }
        }
    }
}

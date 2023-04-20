package com.nexential.springbootonetooneexam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexential.springbootonetooneexam.entity.People;
import com.nexential.springbootonetooneexam.repository.BankRepository;
//import com.nexential.springbootonetooneexam.repository.BankRepository;
import com.nexential.springbootonetooneexam.repository.PeopleRepository;


@RestController
public class Controller 
{
	@Autowired
	private PeopleRepository peoplerepo;
	@Autowired
	private BankRepository bankrepo;
	

    @GetMapping("/{pageNo}/{pageSize}/{id}")
    public ResponseEntity<List<People>> getUsers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<People> users = peoplerepo.findAll(paging);

        if (users.hasContent()) 
        {
            return new ResponseEntity<>(users.getContent(), HttpStatus.OK);
        } 
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
	@PostMapping("/save")
	public ResponseEntity<People> createUser(@RequestBody People user){
		People savedUser = peoplerepo.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	@GetMapping("/get")
	public ResponseEntity<List<People>>getAllpeople()
	{
		List<People> ppl=peoplerepo.findAll();
		return new ResponseEntity<>(ppl,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<People>getpeopleById(@PathVariable long id)
	{
		Optional<People>ppl=peoplerepo.findById(id);
		return new ResponseEntity<>(ppl.get(),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletepeople(@PathVariable long id)
	{
		peoplerepo.deleteById(id);
		bankrepo.deleteById(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/put/{id}")
	public ResponseEntity<People>updateperson(@PathVariable("id") Long id,@RequestBody People p)
	{
		Optional<People>ppl=peoplerepo.findById(id);
		if(ppl.isPresent())
		{
			ppl.get().setName(p.getName());
			ppl.get().setDateofbirth(p.getDateofbirth());
			ppl.get().setBank(p.getBank());
			return new ResponseEntity<>(peoplerepo.save(ppl.get()),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
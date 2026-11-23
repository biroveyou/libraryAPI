package LibraryAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @GetMapping
    public List<Publisher> ListPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @PutMapping
    public Publisher updatePublisher(@PathVariable Long id, @RequestBody Publisher newPublisher) {
        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);
        if (optionalPublisher.isPresent()) {
            Publisher publisher =  optionalPublisher.get();
            publisher.setName(newPublisher.getName());
            publisher.setAddress(newPublisher.getAddress());
            publisher.setWebsite(newPublisher.getWebsite());
            publisher.setFoundationYear(newPublisher.getFoundationYear());
            return publisherRepository.save(publisher);
        }
        return null;
    }

    @DeleteMapping
    public void deletePublisher(@PathVariable Long id) {
        publisherRepository.deleteById(id);
    }
}

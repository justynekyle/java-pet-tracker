We don't know about you, but we have a lot of trouble keeping track of our pets. We have so many, and we can never remember if it's the bulldog or the tabby cat that is named "Honey". We're going to build an app to keep track of them!

## Getting Started

```no-highlight
et get java-pet-tracker
cd java-pet-tracker
createdb pet_tracker_development
idea .
```

## Meets Expectations Criteria

### List Your Pets

```no-highlight
As a pet owner
I want to see a listing of my pets
So that I can figure out who is who
```

Acceptance Criteria:

- When a user navigates to `/pets` they should see a paginated list of pets from the database

Implementation Details:

- Use the provided `index.html` view template to render this page


### Create Your Pets via Web Form

```no-highlight
As a pet owner
I want to be able to enter pets via a form
To show them I love them
```

Acceptance Criteria:

- When a user navigates to `/pets/new`, they should see the form to add a new pet
- Submitting this form persists the new pet to the database
- Saving your pet successfully should redirect to `/pets`
- You do not need to handle for invalid input to Meet Expectations

Implementation Details:

- Use the provided `new.html` view template to render the form to the page

### List Your Pets via API

```no-highlight
As a pet owner
I want to make my pets available via an API
So that we can build a mobile app
```

Acceptance Criteria:

- Create a new Controller that can serve JSON data for your pets
- visiting `/api/v1/pets` should display a JSON of the pets from your database

## Exceeds Expectations Criteria

### Normalize your Animals

```no-highlight
As a pet owner
I want to separate my pets by species
So I can see all of my pets by one species at a time
```

Acceptance Criteria:

- The animal's species must be normalized to a separate table, and referenced through an association
- The user can still enter the species as text, but your persisting routine should either find or create the animal's species in a related table

### Species Show Page

```no-highlight
As a pet owner
I want to see all of my animals of one species on one page
So I can keep them organized in my head
```

Acceptance Criteria:

- When a user goes to `/species/{id}`, they should see the name of the given species
- They should also see a list of all pets of that species
- There should be a link to go back to the main `/pets` index page


### Validate

```no-highlight
As a pet owner
I want to ensure the form is filled out correctly
So my fans don't see incorrect information
```

Acceptance Criteria:

- If a user fills out the form incorrectly, the form should be re-rendered with their existing input
- Helpful errors should appear on the page
- When they submit properly, the pet should still be saved to the database and the user redirected to `/pets`

Implementation Details:

- `Name`
  - Cannot be empty or just white space
  - Must be a string greater than 0 and less than 20 characters
  - Must be present
- `Species`
  - Must be present
- `Breed`
  - Cannot be empty or just white space
  - Must be a string greater than 0 and less than 15 characters
  - Cannot contain numbers
- `Age`
  - Must be greater than 0
  - Must be 1-3 digits
  - Must be present
- `Fixed`
  - Must be present

### Create Seeders

```no-highlight
As a pet owner
I want to add my own pets
So I can show them off
```

Acceptance Criteria:

- Create a `Species` seeder file, with at least 2 seeded species.
- Create a `Pet` seeder file, which uses previously seeded species to seed at least 3 pets.

### API-based Pet Creation

```no-highlight
As a pet owner
I want to allow others to create pets
So that I can foster them
```

Acceptance Criteria:

- Create a PostMapping for the `PetsApiController`
- Ensure using CURL that the endpoint works as expected
  - Include your CURL command as a comment in the code
# user-management

## Create a user management system such that -

A user is defined as

1. Username
2. password
3. email
4. Firstname,
5. Last Name
6. date of birth

A team of admins creates a user into the system with a random generated password. The end user when he comes to the system does have the capability to regenerate his password and has the ability to edit all fields except for username.

Password to be generated has a set of rules.
1. Should be at least 8 chars long.
2. Should have 1 alphabet
3. Should have 1 numeral.
4. Should have 1 special char

## Requirements.
1. Rest api for admins to  create a user.
2. Rest api for end user to login.
3. Rest api for end user to change his password.
4. Rest api for end user to edit
5. Rest api for admins to view all users.
6. Rest api for admins to view user details.
7. Activity log persisted for each user who is doing set actions and each user who is calling get apis.
## Signing Commits

- gpg --full-generate-key
- gpg --list-secret-keys --keyid-format LONG
- - /Users/admin/.gnupg/pubring.kbx
- - - sec   rsa3072/<your_key_id> 2025-04-27 [SC]
- - - 000000000000000000000000<your_key_id>
- - - uid                 [ultimate] <your_realname> <<your_email>>
- - - ssb   rsa3072/0000000000000000 2025-04-27 [E]
- git config --global user.signingkey <your_key_id>
- git config --global commit.gpgSign true 
- gpg --armor --export <your_email>

### Checking your commits

- git log --show-signature

## Branches

- main (default)
- lastpolukrovka

### Pull Requests

- lastpolukrovka -> main (default)
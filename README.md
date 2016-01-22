# thelema

This project was created from the 
[cljs-lambda](https://github.com/nervous-systems/cljs-lambda) 
template by Nervous Systems (AKA nervous.io).

To use such a handy project template for your own lambda projects, you will need to install
[Leiningen](http://leiningen.org) and [AWS CLI](http://github.com/aws/cli). You will then need
create at least a single IAM role with one privledge of `administrator access` if you want to be
able to dynamically create IAM roles from within the project command line. You do this
by selecting the IAM roles service in your AWS console and creating it. Then download the 
credentials and create a default config file located in `~/.aws/config` looking much like this:

```
[default]
aws_access_key_id=YOURDOWNLOADEDKEYFROMCREDENTIALSFROMCREDENTIALSFILE
aws_secret_access_key=YourDownloadedAccessKeyFromCredentialsFile
region=us-east-1
```

Keep this file secure which implies reasonable permissions. Make sure you delete the downloaded creds files, too!

## Config

Configure this template's magic word by editing the `config.edn` file.

## Deploying

### Using dynamic IAM roles

Run `lein cljs-lambda default-iam-role` if you don't have yet have suitable
execution role to place in your project file.  This command will create an additional 
IAM role under your default (or specified) AWS CLI profile, and modify your project
file to specify it as the execution default.

# Use an existing IAM role

Otherwise, manually add an IAM role ARN under the function's `:role` key in the
`:functions` vector of your profile file, or in `:cljs-lambda` -> `:defaults` ->
`:role`.

Then:

```sh
$ lein cljs-lambda deploy
$ lein cljs-lambda invoke work-magic '{"magic-word": "your fine magic word", "spell": "delay"}'
```

This will execute the lamba function exposed in `core.cljs`

## Testing

```sh
lein doo node thelema-test
```

Doo is provided to avoid including code to tell `cljs.test` to exit the Node
process after a test run.

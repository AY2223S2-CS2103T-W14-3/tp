---
layout: page
title: User Guide
---
## **Overview**
GoodMatch (GM) is a **desktop app for managing applicants and job listings, optimised for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, GM can get your applicant and job listing management tasks done faster than traditional GUI apps

### Table of Contents
* [Quick Start](#quick-start)
* [Features](#features)
  * [Viewing help: `help`](#viewing-help-help)
  * [Viewing all job listings: `view`](#viewing-all-job-listings-view)
  * [Adding a job listing: `add`](#adding-a-job-listing-add)
  * [Editing a job listing: `edit`](#editing-a-job-listing-edit)
  * [Deleting a job listing: `delete`](#deleting-a-job-listing-delete)
  * [Locating job listings by title: `find`](#locating-job-listings-by-title-find)
  * [Sorting job listings: `sort`](#sorting-job-listings-sort)
  * [Filtering job listings `[coming in v2.0]`](#filtering-job-listings-coming-soon)
  * [Tagging a job listing `[coming in v2.0]`](#tagging-a-job-listing-coming-soon)
* [FAQ](#faq)
* [Command Summary](#command-summary)

### Purpose
Welcome to the user guide for GoodMatch. This guide will help you understand how to use GoodMatch to streamline your recruitment process and find the best candidates for your company.

### How to use this guide
To make the most of this guide, start by reading it from beginning to end. We recommend that you familiarize yourself with the basic concepts before moving on to the advanced topics.

Use the interactive [table of contents](#table-of-contents) to navigate through the document quickly. Simply click on the bullet points to be taken to the relevant subsection. Follow the step-by-step instructions, screenshots, and examples to get the most out of the guide.

--------------------------------------------------------------------------------------------------------------------
## **Quick Start**

1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `goodmatch.jar` from [here](https://github.com/AY2223S2-CS2103T-W14-3/tp/releases/tag/v1.2).
3. Copy the file to the folder you want to use as the *home folder* for your GoodMatch.
4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar goodmatch.jar` command to run the application.


A GUI similar to the one below should appear in a few seconds.

![Mock Up](./images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing  **`help`**  and pressing Enter will open the help window.

Some example commands you can try:
    - add something here
6. Refer to the [Features](#features) below for details of each command.

###### _< Back to [Table of Contents](#table-of-contents) >_

## **Features**


ℹ️ **Notes about the command format:**

- Words in `UPPER_CASE` are the parameters to be supplied by the user.e.g. in `add t/TITLE`, `TITLE` is a parameter which can be used as `add t/Chicken Rice Uncle`.
- Items in square brackets are optional.e.g `t/TITLE [a/APPLICANT]...` can be used as `t/Chicken Rice Uncle a/John Tan` or as `t/Chicken Rice Uncle`.
- Items with `…` after them can be used multiple times including zero times.e.g. `[a/APPLICANT]…` can be used as  `` (i.e. 0 times), `a/applicant1`, `a/applicant2 a/application3` etc.
- Parameters can be in any order.e.g. if the command specifies `t/TITLE d/DESCRIPTION`, `d/DESCRIPTION t/TITLE` is also acceptable.
- If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.e.g. if you specify `t/Chicken Rice Uncle t/Chicken Rice Auntie`, only `t/Chicken Rice Uncle` will be taken.
- Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored. e.g. if the command specifies `help 123`, it will be interpreted as `help`.


### Viewing help: `help`

Shows a message explaining how to access the help page.

![Help Message](./images/helpMessage.png)

**Format:** `help`
###### _< Back to [Table of Contents](#table-of-contents) >_

### Viewing all job listings: `view`

Lists out all the jobs that are currently in the listing book.

**Format:** `view`

**Expected Output:**
- You should see all the listings that are currently in your listing book, as well as the confirmation message:
```ignorelang
Listed all listings
```
###### _< Back to [Table of Contents](#table-of-contents) >_

## Adding a job listing: `add`

Adds a listing to the listing book.

**Format:** `add t/TITLE d/DESCRIPTION [a/APPLICANT]...`


**Tips:**

- A listing can have any number of applicants (including 0)

**Examples:**

- `add t/Chicken Rice Uncle d/Cooks tasty chicken rice a/Nicholas a/Tom a/Adele`
- `add t/NodeFlair SWE Intern d/Fullstack Experience`

**Expected Output:**
You should see a confirmation message showing the job title, description and applicants (if any). An example is shown below:
```ignorelang
New listing added: Chicken Rice Uncle; JobDescription: Cooks tasty chicken rice; Applicants: Nicholas, Tom, Adele
```

**Possible Error:**
If the above format is not followed, an error message will display:
```ignorelang
Invalid Command Format!
add: Adds a listing to the listing book. Parameters: t/TITLE d/DESCRIPTION [a/APPLICANT]...
Example: add t/Cool job title d/Informative job description a/John a/Sam
```
###### _< Back to [Table of Contents](#table-of-contents) >_

### Editing a job listing: `edit`

Edits the details of a job listing.

**Format:** `edit NUMBER t/TITLE d/DESCRIPTION [a/APPLICANTS...]`

**Tips:**

- Ensure that `NUMBER` is valid (ie. its is non-negative and not greater than the number of tasks) or an error will occur!
- Only the details included in the command will be edited. eg. if the command entered is:

     `edit 1 t/Chicken Rice Uncle d/Cooks tasty chicken rice`

    then only the title and the description of task 1 will be edited (the applicants will remain unchanged)

**Examples:**

- `edit 1 t/Noodle seller d/Cooks tasty noodles a/Johnson`
- `edit 2 t/Videographer d/Films videos`

**Expected Output:**

You will see a confirmation message showing the edited job title, description and applicants (if any).
An example is shown below:
```ignorelang
Edited Listing: Noodle seller; JobDescription: Cooks tasty noodles; Applicants: Johnson
```

**Possible Error:**

An valid index must be provided, and at least one field of the listing must be edited. Otherwise, one of the error
messages shown below will be displayed.
```ignorelang
Invalid command format!
edit: Edits a listing in the listing book. by the index number used in the displayed listing book. Existing values will be overwritten by the input values.
Parameters: INDEX (must be a positive integer) [t/TITLE] [d/DESCRIPTION] [a/APPLICANT]...
[a/APPLICANT (optional)]...
Example: edit 1 t/Cool job title a/John a/Sam
```
```ignorelang
The listing index provided is invalid
```
###### _< Back to [Table of Contents](#table-of-contents) >_

### Deleting a job listing: `delete`

Deletes a job listing from the listing book.

**Format:** `delete NUMBER`

**Tips:**

- Ensure that `NUMBER` is valid (ie. its is non-negative and not greater than the number of tasks) or an error will occur!

**Examples:**

- `delete 1`

**Expected Output:"**

A confirmation message will show, along with the details of the listing. An example message is shown below:
```ignorelang
Listing: Chicken farmer; JobDescription: farms chickens; Applicants: topsy mcddaddy, column verctoa has been deleted!
```

**Possible Error:**
If an index is invalid or absent, an error message such as the one below will be displayed.
```ignorelang
Invalid command format!
delete: Deletes the listing identified by the index number used in the displayed listing book.
Parameters: INDEX (must be a positive integer)
Example: delete 1
```
```ignorelang
The listing index provided is invalid
```
###### _< Back to [Table of Contents](#table-of-contents) >_

### Locating job listings by title: `find`

Finds job listings whose titles contain any of the given keywords.

**Format:** `find KEYWORD [MORE_KEYWORDS]`

**Tips:**

- The search is case-insensitive. eg. `software` will match `Software`
- The order of the keywords does not matter. e.g. `Software Developer` will match `Developer Software`
- Only the title is searched.
- Only full words will be matched e.g. `Engineer` will not match `Engineering`
- Job listings matching at least one keyword will be returned (i.e. `OR` search). e.g. `Software Developer` will return `Software Engineer`, `Microservices Developer`

**Examples:**

- `find Software` returns `software` and `Software Developer`
- `find Software Engineer` returns `Software Developer` and `Chemical Engineer`

**Expected Output**:
A confirmation message will display. The message indicates the number of listings which match the given keyword(s).
An example is shown below.
```ignorelang
1 listings shown!
```
If no listings match the keyword(s), the following message will show:
```ignorelang
0 listings shown!
```

**Possible Error**
If no keyword is provided, an error message will display:
```ignorelang
Invalid command format!
find: Finds all listings whose titles contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.
Parameters: KEYWORD [MORE_KEYWORDS]...
Example: find chicken rice
```
###### _< Back to [Table of Contents](#table-of-contents) >_

### Sorting job listings: `sort`

Sort job listings by the field specified by the user and display the sorted list of job listings.

**Format:** `sort f/[FIELD]`

- The possible fields are: `title` , `description` , `applicants`


**Tips:**
- The `title` field sorts the listings in alphabetical order of their title fields.
- The `description` field sorts the listings in alphabetical order of their listings.
- The `applicants` field sorts the listings in increasing number of applicants.
- Note that if more than one field is provided, the last field will be taken into consideration.

**Examples:**

- `sort f/title`
- `sort f/description`

**Expected Output:**
A confirmation message will show:
```ignorelang
Listings have been sorted.
```

**Possible Error:**
If the `field` is not present, an error message will show:
```ignorelang
Invalid command format!
sort: Sorts the listing displayed according to the specified field.
Parameters: f/FIELD_COMPARED(none, title, description, applicants)
Example: sort f/applicants
```
###### _< Back to [Table of Contents](#table-of-contents) >_

### Filtering job listings [coming soon!]

Sort job listings by the field specified by the user and display the sorted list of job listings.

**Format:** `filter attribute/[POSSIBLE_FIELDS] by/[SOME_VALUE]`

**Tips:**

- The possible fields are: `expiry date`  , `num_of_applicants`  , `...`
- Fields have to be numerical
- Metrics can be more than or less than or equal

**Examples:**

- `filter attribute/num_of_applicants by/>= 5`
###### _< Back to [Table of Contents](#table-of-contents) >_

### Tagging a job listing [coming soon]

Add tags to a job listing for easy reference.
###### _< Back to [Table of Contents](#table-of-contents) >_

---

## **FAQ**
**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous GoodMatch home folder.
###### _< Back to [Table of Contents](#table-of-contents) >_

---

## **Command summary**
| Action     | Format, Examples                                                                                                                     |
|------------|--------------------------------------------------------------------------------------------------------------------------------------|
| **add**    | `add t/TITLE d/DESCRIPTION [a/APPLICANTS]` <br> e.g., `add t/Chicken Rice Uncle d/Cooks tasty chicken rice a/Nicholas a/Tom a/Adele` |
| **delete** | `delete INDEX`<br> e.g., `delete 3`                                                                                                  |
| **edit**   | `edit [t/TITLE] d/DESCRIPTION [a/APPLICANTS]`<br> e.g.,`edit 2 t/Noodle Seller d/Makes tasty noodles`                                |
| **find**   | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find Chicken Noodle`                                                                       |
| **view**   | `view`                                                                                                                               |
| **help**   | `help`                                                                                                                               |
###### _< Back to [Table of Contents](#table-of-contents) >_

package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPLICANT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.listing.Listing;

/**
 * Adds a listing to the listing book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits a listing in the listing book. "
            + "INDEX (must be positive integer) "
            + "Parameters: "
            + PREFIX_TITLE + "TITLE (optional)"
            + PREFIX_DESCRIPTION + "DESCRIPTION (optional)"
            + "[" + PREFIX_APPLICANT + "APPLICANT (optional)]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_TITLE + "Cool job title "
            + PREFIX_DESCRIPTION + "Informative job description "
            + PREFIX_APPLICANT + "John "
            + PREFIX_APPLICANT + "Sam";

    public static final String MESSAGE_SUCCESS = "Listing is changed to: %1$s";
    public static final String MESSAGE_FAILURE = "Please provide the correct parameters.";

    private final Listing listingToAdd;

    /**
     * Creates an AddCommand to add the specified {@code Listing}
     */
    public EditCommand(Listing listingToAdd) {
        requireNonNull(listingToAdd);
        this.listingToAdd = listingToAdd;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasListing(listingToAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_LISTING);
        }

        model.addListing(listingToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, listingToAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EditCommand // instanceof handles nulls
                && listingToAdd.equals(((EditCommand) other).listingToAdd));
    }
}

package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPLICANT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;
import java.util.List;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.applicant.Applicant;
import seedu.address.model.listing.Listing;

/**
 * Adds an applicant to a listing identified using it's displayed index from the listing book.
 */
public class AddApplicantCommand extends Command {

    public static final String COMMAND_WORD = "add_app";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an applicant to a listing in the listing book. "
            + "Parameters: INDEX (must be a positive integer)\n"
            + PREFIX_APPLICANT + "APPLICANT\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_APPLICANT + "John Doe";


    public static final String MESSAGE_SUCCESS = "Applicant %1$s added to listing %2$s";

    private final Index targetIndex;
    private final Applicant applicantToAdd;

    /**
     * Creates an AddApplicantCommand to add the specified {@code Applicant} to {@code Listing}
     * @param targetIndex the displayed index of the listing to change
     * @param applicantToAdd the applicant to be added
     */
    public AddApplicantCommand(Index targetIndex, Applicant applicantToAdd) {
        requireNonNull(targetIndex);
        requireNonNull(applicantToAdd);

        this.targetIndex = targetIndex;
        this.applicantToAdd = applicantToAdd;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Listing> lastShownList = model.getFilteredListingList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_LISTING_DISPLAYED_INDEX);
        }

        Listing listingToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteListing(listingToDelete);

        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AddApplicantCommand)) {
            return false;
        }

        AddApplicantCommand that = (AddApplicantCommand) o;

        if (!targetIndex.equals(that.targetIndex)) {
            return false;
        }
        return applicantToAdd.equals(that.applicantToAdd);
    }

}
